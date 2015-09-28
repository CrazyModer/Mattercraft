package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.blockcontainer.MemoryCardReader;
import net.crazymoder.mattercraft.container.MobCrafterContainer;
import net.crazymoder.mattercraft.tileentity.ChunkRegistratorTile;
import net.crazymoder.mattercraft.tileentity.CoolerTile;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.ElectrolizerTile;
import net.crazymoder.mattercraft.tileentity.GeneratorControllerTile;
import net.crazymoder.mattercraft.tileentity.GeneratorEnergyPortTile;
import net.crazymoder.mattercraft.tileentity.GeneratorFluidPortTile;
import net.crazymoder.mattercraft.tileentity.HeatedCryotheumEjectorTile;
import net.crazymoder.mattercraft.tileentity.HydrogenAcceptorTile;
import net.crazymoder.mattercraft.tileentity.ItemProviderTile;
import net.crazymoder.mattercraft.tileentity.LiquidMatterAcceptorTile;
import net.crazymoder.mattercraft.tileentity.MemoryCardReaderTile;
import net.crazymoder.mattercraft.tileentity.MobCrafterTile;
import net.crazymoder.mattercraft.tileentity.PlasmaEjectorTile;
import net.crazymoder.mattercraft.tileentity.QuarryPowerAcceptorTile;
import net.crazymoder.mattercraft.tileentity.QuarryTile;
import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.crazymoder.mattercraft.tileentity.ReactorPowerAcceptorTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
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
		GameRegistry.registerTileEntity(ReactorPowerAcceptorTile.class, "mtc.reactorPowerAcceptorTile");
		GameRegistry.registerTileEntity(ReactorTerminalTile.class, "mtc.reactorTerminalTile");
		GameRegistry.registerTileEntity(ReactorCoreTile.class, "mtc.reactorCoreTile");
		GameRegistry.registerTileEntity(CoolerTile.class, "mtc.coolerTile");
		GameRegistry.registerTileEntity(ElectrolizerTile.class, "mtc.electrolizerTile");
		GameRegistry.registerTileEntity(GeneratorControllerTile.class, "mtc.generatorControllerTile");
		GameRegistry.registerTileEntity(GeneratorFluidPortTile.class, "mtc.generatorFluidPortTile");
		GameRegistry.registerTileEntity(GeneratorEnergyPortTile.class, "mtc.generatorEnergyPortTile");
		GameRegistry.registerTileEntity(QuarryTile.class, "mtc.quarryTile");
		GameRegistry.registerTileEntity(ChunkRegistratorTile.class, "mtc.chunkRegistratorTile");
		GameRegistry.registerTileEntity(ItemProviderTile.class, "mtc.itemProviderTile");
		GameRegistry.registerTileEntity(MemoryCardReaderTile.class, "mtc.memoryCardReaderTile");
		GameRegistry.registerTileEntity(QuarryPowerAcceptorTile.class, "mtc.quarryPowerAcceptorTile");
		GameRegistry.registerTileEntity(MobCrafterTile.class, "mtc.mobCrafterTile");
	}
}
