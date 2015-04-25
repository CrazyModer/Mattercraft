package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.tileentity.EnergyPowerCoreTile;
import net.crazymoder.mattercraft.tileentity.NormalBlockTile;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(EnergyPowerCoreTile.class, "energyPowerCore");
		GameRegistry.registerTileEntity(NormalBlockTile.class, "normalblock");
	}
}
