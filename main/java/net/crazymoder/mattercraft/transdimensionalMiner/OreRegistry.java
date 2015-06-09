package net.crazymoder.mattercraft.transdimensionalMiner;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.oredict.OreDictionary;

public class OreRegistry {
	
	
 	private static List<WeightedRandom.Item> Ores  = new ArrayList<WeightedRandom.Item>();

	public static void init(File configFile){
		Configuration configuration = new Configuration(configFile);
		configuration.load();
		String[] loadedVal = configuration.get("Ores", "Ores", getDefaults()).getStringList();
		registerOres(loadedVal);
		configuration.save();
	}
	
	public static boolean loaded(){
		return true;
	}
	
	public static ItemStack getRandomOre(){
		return null;	
	}
	
	private static void registerOres(String[] loadedVal){
		for (String entry : loadedVal) {
			String[] entrySplit = entry.split(":");
			if(entrySplit.length == 2){
				if(OreDictionary.getOres(entrySplit[1]).size() > 0){
					ItemStack ore = OreDictionary.getOres(entrySplit[1]).get(0);
					Ores.add(new WeightedRandomItemStack(ore.copy(), Integer.parseInt(entrySplit[0])));
				}
			}
		}
	}
	
	private static String[] getDefaults(){
		String[] defVal= {
			"",
		};
		return defVal;	
	}
	
}
