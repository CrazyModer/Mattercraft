package net.crazymoder.mattercraft.helper.MobCrafter;

import java.util.HashMap;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

public class MobCrafterConfiguration {
	
	public static HashMap<String, Integer>mobs;
	public static String[] names;
	public static int[] probability;
	public static int[] plasma;
	public static int[] cooldown;
	public static boolean editmode;
	
	public MobCrafterConfiguration(Configuration config){
		config.load();
		editmode = config.getBoolean("buildmode", "Buildmode", true, "Enable build mod to see class names on hiting a mob.");
		config.addCustomCategoryComment("Mobs", "Mobs: classname, Names: Name, Probability: in permill, Plasma: amount of plasma whitch is needed, Cooldown: in ticks");
		
		String[] mobs = {
				"net.minecraft.entity.monster.EntityZombie",
				"net.minecraft.entity.monster.EntityEnderman",
				"cofh.thermalfoundation.entity.monster.EntityBlizz"
		};
		String[] names = {
				"Zombie",
				"Enderman",
				"Blizz"
		};
		int[] probability = {
				100,
				50,
				50
		};
		int[] plasma = {
				100,
				1000,
				5000
		};
		int[] cooldown = {
				1,
				40,
				40
		};
		
		this.mobs = new HashMap<String, Integer>();
		mobs = config.get("Mobs", "Mobs", mobs).getStringList();
		for (int i = 0; i < mobs.length; i++) {
			this.mobs.put(mobs[i], i);
		}
		this.names = config.get("Mobs", "Names", names).getStringList();
		this.probability = config.get("Mobs", "Probability", probability).getIntList();
		this.plasma = config.get("Mobs", "Plasma", plasma).getIntList();
		this.cooldown = config.get("Mobs", "Cooldown", cooldown).getIntList();
		config.save();
	}
}
