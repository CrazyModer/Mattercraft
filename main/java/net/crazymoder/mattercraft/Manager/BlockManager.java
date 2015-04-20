package net.crazymoder.mattercraft.Manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.BlockContainer.EnergyCollector;
import net.crazymoder.mattercraft.Blocks.GenericBlock;
import net.crazymoder.mattercraft.TileEntity.EnergyCollectorTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {
	//declarate Blocks
	public static Block energyCollector;
	
	public BlockManager(){
		//Initialize
		energyCollector = new EnergyCollector(Material.ground);
		
		//Configure
		energyCollector.setHardness(0.5F).setStepSound(Block.soundTypeMetal).setBlockName("energyCollector").setCreativeTab(CreativeTabs.tabBlock).setHarvestLevel("pickaxe",0);
		energyCollector.setBlockTextureName("mattercraft:energyCollector");
		//Register
		GameRegistry.registerBlock(energyCollector, "energyCollector");
		//
	}
}

