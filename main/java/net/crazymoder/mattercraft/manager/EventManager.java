package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.FMLCommonHandler;
import net.crazymoder.mattercraft.event.EventBusDropEvent;
import net.crazymoder.mattercraft.event.EventBusWorldEvent;
import net.crazymoder.mattercraft.event.EventBusWorldTickEvent;
import net.minecraftforge.common.MinecraftForge;

public class EventManager {
	public EventManager(){
		MinecraftForge.EVENT_BUS.register(new EventBusDropEvent());
		MinecraftForge.EVENT_BUS.register(new EventBusWorldEvent());
		FMLCommonHandler.instance().bus().register(new EventBusWorldTickEvent());
	}
}
