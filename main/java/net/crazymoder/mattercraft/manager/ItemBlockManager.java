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
	
	public ItemBlockManager(){
		
		reactorFrame = new BasicBlock(Material.iron);
	    advancedReactorFrame = new BasicBlock(Material.iron);	
	    stoneWool = new BasicBlock(Material.ground);
	    matterBlock = new BasicBlock(Material.ground);
		
		reactorFrame.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.reactorFrame").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",3);
		advancedReactorFrame.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.advancedReactorFrame").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",3);
		stoneWool.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.stoneWool").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",3);
		matterBlock.setHardness(1.5F).setStepSound(Block.soundTypeMetal).setBlockName("mtc.matterBlock").setCreativeTab(CreativeTabManager.tabItems).setHarvestLevel("pickaxe",3);
		
		
		reactorFrame.setBlockTextureName("mattercraft:reactorFrame");
		advancedReactorFrame.setBlockTextureName("mattercraft:advancedReactorFrame");
		stoneWool.setBlockTextureName("mattercraft:stoneWool");
		matterBlock.setBlockTextureName("mattercraft:matterblock");
		
		GameRegistry.registerBlock(reactorFrame, "mtc.reactorFrame");
		GameRegistry.registerBlock(advancedReactorFrame, "mtc.advanceReactorFrame");
		GameRegistry.registerBlock(stoneWool, "mtc.stoneWool");
		GameRegistry.registerBlock(matterBlock, "mtc.matterBlock");
	}
}
