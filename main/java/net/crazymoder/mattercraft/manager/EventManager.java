package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.event.EventBusSubscription;
import net.minecraftforge.common.MinecraftForge;

public class EventManager {
	public EventManager(){
		MinecraftForge.EVENT_BUS.register(new EventBusSubscription());
	}
}
