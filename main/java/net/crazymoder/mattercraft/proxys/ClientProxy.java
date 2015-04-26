package net.crazymoder.mattercraft.proxys;

import net.crazymoder.mattercraft.manager.TileRenderingManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
		TileRenderingManager tileRenderingManager = new TileRenderingManager();
	}
	
	public void init(FMLInitializationEvent e){
		super.init(e);
	}
	
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
	}
}
