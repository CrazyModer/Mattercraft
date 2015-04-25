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

public class HeatedCryotheum {
		Fluid heatedCryotheum;
		Block heatedCryotheumBlock;
		Item heatedCryotheumBucket;
		public HeatedCryotheum(){
			heatedCryotheum = new Fluid("mtc.heatedCryotheum");
			heatedCryotheum.setTemperature(100000).setDensity(1).setViscosity(50).setGaseous(true).setUnlocalizedName("mtc.heatedCryotheum");
			FluidRegistry.registerFluid(heatedCryotheum);
			heatedCryotheumBlock = new BasicFluidBlock(heatedCryotheum, Material.water, "mattercraft:heatedCryotheum");
			heatedCryotheumBlock.setBlockName("mtc.heatedCryotheum");
			GameRegistry.registerBlock(heatedCryotheumBlock, "mtc.heatedCryotheum");
			heatedCryotheumBucket = new ItemBucket(heatedCryotheumBlock);
			heatedCryotheumBucket.setUnlocalizedName("mtc.heatedCryotheumBucket").setTextureName("mattercraft:heatedCryotheumBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(heatedCryotheumBucket, "mtc.heatedCryotheumBucket");
			FluidContainerRegistry.registerFluidContainer(heatedCryotheum, new ItemStack(heatedCryotheumBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(heatedCryotheumBlock, heatedCryotheumBucket);
		}
			
}
