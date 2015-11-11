package net.crazymoder.mattercraft.world;

import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;

public class EnergyNetwork {

	public static EnergyNetwork energyNetwork;
	private World world;
	public EnergyNetwork(WorldEvent event){
		world = event.world;
	}
	
	public void update(){
		
	}
}
