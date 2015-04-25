package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.HeatedCryotheumEjectorTile;
import net.crazymoder.mattercraft.tileentity.HydrogenAcceptorTile;
import net.crazymoder.mattercraft.tileentity.LiquidMatterAcceptorTile;
import net.crazymoder.mattercraft.tileentity.PlasmaEjectorTile;
import net.crazymoder.mattercraft.tileentity.StabilizerAcceptorTile;
import net.crazymoder.mattercraft.tileentity.ToxicWasteEjectorTile;


public class TileEntityManager {
	public TileEntityManager(){
		GameRegistry.registerTileEntity(CryotheumAcceptorTile.class, "mtc.cryotheumAcceptorTile");
		GameRegistry.registerTileEntity(HydrogenAcceptorTile.class, "mtc.hydrogenAcceptorTile");
		GameRegistry.registerTileEntity(StabilizerAcceptorTile.class, "mtc.stabilizerAcceptorTile");
		GameRegistry.registerTileEntity(LiquidMatterAcceptorTile.class, "mtc.liquidMatterAcceptorTile");
		GameRegistry.registerTileEntity(PlasmaEjectorTile.class, "mtc.plasmaEjectorTile");
		GameRegistry.registerTileEntity(ToxicWasteEjectorTile.class, "mtc.toxicWasteEjectorTile");
		GameRegistry.registerTileEntity(HeatedCryotheumEjectorTile.class, "mtc.heatedCryotheumEjectorTile");
	}
}
