package net.crazymoder.mattercraft.Manager;

import cpw.mods.fml.common.registry.GameRegistry;
<<<<<<< HEAD
import net.crazymoder.mattercraft.BlockContainer.EnergyCollector;
import net.crazymoder.mattercraft.BlockContainer.NormalBlock;
=======
import net.crazymoder.mattercraft.BlockContainer.EnergyCore;
>>>>>>> origin/master
import net.crazymoder.mattercraft.Blocks.GenericBlock;
import net.crazymoder.mattercraft.TileEntity.EnergyCoreTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {
	//declarate Blocks
<<<<<<< HEAD
	public static Block energyCollector;
	public static Block normalBlock;
	
	public BlockManager(){
		//Initialize
		energyCollector = new EnergyCollector(Material.ground);
		normalBlock = new NormalBlock(Material.ground);
		
		//Configure
		energyCollector.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("energyCollector").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		energyCollector.setBlockTextureName("mattercraft:energyCollector");
		normalBlock.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("normalBlock").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		//Register
		GameRegistry.registerBlock(energyCollector, "energyCollector");
		GameRegistry.registerBlock(normalBlock, "normalBlock");
=======
	public static Block energyPowerCore;
	
	public BlockManager(){
		//Initialize
		energyPowerCore = new EnergyCore(Material.ground);
		
		//Configure
		energyPowerCore.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("energyPowerCore").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		energyPowerCore.setBlockTextureName("mattercraft:energyPowerCore");
		//Register
		GameRegistry.registerBlock(energyPowerCore, "energyPowerCore");
>>>>>>> origin/master
		//
	}
}

