package net.crazymoder.mattercraft.tileentity.core;

import net.minecraft.nbt.NBTTagCompound;

public class GuiHandler {
	
	public int status;
	public int cryotheum;
	public int liquidMatter;
	public int stabilizer;
	public int hydrogen;
	
	private LogisticHandler log;
	
	public GuiHandler(LogisticHandler log){
		this.log = log;
		status = 0;
		cryotheum = 0;
		liquidMatter = 0;
		stabilizer = 0;
		hydrogen = 0;
	}
	
	public void update(){
		cryotheum = (int) (((float)(log.cryotheum_a)/log.cryotheum_m)*100f);
		liquidMatter = (int) (((float)(log.liquidMatter_a)/log.liquidMatter_m)*100f);
		stabilizer = (int) (((float)(log.stabilizer_a)/log.stabilizer_m)*100f);
		hydrogen = (int) (((float)(log.hydrogen_a)/log.hydrogen_m)*100f);
	}
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("status", status);
		tagCompound.setInteger("cryotheum", cryotheum);
		tagCompound.setInteger("liquidMatter", liquidMatter);
		tagCompound.setInteger("stabilizer", stabilizer);
		tagCompound.setInteger("hydrogen", hydrogen);
		
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		status = tagCompound.getInteger("status");
	    cryotheum = tagCompound.getInteger("cryotheum");
	    liquidMatter = tagCompound.getInteger("liquidMatter");
	    stabilizer = tagCompound.getInteger("stabilizer");
	    hydrogen = tagCompound.getInteger("hydrogen");
	}
	
}
