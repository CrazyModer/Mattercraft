package net.crazymoder.mattercraft.Manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.Blocks.GenericBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {
	//declarate Blocks
	public static Block powerTester;
	
	public BlockManager(){
		//Initialize
		powerTester = new GenericBlock(Material.ground);
		
		//Configure
		powerTester.setHardness(0.5F).setStepSound(Block.soundTypeGravel).setBlockName("powerTester").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		powerTester.setBlockTextureName("mattercraft:test_block");
		//Register
		GameRegistry.registerBlock(powerTester, "powerTester");
		//
	}
}
