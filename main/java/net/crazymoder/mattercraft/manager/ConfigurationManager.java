package net.crazymoder.mattercraft.manager;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigurationManager {
	public static String[] multiblockAirBlocks = {"tile.air","tile.bedrock","tile.railcraft.residual.heat"};
	
	public ConfigurationManager(FMLPreInitializationEvent e){
		Configuration configuration = new Configuration(e.getSuggestedConfigurationFile());
		configuration.load();
		multiblockAirBlocks = configuration.get("ReactorCore", "AirEqualBlocks", multiblockAirBlocks).getStringList();
		configuration.save();
	}
}
