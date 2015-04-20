package net.crazymoder.mattercraft.Manager;

import net.crazymoder.mattercraft.TileEntity.EnergyCollectorTile;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(EnergyCollectorTile.class, "energycollector");
	}
}
