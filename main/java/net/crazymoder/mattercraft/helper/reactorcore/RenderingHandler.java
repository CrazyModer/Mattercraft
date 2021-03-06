package net.crazymoder.mattercraft.helper.reactorcore;

import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.minecraft.nbt.NBTTagCompound;

public class RenderingHandler {
	
	public boolean render;
	public int matter;
	public int antiMatter;
	public int production;
	
	ReactorCoreTile core;
	
	public RenderingHandler(ReactorCoreTile core){
		this.core = core;
	}
	
	public void update(){
		render = core.state == 4;
		matter = core.logisticHandler.matter_a;
		antiMatter = core.logisticHandler.antiMatter_a;
		production = core.calculator.productionrate;
	}
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setBoolean("ter_render",render);
		tagCompound.setInteger("ter_matter",matter);
		tagCompound.setInteger("ter_antiMatter",antiMatter);
		tagCompound.setInteger("ter_production",production);
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		render = tagCompound.getBoolean("ter_render");
		matter = tagCompound.getInteger("ter_matter");
		antiMatter = tagCompound.getInteger("ter_antiMatter");
		production = tagCompound.getInteger("ter_production");
	}
}
