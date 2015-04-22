package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.blockcontainer.EnergyPowerCore;
import net.crazymoder.mattercraft.blockcontainer.NormalBlock;
import net.crazymoder.mattercraft.blocks.GroundPlating;
import net.crazymoder.mattercraft.tileentity.EnergyPowerCoreTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {
	//declarate Blocks
	public static Block energyPowerCore;
	public static Block normalBlock;
	public static Block groundPlating;
	
	public BlockManager(){
		//Initialize
		energyPowerCore = new EnergyPowerCore(Material.ground);
		normalBlock = new NormalBlock(Material.ground);
		groundPlating = new GroundPlating(Material.ground);
		
		//Configure
		energyPowerCore.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("energyPowerCore").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		normalBlock.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("normalBlock").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		groundPlating.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("groundPlating").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		//Textures
		energyPowerCore.setBlockTextureName("mattercraft:energyPowerCore");
		normalBlock.setBlockTextureName("mattercraft:normalBlock");
		groundPlating.setBlockTextureName("mattercraft:groundPlating");
		//Register
		GameRegistry.registerBlock(energyPowerCore, "energyPowerCore");
		GameRegistry.registerBlock(normalBlock, "normalBlock");
		GameRegistry.registerBlock(groundPlating, "groundPlating");
	}
}

