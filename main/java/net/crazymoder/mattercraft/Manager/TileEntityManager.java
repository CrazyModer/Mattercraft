package net.crazymoder.mattercraft.Manager;

import net.crazymoder.mattercraft.TileEntity.EnergyCoreTile;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(EnergyCoreTile.class, "energycollector");
	}
}
