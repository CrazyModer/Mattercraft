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

public class LiquidMatter {
		Fluid liquidMatter;
		Block liquidMatterBlock;
		Item liquidMatterBucket;
		public LiquidMatter(){
			liquidMatter = new Fluid("mtc.liquidMatter");
			liquidMatter.setTemperature(100000).setDensity(1).setViscosity(50).setGaseous(true).setUnlocalizedName("mtc.liquidMatter");
			FluidRegistry.registerFluid(liquidMatter);
			liquidMatterBlock = new BasicFluidBlock(liquidMatter, Material.water, "mattercraft:liquidMatter");
			liquidMatterBlock.setBlockName("mtc.liquidMatter");
			GameRegistry.registerBlock(liquidMatterBlock, "mtc.liquidMatter");
			liquidMatterBucket = new ItemBucket(liquidMatterBlock);
			liquidMatterBucket.setUnlocalizedName("mtc.liquidMatterBucket").setTextureName("mattercraft:liquidMatterBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(liquidMatterBucket, "mtc.liquidMatterBucket");
			FluidContainerRegistry.registerFluidContainer(liquidMatter, new ItemStack(liquidMatterBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(liquidMatterBlock, liquidMatterBucket);
		}
			
}
