package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.fluids.HeatedCryotheum;
import net.crazymoder.mattercraft.fluids.Hydrogen;
import net.crazymoder.mattercraft.fluids.IonizedPlasma;
import net.crazymoder.mattercraft.fluids.LiquidMatter;
import net.crazymoder.mattercraft.fluids.LiquidStabilizer;
import net.crazymoder.mattercraft.fluids.ToxicWaste;
import net.crazymoder.mattercraft.fluids.ToxicWaste;
import net.minecraftforge.common.MinecraftForge;

public class FluidManager {
	public FluidManager(){
		IonizedPlasma ionizedPlasma = new IonizedPlasma();
		LiquidMatter liquidMatter = new LiquidMatter();
		ToxicWaste toxicWaste = new ToxicWaste();
		Hydrogen hydrogen = new Hydrogen();
		LiquidStabilizer stabilizer = new LiquidStabilizer();
		HeatedCryotheum heatedCryotheum = new HeatedCryotheum();
		MinecraftForge.EVENT_BUS.register(BucketManager.INSTANCE);
	}
}
