package net.crazymoder.mattercraft.event;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.crazymoder.mattercraft.world.EnergyNetwork;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.WorldEvent;

public class EventBusWorldEvent {
	
	
	public EventBusWorldEvent() {
	}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(WorldEvent.Load event)
	{
		EnergyNetwork.energyNetwork = new EnergyNetwork(event);
	} 
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(WorldEvent.Unload event)
	{
		EnergyNetwork.energyNetwork = null;
	} 

}
