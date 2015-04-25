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

public class Stabilizer {
		Fluid stabilizer;
		Block stabilizerBlock;
		Item stabilizerBucket;
		public Stabilizer(){
			stabilizer = new Fluid("mtc.stabilizer");
			stabilizer.setTemperature(1).setDensity(1).setViscosity(500).setGaseous(true).setUnlocalizedName("mtc.stabilizer");
			FluidRegistry.registerFluid(stabilizer);
			stabilizerBlock = new BasicFluidBlock(stabilizer, Material.water, "mattercraft:stabilizer");
			stabilizerBlock.setBlockName("mtc.stabilizer");
			GameRegistry.registerBlock(stabilizerBlock, "mtc.stabilizer");
			stabilizerBucket = new ItemBucket(stabilizerBlock);
			stabilizerBucket.setUnlocalizedName("mtc.stabilizerBucket").setTextureName("mattercraft:stabilizerBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(stabilizerBucket, "mtc.stabilizerBucket");
			FluidContainerRegistry.registerFluidContainer(stabilizer, new ItemStack(stabilizerBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(stabilizerBlock, stabilizerBucket);
		}
			
}
