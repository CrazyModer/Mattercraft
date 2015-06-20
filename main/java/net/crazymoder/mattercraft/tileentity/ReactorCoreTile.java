package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;
import java.util.ListIterator;

import org.lwjgl.Sys;

import net.crazymoder.mattercraft.Mattercraft;
import net.crazymoder.mattercraft.helper.reactorcore.Calculator;
import net.crazymoder.mattercraft.helper.reactorcore.GuiHandler;
import net.crazymoder.mattercraft.helper.reactorcore.LogisticHandler;
import net.crazymoder.mattercraft.helper.reactorcore.MultiBlockStructurManager;
import net.crazymoder.mattercraft.helper.reactorcore.RenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ReactorCoreTile extends TileEntity{

		
	//declaration
		public GuiHandler guiHandler;
		public LogisticHandler logisticHandler;
		public RenderingHandler renderingHandler;
		public Calculator calculator;
	//**************
		
	//atributes
		public int state;
		public int oldstate;
	//*****************
	private int updateMbsTick = 40;
	
	
	
	public ReactorCoreTile(){
		state = 1;
		logisticHandler = new LogisticHandler();
		calculator = new Calculator(this);
		guiHandler = new GuiHandler(this);
		renderingHandler = new RenderingHandler(this);
	}
	
	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(!worldObj.isRemote){
			oldstate = state;
			if(state >= 2){
				boolean logOK = logisticHandler.checkLogistic(this);
				if(state < 3 && logOK)state = 3;
				if(!logOK)state = 2;
			}
			updateMbsTick--;
			if(updateMbsTick == 0){
				updateMbsTick = 40;
				MultiBlockStructurManager.init(worldObj, xCoord, yCoord, zCoord);
				boolean mbsOK = MultiBlockStructurManager.checkReactorCoreMBS();
				if(state < 2 && mbsOK)state = 2;
				if(!mbsOK)state = 1;
			}
			if(state == 3)
				activate();
			if(oldstate == 4 && state < 4)
				deactivate();
			if(state == 4){
				calculator.calculate();
				killPlayers();
			}
			guiHandler.update();
			renderingHandler.update();
		}else{
			if(renderingHandler.render)
				Mattercraft.proxy.render(worldObj, xCoord, yCoord, zCoord);
		}
	}
	
	
	private void activate(){
		Block b1 = worldObj.getBlock(xCoord, yCoord+12, zCoord);
		Block b2 = worldObj.getBlock(xCoord, yCoord+13, zCoord);
		if(b1.getUnlocalizedName().equals("tile.mtc.unstableMatter")&&b2.getUnlocalizedName().equals("tile.fire")&&calculator.canactivate()){
			worldObj.setBlock(xCoord, yCoord+12, zCoord, Blocks.air);
			state = 4;
			calculator.activate();
			worldObj.createExplosion(null, xCoord, yCoord+12, zCoord, 50f, false);
			System.out.println("activate");
		}
	}
	
	public void deactivate(){
		worldObj.createExplosion(null, xCoord, yCoord+12, zCoord, 6f, true);
		worldObj.createExplosion(null, xCoord, yCoord+12, zCoord, 150f, false);
		state = 1;
		calculator.deactivate();
		System.out.println("deactivate");
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		logisticHandler.writeNBT(tagCompound);
		calculator.writeSyncableDataToNBT(tagCompound);
		tagCompound.setInteger("main_state", state);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		logisticHandler.readNBT(tagCompound);
		calculator.readSyncableDataFromNBT(tagCompound);
		state = tagCompound.getInteger("main_state");
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tagCompound = new NBTTagCompound();
		calculator.writeSyncableDataToNBT(tagCompound);
		guiHandler.writeSyncableDataToNBT(tagCompound);
		renderingHandler.writeSyncableDataToNBT(tagCompound);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tagCompound = pkt.func_148857_g();
		calculator.readSyncableDataFromNBT(tagCompound);
		guiHandler.readSyncableDataFromNBT(tagCompound);
		renderingHandler.readSyncableDataFromNBT(tagCompound);
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}
	
	private void killPlayers(){
		ListIterator itl = worldObj.playerEntities.listIterator();
		double x = xCoord;
		double y = yCoord + 12;
		double z = zCoord;
			while(itl.hasNext()){
				EntityPlayerMP player = (EntityPlayerMP) itl.next();
				double posX = player.posX;
				double posY = player.posY;
				double posZ = player.posZ;
				double dist = Math.sqrt(Math.pow(x-posX, 2)+Math.pow(y-posY, 2)+Math.pow(z-posZ, 2));
				if(dist < 11.5f && !player.theItemInWorldManager.isCreative()){
					player.setPositionAndUpdate(posX+12, 400, posZ+12);
				}
			}
	}
	
}
