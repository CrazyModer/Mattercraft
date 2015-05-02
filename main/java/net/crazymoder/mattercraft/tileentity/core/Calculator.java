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
	
	private float effitiency;
	
	public Calculator(ReactorCoreTile core){
		this.core = core;
		log = core.logisticHandler;
		guiH = core.guiHandler;
		ren = core.renderingHandler;
		topower = 0;
	}
	
	
	public void calculate(){
		topower = (int) (1000000f * (1f - (float)(log.plasma_a)/log.plasma_m));
		int stab = 0;
		int min = log.matter_a < log.antiMatter_a ? log.matter_a : log.antiMatter_a;
		int power = (int) ((Math.pow(min/10d, 2))/10d);
		if(power < topower){
			if(log.matter_a > log.antiMatter_a){
				if(log.antiMatter_a+2 < log.antiMatter_m)
				antiMatterInjectionRate += 2;
				stab = 2;
			}else{
				if(log.matter_a+2 < log.matter_m)
				matterInjectionRate += 2;
			}	
		}else{
			if(antiMatterInjectionRate - 1 > -1)
			antiMatterInjectionRate -= 1;
			stab = 1;
		}
		effitiency = 1;
		if(log.antiMatter_a*2 < log.matter_a && log.antiMatter_a > 0 && log.matter_a >0){
			float effi1 = 1f - (((float)log.matter_a - (float)log.antiMatter_a*2f) / (float)log.matter_m)/2f;
			effitiency = effi1;
		}
		if(log.liquidMatter_a > matterInjectionRate/10f && log.matter_a + matterInjectionRate < log.matter_m){
			log.matter_a += matterInjectionRate;
			log.liquidMatter_a -= (matterInjectionRate/10f)*effitiency;
		}else{
			if(matterInjectionRate >= 10)
			matterInjectionRate -= 10;
		}
		if(log.hydrogen_a >= power/5000f && log.plasma_a < log.plasma_m + power/5000f){
			log.hydrogen_a -= power/5000f;
			log.plasma_a += power/100f;
		}
		if(log.cryotheum_a < 1000){
			core.deactivate();
		}else{
			log.cryotheum_a-=50;
			if(log.heatedCryotheum_a+50 < log.heatedCryotheum_m)
				log.heatedCryotheum_a+=45;
			if(log.toxicWaste_a + 10 < log.toxicWaste_m)
				log.toxicWaste_a += 10;
		}
		if(log.stabilizer_a < 1000){
			core.deactivate();
		}else{
			log.stabilizer_a -= 20 + stab*100;
			if(log.toxicWaste_a + 20 + stab*100 < log.toxicWaste_m)
				log.toxicWaste_a += 20 + stab*100;
		}
		
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
		System.out.println("topower:"+topower);
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
		return(log.cryotheum_a > 25000 && log.stabilizer_a > 25000);
	}
	public void activate(){
		matterInjectionRate = 0;
		antiMatterInjectionRate = 0;
		log.antiMatter_a = 0;
		log.matter_a = 0;
	}
	public void deactivate(){
		matterInjectionRate = 0;
		antiMatterInjectionRate = 0;
		log.antiMatter_a = 0;
		log.matter_a = 0;
	}
}
