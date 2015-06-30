package net.crazymoder.mattercraft.fluids;
import net.crazymoder.mattercraft.blocks.BasicFluidBlock;
import net.crazymoder.mattercraft.manager.BucketManager;
import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.crazymoder.mattercraft.material.FluidMaterial;
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

public class ToxicWaste {
		public static Fluid toxicWaste;
		public static Block toxicWasteBlock;
		public static Item toxicWasteBucket;
		public ToxicWaste(){
			toxicWaste = new Fluid("mtc.toxicWaste");
			toxicWaste.setTemperature(317).setDensity(1000).setViscosity(1000).setGaseous(false).setUnlocalizedName("mtc.toxicWaste");
			FluidRegistry.registerFluid(toxicWaste);
			toxicWasteBlock = new BasicFluidBlock(toxicWaste, Material.lava, "mattercraft:toxicWaste");
			toxicWasteBlock.setBlockName("mtc.toxicWaste");
			GameRegistry.registerBlock(toxicWasteBlock, "mtc.toxicWaste");
			toxicWasteBucket = new ItemBucket(toxicWasteBlock);
			toxicWasteBucket.setUnlocalizedName("mtc.toxicWasteBucket").setTextureName("mattercraft:toxicWasteBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(toxicWasteBucket, "mtc.toxicWasteBucket");
			FluidContainerRegistry.registerFluidContainer(toxicWaste, new ItemStack(toxicWasteBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(toxicWasteBlock, toxicWasteBucket);
		}
			
}
