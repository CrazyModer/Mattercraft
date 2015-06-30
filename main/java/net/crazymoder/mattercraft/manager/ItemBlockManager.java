package net.crazymoder.mattercraft.manager;


import net.crazymoder.mattercraft.blocks.BasicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;


public class ItemBlockManager {
	
	public static Block reactorFrame;
	public static Block advancedReactorFrame;
	public static Block stoneWool;
	public static Block matterBlock;
	public static Block commpressedMatterBlock;
	public static Block doubleCommpressedMatterBlock;
	public static Block tripleCommpressedMatterBlock;
	public static Block superCommpressedMatterBlock;
	
	public ItemBlockManager(){
		
		reactorFrame = new BasicBlock(Material.iron);
	    advancedReactorFrame = new BasicBlock(Material.iron);	
	    stoneWool = new BasicBlock(Material.ground);
	    matterBlock = new BasicBlock(Material.ground);
	    commpressedMatterBlock = new BasicBlock(Material.ground);
	    doubleCommpressedMatterBlock = new BasicBlock(Material.ground);
	    tripleCommpressedMatterBlock = new BasicBlock(Material.ground);
	    superCommpressedMatterBlock = new BasicBlock(Material.ground);
	    
		
		reactorFrame.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorFrame").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		advancedReactorFrame.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.advancedReactorFrame").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		stoneWool.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stoneWool").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		matterBlock.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.matterBlock").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		commpressedMatterBlock.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.commpressedMatterBlock").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		doubleCommpressedMatterBlock.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.doubleCommpressedMatterBlock").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		tripleCommpressedMatterBlock.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.tripleCommpressedMatterBlock").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		superCommpressedMatterBlock.setHardness(5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.superCommpressedMatterBlock").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",0);
		
		reactorFrame.setBlockTextureName("mattercraft:reactorFrame");
		advancedReactorFrame.setBlockTextureName("mattercraft:advancedReactorFrame");
		stoneWool.setBlockTextureName("mattercraft:stoneWool");
		matterBlock.setBlockTextureName("mattercraft:matterblock");
		commpressedMatterBlock.setBlockTextureName("mattercraft:commpressedMatterblock");
		doubleCommpressedMatterBlock.setBlockTextureName("mattercraft:doubleCommpressedMatterBlock");
		tripleCommpressedMatterBlock.setBlockTextureName("mattercraft:tripleCommpressedMatterBlock");
		superCommpressedMatterBlock.setBlockTextureName("mattercraft:superCommpressedMatterBlock");
		
		GameRegistry.registerBlock(reactorFrame, "mtc.reactorFrame");
		GameRegistry.registerBlock(advancedReactorFrame, "mtc.advanceReactorFrame");
		GameRegistry.registerBlock(stoneWool, "mtc.stoneWool");
		GameRegistry.registerBlock(matterBlock, "mtc.matterBlock");
		GameRegistry.registerBlock(commpressedMatterBlock, "mtc.commpressedMatterBlock");
		GameRegistry.registerBlock(doubleCommpressedMatterBlock, "mtc.doubleCommpressedMatterBlock");
		GameRegistry.registerBlock(tripleCommpressedMatterBlock, "mtc.tripleCommpressedMatterBlock");
		GameRegistry.registerBlock(superCommpressedMatterBlock, "mtc.superCommpressedMatterBlock");
	}
}
