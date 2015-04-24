package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crazymoder.mattercraft.blocks.BasicFluidBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidManager {
	//declarate fluids
	Fluid ionizedPlasma;
	
	//declarate Blocks
	Block ionizedPlasmaBlock;
	
	//declarate Buckits
	Item ionizedPlasmaBucket;
	
	public FluidManager(){
		//initialize fluids
		ionizedPlasma = new Fluid("mtc.ionizedPlasma");
		
		//configure fluids
		ionizedPlasma.setTemperature(100000).setDensity(1).setLuminosity(15).setViscosity(50).setGaseous(true);
		
		//register fluids
		FluidRegistry.registerFluid(ionizedPlasma);
		
		//initialize Blocks
		ionizedPlasmaBlock = new BasicFluidBlock(ionizedPlasma, Material.lava, "mattercraft:ionizedPlasma");
		
		//configure Blocks
		ionizedPlasmaBlock.setBlockName("mtc.ionizedPlasma");
		
		//register Blocks
		GameRegistry.registerBlock(ionizedPlasmaBlock, "mtc.ionizedPlasma");
		
		//initialize Buckits
		ionizedPlasmaBucket = new ItemBucket(ionizedPlasmaBlock);
		
		//configure Buckits
		ionizedPlasmaBucket.setUnlocalizedName("mtc.ionizedPlasmaBucket").setTextureName("mattercraft:ionizedPlasmaBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabs.tabMisc);
		
		//register Buckits
		GameRegistry.registerItem(ionizedPlasmaBucket, "mtc.ionizedPlasmaBucket");
		FluidContainerRegistry.registerFluidContainer(ionizedPlasma, new ItemStack(ionizedPlasmaBucket), new ItemStack(Items.bucket));
		
		//enable Buckit
		BucketManager.INSTANCE.buckets.put(ionizedPlasmaBlock, ionizedPlasmaBucket);
		
		//END
		MinecraftForge.EVENT_BUS.register(BucketManager.INSTANCE);
	}
}
