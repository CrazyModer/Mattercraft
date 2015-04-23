package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;


public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(CryotheumAcceptorTile.class, "cryotheumAcceptorTile");
		//GameRegistry.registerTileEntity(NormalBlockTile.class, "normalblock");
	}
}
