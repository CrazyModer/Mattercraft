package net.crazymoder.mattercraft.event;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.crazymoder.mattercraft.world.EnergyNetwork;
import net.minecraftforge.event.world.WorldEvent;

public class EventBusWorldTickEvent {
	public EventBusWorldTickEvent(){
		
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(WorldTickEvent event){
		if(event.phase.equals(TickEvent.Phase.START)){
			if(EnergyNetwork.energyNetwork != null)
				EnergyNetwork.energyNetwork.update();
		}
	}
}