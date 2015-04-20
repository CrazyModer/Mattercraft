package net.crazymoder.mattercraft.Manager;

import net.crazymoder.mattercraft.TileEntity.EnergyPowerCoreTile;
import net.crazymoder.mattercraft.TileEntity.NormalBlockTile;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(EnergyPowerCoreTile.class, "energyPowerCore");
		GameRegistry.registerTileEntity(NormalBlockTile.class, "normalblock");
	}
}
