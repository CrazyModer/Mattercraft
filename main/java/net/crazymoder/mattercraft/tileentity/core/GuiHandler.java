package net.crazymoder.mattercraft.tileentity.core;

import net.minecraft.nbt.NBTTagCompound;

public class GuiHandler {
	
	public int status;
	public int cryotheum;
	public int liquidMatter;
	public int stabilizer;
	public int hydrogen;
	public int plasma;
	public int toxicWaste;
	public int heatedCryotheum;
	public int energy;
	
	private LogisticHandler log;
	private ReactorCoreTile core;
	
	public GuiHandler(ReactorCoreTile core){
		this.log = core.logisticHandler;
		this.core = core;
		status = 0;
		cryotheum = 0;
		liquidMatter = 0;
		stabilizer = 0;
		hydrogen = 0;
		plasma = 0;
		toxicWaste = 0;
		heatedCryotheum = 0;
		energy = 0;
	}
	
	public void update(){
		status = core.state;
		cryotheum = (int) (((float)(log.cryotheum_a)/log.cryotheum_m)*100f);
		liquidMatter = (int) (((float)(log.liquidMatter_a)/log.liquidMatter_m)*100f);
		stabilizer = (int) (((float)(log.stabilizer_a)/log.stabilizer_m)*100f);
		hydrogen = (int) (((float)(log.hydrogen_a)/log.hydrogen_m)*100f);
		plasma = (int) (((float)(log.plasma_a)/log.plasma_m)*100f);
		toxicWaste = (int) (((float)(log.toxicWaste_a)/log.toxicWaste_m)*100f);
		heatedCryotheum = (int) (((float)(log.heatedCryotheum_a)/log.heatedCryotheum_m)*100f);
		energy = log.energy_a;
	}
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("gui_status", status);
		tagCompound.setInteger("gui_cryotheum", cryotheum);
		tagCompound.setInteger("gui_liquidMatter", liquidMatter);
		tagCompound.setInteger("gui_stabilizer", stabilizer);
		tagCompound.setInteger("gui_hydrogen", hydrogen);
		tagCompound.setInteger("gui_plasma", plasma);
		tagCompound.setInteger("gui_toxicWaste", toxicWaste);
		tagCompound.setInteger("gui_heatedCryotheum", heatedCryotheum);
		tagCompound.setInteger("gui_energy", energy);
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		status = tagCompound.getInteger("gui_status");
	    cryotheum = tagCompound.getInteger("gui_cryotheum");
	    liquidMatter = tagCompound.getInteger("gui_liquidMatter");
	    stabilizer = tagCompound.getInteger("gui_stabilizer");
	    hydrogen = tagCompound.getInteger("gui_hydrogen");
	    plasma = tagCompound.getInteger("gui_plasma");
	    toxicWaste = tagCompound.getInteger("gui_toxicWaste");
	    heatedCryotheum = tagCompound.getInteger("gui_heatedCryotheum");
	    energy = tagCompound.getInteger("gui_energy");
	}
	
}
