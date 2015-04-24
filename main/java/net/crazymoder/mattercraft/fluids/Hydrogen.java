package net.crazymoder.mattercraft.fluids;
import net.crazymoder.mattercraft.blocks.BasicFluidBlock;
import net.crazymoder.mattercraft.manager.BucketManager;
import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Hydrogen {
		Fluid hydrogen;
		Block hydrogenBlock;
		Item hydrogenBucket;
		public Hydrogen(){
			hydrogen = new Fluid("mtc.hydrogen");
			hydrogen.setTemperature(372).setDensity(1).setViscosity(500).setGaseous(true).setUnlocalizedName("mtc.hydrogen");
			FluidRegistry.registerFluid(hydrogen);
			hydrogenBlock = new BasicFluidBlock(hydrogen, Material.water, "mattercraft:hydrogen");
			hydrogenBlock.setBlockName("mtc.hydrogen");
			GameRegistry.registerBlock(hydrogenBlock, "mtc.hydrogen");
			hydrogenBucket = new ItemBucket(hydrogenBlock);
			hydrogenBucket.setUnlocalizedName("mtc.hydrogenBucket").setTextureName("mattercraft:hydrogenBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(hydrogenBucket, "mtc.hydrogenBucket");
			FluidContainerRegistry.registerFluidContainer(hydrogen, new ItemStack(hydrogenBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(hydrogenBlock, hydrogenBucket);
		}
			
}
