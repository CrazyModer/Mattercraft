package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.blockcontainer.ChunkRegistrator;
import net.crazymoder.mattercraft.blockcontainer.Cooler;
import net.crazymoder.mattercraft.blockcontainer.CryotheumAcceptor;
import net.crazymoder.mattercraft.blockcontainer.Electrolizer;
import net.crazymoder.mattercraft.blockcontainer.GeneratorController;
import net.crazymoder.mattercraft.blockcontainer.GeneratorEnergyPort;
import net.crazymoder.mattercraft.blockcontainer.GeneratorFluidPort;
import net.crazymoder.mattercraft.blockcontainer.HeatedCryotheumEjector;
import net.crazymoder.mattercraft.blockcontainer.HydrogenAcceptor;
import net.crazymoder.mattercraft.blockcontainer.ItemProvider;
import net.crazymoder.mattercraft.blockcontainer.LiquidMatterAcceptor;
import net.crazymoder.mattercraft.blockcontainer.MemoryCardReader;
import net.crazymoder.mattercraft.blockcontainer.PlasmaEjector;
import net.crazymoder.mattercraft.blockcontainer.PlasmaInjector;
import net.crazymoder.mattercraft.blockcontainer.Quarry;
import net.crazymoder.mattercraft.blockcontainer.QuarryPowerAcceptor;
import net.crazymoder.mattercraft.blockcontainer.ReactorCore;
import net.crazymoder.mattercraft.blockcontainer.ReactorPowerAcceptor;
import net.crazymoder.mattercraft.blockcontainer.ReactorTerminal;
import net.crazymoder.mattercraft.blockcontainer.StabilizerAcceptor;
import net.crazymoder.mattercraft.blockcontainer.ToxicWasteEjector;
import net.crazymoder.mattercraft.blockcontainer.WaterInjector;
import net.crazymoder.mattercraft.blocks.BasicBlock;
import net.crazymoder.mattercraft.blocks.FrontTextureBlock;
import net.crazymoder.mattercraft.blocks.MultiTextureBlock;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.GeneratorEnergyPortTile;
import net.crazymoder.mattercraft.tileentity.HeatedCryotheumEjectorTile;
import net.crazymoder.mattercraft.tileentity.ToxicWasteEjectorTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockManager {
	//declarate Blocks
	public static Block groundPlating;
	public static Block reinforcedPlating;
	public static Block iridiumPalting;
	public static Block osmiumPlating;
	public static Block stabilizer;
	public static Block forceFieldEmitter;
	public static Block stabilizerPillar;//mst
	public static Block plasmaExtractor;//mst
	public static Block wormHoleStabilizer;//mst
	public static Block matterInjector;//mst
	public static Block osmiumOre;
	public static Block iridiumOre;
	public static Block unstableMatter;
	public static Block generatorPlating;
	public static Block heatSink;
	public static Block peltier;
	public static Block exhaustPipe;	
	public static Block waterInjector;
	public static Block plasmaInjector;
	public static Block emptyChunkRegistrator;

	
	
	
	//declarate Block Container
	public static Block cryotheumAcceptor;
	public static Block hydrogenAcceptor;
	public static Block stabilizerAcceptor;
	public static Block liquidMatterAcceptor;
	public static Block plasmaEjector;
	public static Block toxicWasteEjector;
	public static Block heatedCryotheumEjector;
	public static Block reactorPowerAcceptor;
	public static Block reactorTerminal;
	public static Block reactorCore;
	public static Block cooler; //mst
	public static Block electrolizer; //mst
	public static Block generatorFluidPort;
	public static Block generatorEnergyPort;
	public static Block generatorController;//mst
	public static Block quarry;
	public static Block chunkRegistrator;
	public static Block itemProvider;
	public static Block memoryCardReader;
	public static Block quarryPowerAcceptor;
	
	public BlockManager(){
		//Initialize Blocks
		groundPlating = new BasicBlock(Material.ground);
		reinforcedPlating = new BasicBlock(Material.ground);
		iridiumPalting = new BasicBlock(Material.iron);
		osmiumPlating = new BasicBlock(Material.iron);
		stabilizer = new FrontTextureBlock(Material.piston);
		forceFieldEmitter = new BasicBlock(Material.iron);
		stabilizerPillar = new MultiTextureBlock(Material.iron);
		plasmaExtractor = new MultiTextureBlock(Material.piston);
		wormHoleStabilizer = new MultiTextureBlock(Material.piston);
		matterInjector = new MultiTextureBlock(Material.piston);
		osmiumOre = new BasicBlock(Material.iron);
		iridiumOre =new BasicBlock(Material.iron);
		unstableMatter = new BasicBlock(Material.iron);
		generatorPlating = new BasicBlock(Material.iron);		
		heatSink = new BasicBlock(Material.iron);
		peltier = new MultiTextureBlock(Material.iron);
		exhaustPipe = new MultiTextureBlock(Material.iron);
		waterInjector = new MultiTextureBlock(Material.iron);
		plasmaInjector = new MultiTextureBlock(Material.iron);
		emptyChunkRegistrator = new MultiTextureBlock(Material.iron);
		
		
	    //Initialize Block Containers
		cryotheumAcceptor = new CryotheumAcceptor();
		hydrogenAcceptor = new HydrogenAcceptor();
		stabilizerAcceptor = new StabilizerAcceptor();
		liquidMatterAcceptor = new LiquidMatterAcceptor();
		plasmaEjector = new PlasmaEjector();
		toxicWasteEjector = new ToxicWasteEjector();
		heatedCryotheumEjector = new HeatedCryotheumEjector();
		reactorPowerAcceptor = new ReactorPowerAcceptor();
		reactorTerminal = new ReactorTerminal();
		reactorCore = new ReactorCore();
		cooler = new Cooler();
		electrolizer = new Electrolizer();
		generatorController = new GeneratorController();
		generatorEnergyPort = new GeneratorEnergyPort();
		generatorFluidPort = new GeneratorFluidPort();
		quarry = new Quarry();
		chunkRegistrator = new ChunkRegistrator();
		itemProvider = new ItemProvider();
		memoryCardReader = new MemoryCardReader();
		quarryPowerAcceptor = new QuarryPowerAcceptor();
		
		//Configure Blocks
		groundPlating.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.groundPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		reinforcedPlating.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reinforcedPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		iridiumPalting.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.iridiumPalting").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		osmiumPlating.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.osmiumPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		stabilizer.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizer").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		forceFieldEmitter.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.forceFieldEmitter").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		stabilizerPillar.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizerPillar").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		plasmaExtractor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.plasmaExtractor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		wormHoleStabilizer.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.wormHoleStabilizer").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		matterInjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.matterInjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		osmiumOre.setHardness(1.5F).setStepSound(Block.soundTypeStone).setBlockName("mtc.osmiumOre").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		iridiumOre.setHardness(1.5F).setStepSound(Block.soundTypeStone).setBlockName("mtc.iridiumOre").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		unstableMatter.setHardness(1.5F).setStepSound(Block.soundTypeStone).setBlockName("mtc.unstableMatter").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		generatorPlating.setHardness(3.0F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",4);
		heatSink.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.heatSink").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		peltier.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.peltier").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		exhaustPipe.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.exhaustPipe").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		waterInjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.waterInjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		plasmaInjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.plasmaInjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		emptyChunkRegistrator.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.emptyChunkRegistrator").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);	
		
		//Configure Block Containers
		cryotheumAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.cryotheumAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		hydrogenAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.hydrogenAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		stabilizerAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		liquidMatterAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.liquidMatterAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		plasmaEjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.plasmaEjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		toxicWasteEjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.toxicWasteEjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		heatedCryotheumEjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.heatedCryotheumEjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		reactorPowerAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorPowerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		reactorTerminal.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorTerminal").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		reactorCore.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorCore").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		cooler.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.cooler").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		electrolizer.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.electrolizer").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		generatorController.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorController").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		generatorEnergyPort.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorEnergyPort").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		generatorFluidPort.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorFluidPort").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		quarry.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.quarry").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		chunkRegistrator.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.chunkRegistrator").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		itemProvider.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.itemProvider").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		memoryCardReader.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.memoryCardReader").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		quarryPowerAcceptor.setHardness(2F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.quarryPowerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		
		//Single Texture Blocks
		groundPlating.setBlockTextureName("mattercraft:groundPlating");
		reinforcedPlating.setBlockTextureName("mattercraft:reinforcedPlating");
		iridiumPalting.setBlockTextureName("mattercraft:iridiumPalting");
		osmiumPlating.setBlockTextureName("mattercraft:osmiumPlating");
		stabilizer.setBlockTextureName("mattercraft:stabilizer");
		forceFieldEmitter.setBlockTextureName("mattercraft:forceFieldEmitter");
		osmiumOre.setBlockTextureName("mattercraft:osmiumOre");
		iridiumOre.setBlockTextureName("mattercraft:iridiumOre");
		unstableMatter.setBlockTextureName("mattercraft:unstableMatter");
		generatorPlating.setBlockTextureName("mattercraft:generatorPlating");
		heatSink.setBlockTextureName("mattercraft:heatSink");
		
		
		
		//Multi Texture Blocks
		stabilizerPillar.setBlockTextureName("mattercraft:stabilizerPillar");
		plasmaExtractor.setBlockTextureName("mattercraft:plasmaExtractor");
		wormHoleStabilizer.setBlockTextureName("mattercraft:wormHoleStabilizer");
		matterInjector.setBlockTextureName("mattercraft:matterInjector");
		peltier.setBlockTextureName("mattercraft:peltier");
		exhaustPipe.setBlockTextureName("mattercraft:exhaustPipe");
		plasmaInjector.setBlockTextureName("mattercraft:plasmaInjector");
		waterInjector.setBlockTextureName("mattercraft:waterInjector");
		emptyChunkRegistrator.setBlockTextureName("mattercraft:emptyChunkRegistrator");
		
		
		//Texture Block Container
		reactorCore.setBlockTextureName("mattercraft:reactorCore");
		cryotheumAcceptor.setBlockTextureName("mattercraft:cryotheumAcceptor");
		hydrogenAcceptor.setBlockTextureName("mattercraft:hydrogenAcceptor");
		stabilizerAcceptor.setBlockTextureName("mattercraft:stabilizerAcceptor");
		liquidMatterAcceptor.setBlockTextureName("mattercraft:liquidMatterAcceptor");
		plasmaEjector.setBlockTextureName("mattercraft:plasmaEjector");
		toxicWasteEjector.setBlockTextureName("mattercraft:toxicWasteEjector");
		heatedCryotheumEjector.setBlockTextureName("mattercraft:heatedCryotheumEjector");
		reactorPowerAcceptor.setBlockTextureName("mattercraft:reactorPowerAcceptor");
		reactorTerminal.setBlockTextureName("mattercraft:reactorTerminal");
		cooler.setBlockTextureName("mattercraft:cooler");
		electrolizer.setBlockTextureName("mattercraft:electrolizer");
		generatorController.setBlockTextureName("mattercraft:generatorController");
		generatorEnergyPort.setBlockTextureName("mattercraft:generatorEnergyPort");
		generatorFluidPort.setBlockTextureName("mattercraft:generatorFluidPort");
		quarry.setBlockTextureName("mattercraft:quarry");
		chunkRegistrator.setBlockTextureName("mattercraft:chunkRegistrator");
		itemProvider.setBlockTextureName("mattercraft:itemProvider");
		memoryCardReader.setBlockTextureName("mattercraft:memoryCardReader");
		quarryPowerAcceptor.setBlockTextureName("mattercraft:quarryPowerAcceptor");
		
		//Register Blocks
		GameRegistry.registerBlock(groundPlating, "mtc.groundPlating");
		GameRegistry.registerBlock(reinforcedPlating, "mtc.reinforcedPlating");
		GameRegistry.registerBlock(iridiumPalting, "mtc.iridiumPalting");
		GameRegistry.registerBlock(osmiumPlating, "mtc.osmiumPlating");
		GameRegistry.registerBlock(stabilizer, "mtc.stabilizer");
		GameRegistry.registerBlock(forceFieldEmitter, "mtc.forceFieldEmitter");
		GameRegistry.registerBlock(stabilizerPillar, "mtc.stabilizerPillar");
		GameRegistry.registerBlock(plasmaExtractor, "mtc.plasmaExtractor");
		GameRegistry.registerBlock(wormHoleStabilizer, "mtc.wormHoleStabilizer");
		GameRegistry.registerBlock(matterInjector, "mtc.matterInjector");
		GameRegistry.registerBlock(osmiumOre, "mtc.osmiumOre");
		GameRegistry.registerBlock(iridiumOre, "mtc.iridiumOre");
		GameRegistry.registerBlock(unstableMatter, "mtc.unstableMatter");
		GameRegistry.registerBlock(generatorPlating, "mtc.generatorPlating");
		GameRegistry.registerBlock(heatSink, "mtc.heatSink");
		GameRegistry.registerBlock(peltier, "mtc.peltier");
		GameRegistry.registerBlock(exhaustPipe, "mtc.exhaustPipe");
		GameRegistry.registerBlock(waterInjector, "mtc.waterInjector");
		GameRegistry.registerBlock(plasmaInjector, "mtc.plasmaInjector");
		GameRegistry.registerBlock(emptyChunkRegistrator, "mtc.emptyChunkRegistrator");
		
		//Register Block Container
		GameRegistry.registerBlock(cryotheumAcceptor, "mtc.cryotheumAcceptor");
		GameRegistry.registerBlock(hydrogenAcceptor, "mtc.hydrogenAcceptor");
		GameRegistry.registerBlock(stabilizerAcceptor, "mtc.stabilizerAcceptor");
		GameRegistry.registerBlock(liquidMatterAcceptor, "mtc.liquidMatterAcceptor");
		GameRegistry.registerBlock(plasmaEjector, "mtc.plasmaEjector");
		GameRegistry.registerBlock(toxicWasteEjector, "mtc.toxicWasteEjector");
		GameRegistry.registerBlock(heatedCryotheumEjector, "mtc.heatedCryotheumEjector");
		GameRegistry.registerBlock(reactorPowerAcceptor, "mtc.reactorPowerAcceptor");
		GameRegistry.registerBlock(reactorTerminal, "mtc.reactorTerminal");
		GameRegistry.registerBlock(reactorCore, "mtc.reactorCore");
		GameRegistry.registerBlock(cooler, "mtc.cooler");
		GameRegistry.registerBlock(electrolizer, "mtc.electrolizer");
		GameRegistry.registerBlock(generatorController, "mtc.generatorController");
		GameRegistry.registerBlock(generatorEnergyPort, "mtc.generatorEnergyPort");
		GameRegistry.registerBlock(generatorFluidPort, "mtc.generatorFluidPort");
		GameRegistry.registerBlock(quarry, "mtc.quarry");
		GameRegistry.registerBlock(chunkRegistrator, "mtc.chunkRegistrator");
		GameRegistry.registerBlock(itemProvider, "mtc.itemProvider");
		GameRegistry.registerBlock(memoryCardReader, "mtc.memoryCardReader");
		GameRegistry.registerBlock(quarryPowerAcceptor,"mtc.quarryPowerAcceptor");
	}
}

