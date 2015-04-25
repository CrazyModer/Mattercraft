package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.blockcontainer.CryotheumAcceptor;
import net.crazymoder.mattercraft.blockcontainer.HydrogenAcceptor;
import net.crazymoder.mattercraft.blockcontainer.StabilizerAcceptor;
import net.crazymoder.mattercraft.blocks.BasicBlock;
import net.crazymoder.mattercraft.blocks.MultiTextureBlock;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
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
	
	//declarate Block Container
	CryotheumAcceptor cryotheumAcceptor;
	HydrogenAcceptor hydrogenAcceptor;
	StabilizerAcceptor stabilizerAcceptor;
	
	
	public BlockManager(){
		//Initialize Blocks
		groundPlating = new BasicBlock(Material.ground);
		reinforcedPlating = new BasicBlock(Material.ground);
		iridiumPalting = new BasicBlock(Material.iron);
		osmiumPlating = new BasicBlock(Material.iron);
		stabilizer = new BasicBlock(Material.piston);
		forceFieldEmitter = new BasicBlock(Material.iron);
		stabilizerPillar = new MultiTextureBlock(Material.iron);
		plasmaExtractor = new MultiTextureBlock(Material.piston);
		wormHoleStabilizer = new MultiTextureBlock(Material.piston);
		matterInjector = new MultiTextureBlock(Material.piston);
		
		//Initialize Block Containers
		cryotheumAcceptor = new CryotheumAcceptor();
		hydrogenAcceptor = new HydrogenAcceptor();
		stabilizerAcceptor = new StabilizerAcceptor();
		
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
		
		//Configure Block Containers
		cryotheumAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.cryotheumAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		hydrogenAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.hydrogenAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		stabilizerAcceptor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stabilizerAcceptor").setCreativeTab(CreativeTabManager.tabBlocks).setHarvestLevel("pickaxe",3);
		
		
		//Single Texture Blocks
		groundPlating.setBlockTextureName("mattercraft:groundPlating");
		reinforcedPlating.setBlockTextureName("mattercraft:reinforcedPlating");
		iridiumPalting.setBlockTextureName("mattercraft:iridiumPalting");
		osmiumPlating.setBlockTextureName("mattercraft:osmiumPlating");
		stabilizer.setBlockTextureName("mattercraft:stabilizer");
		forceFieldEmitter.setBlockTextureName("mattercraft:forceFieldEmitter");
		
		//Multi Texture Blocks
		stabilizerPillar.setBlockTextureName("mattercraft:stabilizerPillar");
		plasmaExtractor.setBlockTextureName("mattercraft:plasmaExtractor");
		wormHoleStabilizer.setBlockTextureName("mattercraft:wormHoleStabilizer");
		matterInjector.setBlockTextureName("mattercraft:matterInjector");
		
		//Single Texture Block Container
		
		//Multi Texture Block Container
		cryotheumAcceptor.setBlockTextureName("mattercraft:cryotheumAcceptor");
		hydrogenAcceptor.setBlockTextureName("mattercraft:hydrogenAcceptor");
		stabilizerAcceptor.setBlockTextureName("mattercraft:stabilizerAcceptor");
		
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
		
		//Register Block Container
		GameRegistry.registerBlock(cryotheumAcceptor, "mtc.cryotheumAcceptor");
		GameRegistry.registerBlock(hydrogenAcceptor, "mtc.hydrogenAcceptor");
		GameRegistry.registerBlock(stabilizerAcceptor, "mtc.stabilizerAcceptor");
		
	}
}

