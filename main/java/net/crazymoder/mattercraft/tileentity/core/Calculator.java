package net.crazymoder.mattercraft.tileentity.core;

import net.minecraft.nbt.NBTTagCompound;

public class Calculator {
	private ReactorCoreTile core;
	private LogisticHandler log;
	private GuiHandler guiH;
	private RenderingHandler ren;
	
	public int topower;
	public int matterInjectionRate;
	public int antiMatterInjectionRate;
	
	private int effitiency;
	
	public Calculator(ReactorCoreTile core){
		this.core = core;
		log = core.logisticHandler;
		guiH = core.guiHandler;
		ren = core.renderingHandler;
		topower = 1000000;
	}
	
	
	public void calculate(){
		int min = log.matter_a < log.antiMatter_a ? log.matter_a : log.antiMatter_a;
		int power = (int) ((Math.pow(min/10d, 2))/10d);
		if(power < topower){
			if(log.matter_a > log.antiMatter_a){
				if(log.antiMatter_a+2 < log.antiMatter_m)
				antiMatterInjectionRate += 2;
			}else{
				if(log.matter_a+2 < log.matter_m)
				matterInjectionRate += 2;
			}	
		}else{
			if(antiMatterInjectionRate - 1 > -1)
			antiMatterInjectionRate -= 1;
		}
		if(log.antiMatter_a > 0 && log.matter_a >0)
		effitiency = log.antiMatter_a/log.matter_a;
		log.matter_a += matterInjectionRate;
		log.antiMatter_a += antiMatterInjectionRate;
		log.antiMatter_a -= power/1000f;
		log.matter_a -= power/1000f;
		System.out.println("min "+ min);
		System.out.println("power:" + power);
		System.out.println("effitiency: "+effitiency);
		System.out.println("matter: "+log.matter_a);
		System.out.println("anti:" +log.antiMatter_a);
		System.out.println("matterrate: "+matterInjectionRate);
		System.out.println("antirate:" +antiMatterInjectionRate);
		System.out.println();
	}
	
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("calc_topower",topower);
		tagCompound.setInteger("calc_matterInjectionRate", matterInjectionRate);
		tagCompound.setInteger("calc_antiMatterInjectionRate", antiMatterInjectionRate);
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		topower = tagCompound.getInteger("calc_topower");
		matterInjectionRate = tagCompound.getInteger("calc_matterInjectionRate");
		antiMatterInjectionRate = tagCompound.getInteger("calc_antiMatterInjectionRate");
	}
	
	public boolean canactivate(){
		return true;
	}
	public void activate(){
		
	}
	public void deactivate(){
		
	}
}
