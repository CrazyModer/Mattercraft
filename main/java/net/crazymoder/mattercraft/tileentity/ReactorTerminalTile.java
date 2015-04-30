package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;

import net.crazymoder.mattercraft.tileentity.core.GuiHandler;
import net.crazymoder.mattercraft.tileentity.core.ReactorCoreTile;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ReactorTerminalTile extends TileEntity{

	public int status;
	public int cryotheum;
	
	public ReactorCoreTile core;
	public ReactorTerminalTile(){
		core = null;
	}


	private void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("status", status);
		tagCompound.setInteger("cryotheum", cryotheum);
		
	}

	private void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		status = tagCompound.getInteger("status");
	    cryotheum = tagCompound.getInteger("cryotheum");
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
	public void updateEntity() {
		super.updateEntity();
		if(!worldObj.isRemote){
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			markDirty();
			if(core != null){
				if(!core.isInvalid()){
					GuiHandler guih = core.guiHandler;
					extractvalues(guih);
				}else{
					core = null;
				}
			}else{
				status = 0;
			}
		}
	}
	
	private void extractvalues(GuiHandler guih){
		status = guih.status;
		cryotheum = guih.cryotheum;
	}
	
	public void setCore(ReactorCoreTile rcore){
		core = rcore;
	}
}
