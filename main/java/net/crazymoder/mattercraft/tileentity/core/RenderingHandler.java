package net.crazymoder.mattercraft.tileentity.core;

import net.minecraft.nbt.NBTTagCompound;

public class RenderingHandler {
	//Render
	public float rotation;
	//
	
	public boolean render;
	public int matter;
	public int antiMatter;
	public int power;
	public int matterin;
	
	ReactorCoreTile core;
	
	public RenderingHandler(ReactorCoreTile core){
		this.core = core;
	}
	
	public void clientUpdate(){
		rotation++;
	}
	
	public void update(){
		render = core.state == 4;
		matter = core.logisticHandler.matter_a;
		antiMatter = core.logisticHandler.antiMatter_a;
		power = core.calculator.power;
		matterin = core.calculator.matterInjectionRate;
	}
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setBoolean("ter_render",render);
		tagCompound.setInteger("ter_matter",matter);
		tagCompound.setInteger("ter_antiMatter",antiMatter);
		tagCompound.setInteger("ter_power",power);
		tagCompound.setInteger("ter_matterin",matterin);
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		render = tagCompound.getBoolean("ter_render");
		matter = tagCompound.getInteger("ter_matter");
		antiMatter = tagCompound.getInteger("ter_antiMatter");
		power = tagCompound.getInteger("ter_power");
		matterin = tagCompound.getInteger("ter_matterin");
	}
}
