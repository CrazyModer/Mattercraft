package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.HydrogenAcceptorTile;
import net.crazymoder.mattercraft.tileentity.StabilizerAcceptorTile;


public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(CryotheumAcceptorTile.class, "mtc.cryotheumAcceptorTile");
		GameRegistry.registerTileEntity(HydrogenAcceptorTile.class, "mtc.hydrogenAcceptorTile");
		GameRegistry.registerTileEntity(StabilizerAcceptorTile.class, "mtc.stabilizerAcceptorTile");
	}
}
