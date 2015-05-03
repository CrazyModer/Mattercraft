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
	public int matter;
	public int antiMatter;
	public int energy;
	public int power;
	public int topower;
	public float efficiency;
	public int production;
	public int matterRate;
	public int antiRate;
	
	private LogisticHandler log;
	private ReactorCoreTile core;
	private Calculator calc;
	
	public GuiHandler(ReactorCoreTile core){
		this.log = core.logisticHandler;
		this.core = core;
		this.calc = core.calculator;
		status = 0;
		cryotheum = 0;
		liquidMatter = 0;
		stabilizer = 0;
		hydrogen = 0;
		plasma = 0;
		toxicWaste = 0;
		heatedCryotheum = 0;
		energy = 0;
		matter = 0;
		antiMatter = 0;
		power = 0;
		topower = 0;
		efficiency = 0;
		production = 0;
		matterRate = 0;
		antiRate = 0;
	}
	
	public void update(){
		status = core.state;
		cryotheum = log.cryotheum_a;
		liquidMatter = log.liquidMatter_a;
		stabilizer = log.stabilizer_a;
		hydrogen = log.hydrogen_a;
		plasma = log.plasma_a;
		toxicWaste = log.toxicWaste_a;
		heatedCryotheum = log.heatedCryotheum_a;
		energy = log.energy_a;
		matter = log.matter_a;
		antiMatter = log.antiMatter_a;
		power = calc.power;
		topower = calc.topower;
		efficiency = calc.effitiency;
		production = calc.productionrate;
		matterRate = calc.matterInjectionRate;
		antiRate = calc.antiMatterInjectionRate;
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
		tagCompound.setInteger("gui_matter", matter);
		tagCompound.setInteger("gui_antiMatter", antiMatter);
		tagCompound.setInteger("gui_power", power);
		tagCompound.setInteger("gui_topower", topower);
		tagCompound.setFloat("gui_efficiency", efficiency);
		tagCompound.setInteger("gui_production", production);
		tagCompound.setInteger("gui_matterRate", matterRate);
		tagCompound.setInteger("gui_antiRate", antiRate);
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
	    matter = tagCompound.getInteger("gui_matter");;
		antiMatter = tagCompound.getInteger("gui_antiMatter");;
		power = tagCompound.getInteger("gui_power");;
		topower = tagCompound.getInteger("gui_topower");;
		efficiency = tagCompound.getFloat("gui_efficiency");;
		production = tagCompound.getInteger("gui_production");;
		matterRate = tagCompound.getInteger("gui_matterRate");;
		antiRate = tagCompound.getInteger("gui_antiRate");;
	}
	
}
