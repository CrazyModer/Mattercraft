package net.crazymoder.mattercraft.tileentity.core;

import net.minecraft.nbt.NBTTagCompound;

public class RenderingHandler {
	//Render
	public float rotation;
	//
	
	public boolean render;
	
	ReactorCoreTile core;
	
	public RenderingHandler(ReactorCoreTile core){
		this.core = core;
	}
	
	public void update(){
		render = core.state == 4;
	}
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setBoolean("ter_render",render);
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		render = tagCompound.getBoolean("ter_render");
	}
}
