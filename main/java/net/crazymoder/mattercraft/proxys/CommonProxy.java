package net.crazymoder.mattercraft.proxys;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.crazymoder.mattercraft.craftingmanager.ExternalCraftingManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.manager.FluidManager;
import net.crazymoder.mattercraft.manager.TileEntityManager;
import net.crazymoder.mattercraft.manager.TileRenderingManager;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		BlockManager blockManager = new BlockManager();
    	TileEntityManager tileEntityManger = new TileEntityManager();
    	ExternalCraftingManager extenalCM = new ExternalCraftingManager();
    	FluidManager fluidManager = new FluidManager();
	}
	
	public void init(FMLInitializationEvent e){
		
	}
	
	public void postInit(FMLPostInitializationEvent e){
		
	}
	
}
