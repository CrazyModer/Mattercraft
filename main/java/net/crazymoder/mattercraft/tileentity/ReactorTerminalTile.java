package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ReactorTerminalTile extends TileEntity{
	
	public ReactorCoreTile core;
	public ArrayList<Object> guiinfo;
	
	public ReactorTerminalTile(){
		core = null;
		guiinfo = new ArrayList<Object>();
	}


	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);
		writeSyncableDataToNBT(tagCompound);
	}

	private void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		if(guiinfo.size() == 1){
			tagCompound.setBoolean("connected",true);
			tagCompound.setString("_0", (String) guiinfo.get(0));
		}else{
			tagCompound.setBoolean("connected",false);
		}
		
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		readSyncableDataFromNBT(tagCompound);
	}

	private void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		if(!tagCompound.hasNoTags()){
			guiinfo = new ArrayList<Object>();
			if(tagCompound.getBoolean("connected")){
				guiinfo.add(tagCompound.getString("_0"));
			}
		}
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
					guiinfo = (ArrayList<Object>) core.guiinfo.clone();
				}else{
					core = null;
				}
			}else{
				guiinfo = new ArrayList<Object>();
			}
		}
	}
	
	public void setCore(ReactorCoreTile rcore){
		core = rcore;
	}
}
