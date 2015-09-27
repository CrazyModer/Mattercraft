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
import net.crazymoder.mattercraft.blockcontainer.MobCrafter;
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
import net.crazymoder.mattercraft.material.BlockMaterial;
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
	public static Block infinityPlating;

	
	
	
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
	public static Block mobCrafter;
	
	public BlockManager(){
		//Initialize Blocks
		groundPlating = new BasicBlock(BlockMaterial.matter);
		reinforcedPlating = new BasicBlock(BlockMaterial.matter);
		iridiumPalting = new BasicBlock(BlockMaterial.matter);
		osmiumPlating = new BasicBlock(BlockMaterial.matter);
		stabilizer = new FrontTextureBlock(BlockMaterial.matter);
		forceFieldEmitter = new BasicBlock(BlockMaterial.matter);
		stabilizerPillar = new MultiTextureBlock(BlockMaterial.matter);
		plasmaExtractor = new MultiTextureBlock(BlockMaterial.matter);
		wormHoleStabilizer = new MultiTextureBlock(BlockMaterial.matter);
		matterInjector = new MultiTextureBlock(BlockMaterial.matter);
		osmiumOre = new BasicBlock(BlockMaterial.matter);
		iridiumOre =new BasicBlock(BlockMaterial.matter);
		unstableMatter = new BasicBlock(BlockMaterial.matter);
		generatorPlating = new BasicBlock(BlockMaterial.matter);		
		heatSink = new BasicBlock(BlockMaterial.matter);
		peltier = new MultiTextureBlock(BlockMaterial.matter);
		exhaustPipe = new MultiTextureBlock(BlockMaterial.matter);
		waterInjector = new MultiTextureBlock(BlockMaterial.matter);
		plasmaInjector = new MultiTextureBlock(BlockMaterial.matter);
		emptyChunkRegistrator = new MultiTextureBlock(BlockMaterial.matter);
		infinityPlating = new BasicBlock(BlockMaterial.matter);
		
		
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
		mobCrafter = new MobCrafter();
		
		//Configure Blocks
		groundPlating.setHardness(15F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.groundPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		reinforcedPlating.setHardness(25F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reinforcedPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		iridiumPalting.setHardness(40F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.iridiumPalting").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		osmiumPlating.setHardness(30F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.osmiumPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		stabilizer.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizer").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		forceFieldEmitter.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.forceFieldEmitter").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		stabilizerPillar.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizerPillar").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		plasmaExtractor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.plasmaExtractor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		wormHoleStabilizer.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.wormHoleStabilizer").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		matterInjector.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.matterInjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		osmiumOre.setHardness(30F).setStepSound(Block.soundTypeStone).setBlockName("mtc.osmiumOre").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		iridiumOre.setHardness(40F).setStepSound(Block.soundTypeStone).setBlockName("mtc.iridiumOre").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		unstableMatter.setHardness(0.1F).setStepSound(Block.soundTypeStone).setBlockName("mtc.unstableMatter").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		generatorPlating.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",4);
		heatSink.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.heatSink").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		peltier.setHardness(15F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.peltier").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		exhaustPipe.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.exhaustPipe").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		waterInjector.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.waterInjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		plasmaInjector.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.plasmaInjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		emptyChunkRegistrator.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.emptyChunkRegistrator").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);	
		infinityPlating.setHardness(100F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.infinityPlating").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);	
		
		//Configure Block Containers
		cryotheumAcceptor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.cryotheumAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		hydrogenAcceptor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.hydrogenAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		stabilizerAcceptor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		liquidMatterAcceptor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.liquidMatterAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		plasmaEjector.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.plasmaEjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		toxicWasteEjector.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.toxicWasteEjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		heatedCryotheumEjector.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.heatedCryotheumEjector").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		reactorPowerAcceptor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorPowerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		reactorTerminal.setHardness(4F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorTerminal").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		reactorCore.setHardness(50F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorCore").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		cooler.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.cooler").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		electrolizer.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.electrolizer").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		generatorController.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorController").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		generatorEnergyPort.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorEnergyPort").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		generatorFluidPort.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.generatorFluidPort").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		quarry.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.quarry").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		chunkRegistrator.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.chunkRegistrator").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		itemProvider.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.itemProvider").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		memoryCardReader.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.memoryCardReader").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		quarryPowerAcceptor.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.quarryPowerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		mobCrafter.setHardness(10F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.mobCrafter").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",0);
		
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
		infinityPlating.setBlockTextureName("mattercraft:infinityPlating");
		
		
		
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
		mobCrafter.setBlockTextureName("mattercraft:mobCrafter");
		
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
		GameRegistry.registerBlock(infinityPlating, "mtc.infinityPlating");
		
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
		GameRegistry.registerBlock(mobCrafter,"mtc.mobCrafter");
	}
}

