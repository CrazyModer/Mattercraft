package net.crazymoder.mattercraft.tileentity.core;

import java.util.ArrayList;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ReactorCoreTile extends TileEntity{

	//Renderer
		public float rotation = 0f;
	//********
		
	//declaration
		public GuiHandler guiHandler;
		public LogisticHandler logisticHandler;
	//**************
		
	//atributes
		public int state;
	//*****************
	
	private int updatembstick = 40;
	
	private int x = xCoord;
	private int y = yCoord;
	private int z = zCoord;
	private World w = worldObj;
	private int xO = 0;//Offset
	private int yO = 0;
	private int zO = 0;
	
	
	public ReactorCoreTile(){
		state = 1;
		render = false;
		logisticHandler = new LogisticHandler();
		guiHandler = new GuiHandler(logisticHandler);
	}
	
	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(!worldObj.isRemote){
			if(state >= 2){
				boolean logOK = logisticHandler.checkLogistic(this);
				if(state < 3 && logOK)state = 3;
				if(!logOK)state = 2;
			}
			updatembstick--;
			if(updatembstick == 0){
				updatembstick = 40;
				updatembs();
			}
			updateGui();
			updateRenderer();
		}
		super.updateEntity();
	}
	
	private void updateGui(){
		guiHandler.status = state;
		guiHandler.update();
	}
	
	private void updateRenderer(){
		render = state == 3;
	}
	
	private void updatembs(){
		MultiBlockStructurManager.init(worldObj, xCoord, yCoord, zCoord);
		boolean mbsOK = MultiBlockStructurManager.checkReactorCoreMBS();
		if(state < 2 && mbsOK)state = 2;
		if(!mbsOK)state = 1;
	}
	public boolean render;
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		logisticHandler.writeNBT(tagCompound);
		writeSyncableDataToNBT(tagCompound);
	}

	private void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setBoolean("render", render);
		guiHandler.writeSyncableDataToNBT(tagCompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		logisticHandler.readNBT(tagCompound);
		readSyncableDataFromNBT(tagCompound);
	}

	private void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		if(!tagCompound.hasNoTags()){
			render = tagCompound.getBoolean("render");
		}
		guiHandler.readSyncableDataFromNBT(tagCompound);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound syncData = new NBTTagCompound();
		writeSyncableDataToNBT(syncData);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readSyncableDataFromNBT(pkt.func_148857_g());
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}
	
}
