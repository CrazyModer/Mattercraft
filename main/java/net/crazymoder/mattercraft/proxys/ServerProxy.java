package net.crazymoder.mattercraft.proxys;

import net.crazymoder.mattercraft.Mattercraft;
import net.crazymoder.mattercraft.manager.GuiManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ServerProxy extends CommonProxy{
	
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
	}
	
	public void init(FMLInitializationEvent e){
		super.init(e);
	}
	
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
	}
}
