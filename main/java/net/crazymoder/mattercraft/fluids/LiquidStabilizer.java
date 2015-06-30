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

public class LiquidStabilizer {
	public static Fluid liquidStabilizer;
	public static Block liquidStabilizerBlock;
	public static Item liquidStabilizerBucket;
		public LiquidStabilizer(){
			liquidStabilizer = new Fluid("mtc.liquidStabilizer");
			liquidStabilizer.setTemperature(1).setDensity(10000).setViscosity(1000).setGaseous(false).setUnlocalizedName("mtc.liquidStabilizer");
			FluidRegistry.registerFluid(liquidStabilizer);
			liquidStabilizerBlock = new BasicFluidBlock(liquidStabilizer, Material.water, "mattercraft:liquidStabilizer");
			liquidStabilizerBlock.setBlockName("mtc.liquidStabilizer");
			GameRegistry.registerBlock(liquidStabilizerBlock, "mtc.liquidStabilizer");
			liquidStabilizerBucket = new ItemBucket(liquidStabilizerBlock);
			liquidStabilizerBucket.setUnlocalizedName("mtc.liquidStabilizerBucket").setTextureName("mattercraft:liquidStabilizerBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(liquidStabilizerBucket, "mtc.liquidStabilizerBucket");
			FluidContainerRegistry.registerFluidContainer(liquidStabilizer, new ItemStack(liquidStabilizerBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(liquidStabilizerBlock, liquidStabilizerBucket);
		}
			
}
