package net.crazymoder.mattercraft.helper.reactorcore;

import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.minecraft.nbt.NBTTagCompound;

public class Calculator {
	private ReactorCoreTile core;
	private LogisticHandler log;
	private GuiHandler guiH;
	private RenderingHandler ren;
	
	public int topower;
	public int matterInjectionRate;
	public int antiMatterInjectionRate;
	public float effitiency;
	public int productionrate;
	public int power;
	public int matterIO;
	public int antiMatterIO;
	
	public Calculator(ReactorCoreTile core){
		this.core = core;
		log = core.logisticHandler;
		guiH = core.guiHandler;
		ren = core.renderingHandler;
		topower = 0;
		matterInjectionRate = 0;
		antiMatterInjectionRate = 0;
		effitiency = 1;
		productionrate = 0;
		power = 0;
	}
	
	
	public void calculate(){
		matterIO = log.matter_a;
		antiMatterIO = log.antiMatter_a;
		topower = (int) (1000000f * (1f - (float)(log.plasma_a)/log.plasma_m));
		if(log.hydrogen_a < 10000)topower = 100;
		int min = log.matter_a < log.antiMatter_a ? log.matter_a : log.antiMatter_a;
		power = (int) (Math.pow(min/100d, 2));
		if(power < topower){
			if(log.matter_a > log.antiMatter_a){
				if(log.antiMatter_a+1 < log.antiMatter_m){
					antiMatterInjectionRate += 1;
				}
			}else{
				if(log.matter_a+1 < log.matter_m)
					matterInjectionRate += 1;
			}	
		}else{
			if(antiMatterInjectionRate - 1 > -1)
			antiMatterInjectionRate -= 1;
		}
		effitiency = 1;
		if(log.antiMatter_a < log.matter_a && log.antiMatter_a > 0 && log.matter_a >0){
			effitiency = 1f - (((float)log.matter_a - (float)log.antiMatter_a) / (float)log.matter_m)/2f;
		}
		if(log.liquidMatter_a > matterInjectionRate/10f && log.matter_a + matterInjectionRate < log.matter_m){
			log.matter_a += matterInjectionRate;
			log.liquidMatter_a -= (matterInjectionRate/10f);
		}else{
			if(matterInjectionRate >= 10)
			matterInjectionRate -= 5;
		}
		if(log.hydrogen_a >= power/5000f && log.plasma_a < log.plasma_m + power/5000f){
			log.hydrogen_a -= power/5000f;
			log.plasma_a += power/100f;
			productionrate = (int) (power/100f);
		}
		if(log.cryotheum_a < 1000){
			core.deactivate();
		}else{
			log.cryotheum_a-=30;
			if(log.heatedCryotheum_a+30 < log.heatedCryotheum_m)
				log.heatedCryotheum_a+=30;
		}
		if(log.stabilizer_a < 1000){
			core.deactivate();
		}else{
			log.stabilizer_a -= (4f + 10f)*Math.pow(effitiency, 2);
			if(log.toxicWaste_a + 4 + 10 < log.toxicWaste_m)
				log.toxicWaste_a += 4 + 10;
		}
		if(log.energy_a > 1000000){
			log.energy_a -= 50000;
			log.energy_a -= power/400f;
		}else{
			core.deactivate();
		}
		if(log.antiMatter_a + antiMatterInjectionRate < log.antiMatter_m)
			log.antiMatter_a += antiMatterInjectionRate;
		else
			antiMatterInjectionRate-=5;
		log.antiMatter_a -= power/1000f;
		log.matter_a -= power/1000f;
		antiMatterIO = log.antiMatter_a - antiMatterIO;
		matterIO = log.matter_a - matterIO;
		/*System.out.println("power:" + power);
		System.out.println("topower:"+topower);
		System.out.println("production: "+productionrate);
		System.out.println("effitiency: "+effitiency);
		System.out.println("matter: "+log.matter_a);
		System.out.println("anti:" +log.antiMatter_a);
		System.out.println("matterrate: "+matterInjectionRate);
		System.out.println("antirate:" +antiMatterInjectionRate);
		System.out.println();*/
	}
	
	
	public void writeSyncableDataToNBT(NBTTagCompound tagCompound) {
		tagCompound.setInteger("calc_matterInjectionRate", matterInjectionRate);
		tagCompound.setInteger("calc_antiMatterInjectionRate", antiMatterInjectionRate);
	}

	public void readSyncableDataFromNBT(NBTTagCompound tagCompound) {
		matterInjectionRate = tagCompound.getInteger("calc_matterInjectionRate");
		antiMatterInjectionRate = tagCompound.getInteger("calc_antiMatterInjectionRate");
	}
	
	public boolean canactivate(){
		return(log.cryotheum_a > 25000 && log.stabilizer_a > 25000 && log.energy_a > 50000000);
	}
	public void activate(){
		matterInjectionRate = 0;
		antiMatterInjectionRate = 0;
		log.antiMatter_a = 0;
		log.matter_a = 0;
		productionrate = 0;
		matterIO = 0;
		antiMatterIO = 0;
		power = 0;
		topower = 0;
	}
	public void deactivate(){
		matterInjectionRate = 0;
		antiMatterInjectionRate = 0;
		log.antiMatter_a = 0;
		log.matter_a = 0;
		productionrate = 0;
		matterIO = 0;
		antiMatterIO = 0;
		power = 0;
		topower = 0;
	}
}