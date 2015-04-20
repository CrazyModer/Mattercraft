package net.crazymoder.mattercraft.Manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.BlockContainer.EnergyCore;
import net.crazymoder.mattercraft.Blocks.GenericBlock;
import net.crazymoder.mattercraft.TileEntity.EnergyCoreTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {
	//declarate Blocks
	public static Block energyPowerCore;
	
	public BlockManager(){
		//Initialize
		energyPowerCore = new EnergyCore(Material.ground);
		
		//Configure
		energyPowerCore.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("energyPowerCore").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		energyPowerCore.setBlockTextureName("mattercraft:energyPowerCore");
		//Register
		GameRegistry.registerBlock(energyPowerCore, "energyPowerCore");
		//
	}
}

