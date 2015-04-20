package net.crazymoder.mattercraft.Manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.BlockContainer.EnergyPowerCore;
import net.crazymoder.mattercraft.BlockContainer.NormalBlock;
import net.crazymoder.mattercraft.Blocks.GenericBlock;
import net.crazymoder.mattercraft.TileEntity.EnergyPowerCoreTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {
	//declarate Blocks
	public static Block energyPowerCore;
	public static Block normalBlock;
	
	public BlockManager(){
		//Initialize
		energyPowerCore = new EnergyPowerCore(Material.ground);
		normalBlock = new NormalBlock(Material.ground);
		
		//Configure
		energyPowerCore.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("energyPowerCore").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		normalBlock.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("normalBlock").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		//Textures
		energyPowerCore.setBlockTextureName("mattercraft:energyPowerCore");
		normalBlock.setBlockTextureName("mattercraft:normalBlock");
		//Register
		GameRegistry.registerBlock(energyPowerCore, "energyPowerCore");
		GameRegistry.registerBlock(normalBlock, "normalBlock");
	}
}

