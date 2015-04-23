package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.blocks.BasicBlock;
import net.crazymoder.mattercraft.blocks.MultiTextureBlock;
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
	
	//Creativ tab
	public static CreativeTabs tab = new CreativeTabs("blocks") {
	    public Item getTabIconItem() {
	        return Item.getItemFromBlock(groundPlating);
	    }
	};
	
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
		//Configure Blocks
		groundPlating.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("groundPlating").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		reinforcedPlating.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("reinforcedPlating").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		iridiumPalting.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("iridiumPalting").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		osmiumPlating.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("osmiumPlating").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		stabilizer.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("stabilizer").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		forceFieldEmitter.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("forceFieldEmitter").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		stabilizerPillar.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("stabilizerPillar").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		plasmaExtractor.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("plasmaExtractor").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		wormHoleStabilizer.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("wormHoleStabilizer").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		matterInjector.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("matterInjector").setCreativeTab(tab).setHarvestLevel("pickaxe",3);
		//Single Texture Blocks
		groundPlating.setBlockTextureName("mattercraft:groundPlating");
		reinforcedPlating.setBlockTextureName("mattercraft:reinforcedPlating");
		iridiumPalting.setBlockTextureName("mattercraft:iridiumPalting");
		osmiumPlating.setBlockTextureName("mattercraft:osmiumPlating");
		stabilizer.setBlockTextureName("mattercraft:stabilizer");
		forceFieldEmitter.setBlockTextureName("mattercraft:forceFieldEmitter");
		//Register Blocks
		GameRegistry.registerBlock(groundPlating, "groundPlating");
		GameRegistry.registerBlock(reinforcedPlating, "reinforcedPlating");
		GameRegistry.registerBlock(iridiumPalting, "iridiumPalting");
		GameRegistry.registerBlock(osmiumPlating, "osmiumPlating");
		GameRegistry.registerBlock(stabilizer, "stabilizer");
		GameRegistry.registerBlock(forceFieldEmitter, "forceFieldEmitter");
		GameRegistry.registerBlock(stabilizerPillar, "stabilizerPillar");
		GameRegistry.registerBlock(plasmaExtractor, "plasmaExtractor");
		GameRegistry.registerBlock(wormHoleStabilizer, "wormHoleStabilizer");
		GameRegistry.registerBlock(matterInjector, "matterInjector");
		
	}
}

