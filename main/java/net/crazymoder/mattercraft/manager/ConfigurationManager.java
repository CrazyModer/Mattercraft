package net.crazymoder.mattercraft.manager;

import java.util.HashMap;

import com.typesafe.config.ConfigException.Parse;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ConfigurationManager {
	public static String[] multiblockAirBlocks = {"tile.air","tile.bedrock","tile.railcraft.residual.heat"};
	public static String[] populateableBlocks = {"-1:minecraft:netherrack","0:minecraft:stone","1:minecraft:end_stone"};
	
	private void loadDefaults(){
		
	}
	
	public ConfigurationManager(FMLPreInitializationEvent e){
		Configuration configuration = new Configuration(e.getSuggestedConfigurationFile());
		configuration.load();
		populateableBlocks = configuration.get("Quarry", "PopulateableBlocks", populateableBlocks).getStringList();
		multiblockAirBlocks = configuration.get("ReactorCore", "AirEqualBlocks", multiblockAirBlocks).getStringList();
		configuration.save();
	}
	
	public static Block getPopulatable(int dim){
		String name = "";
		String defaultName = "stone";
		String modId = "";
		String defaultModId = "minecraft";
		for (String bn : populateableBlocks) {
			String[] splited = bn.split(":");
			if(splited.length == 3){
				int dimId = Integer.parseInt(splited[0]);
				if(dimId == dim)name = splited[2];
				if(dimId == 0)defaultName = splited[2];
				if(dimId == dim)modId = splited[1];
				if(dimId == 0)defaultModId = splited[1];
			}
		}
		if(name == "")name = defaultName;
		if(modId == "")modId = defaultModId;
		Block block = null;
		try {
			block = GameRegistry.findBlock(modId, name);
			System.out.println("Name: "+block.getLocalizedName());
		} catch (Exception e) {
			System.out.println("ERROR in Config File");
		}
		
		return block;	
	}
}
