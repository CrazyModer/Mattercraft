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

public class IonizedPlasma {
		Fluid ionizedPlasma;
		Block ionizedPlasmaBlock;
		Item ionizedPlasmaBucket;
		public IonizedPlasma(){
			ionizedPlasma = new Fluid("mtc.ionizedPlasma");
			ionizedPlasma.setTemperature(100000).setDensity(1).setViscosity(5000).setGaseous(true).setUnlocalizedName("mtc.ionizedPlasma");
			FluidRegistry.registerFluid(ionizedPlasma);
			ionizedPlasmaBlock = new BasicFluidBlock(ionizedPlasma, Material.water, "mattercraft:ionizedPlasma");
			ionizedPlasmaBlock.setBlockName("mtc.ionizedPlasma");
			GameRegistry.registerBlock(ionizedPlasmaBlock, "mtc.ionizedPlasma");
			ionizedPlasmaBucket = new ItemBucket(ionizedPlasmaBlock);
			ionizedPlasmaBucket.setUnlocalizedName("mtc.ionizedPlasmaBucket").setTextureName("mattercraft:ionizedPlasmaBucket").setContainerItem(Items.bucket).setCreativeTab(CreativeTabManager.tabItems);
			GameRegistry.registerItem(ionizedPlasmaBucket, "mtc.ionizedPlasmaBucket");
			FluidContainerRegistry.registerFluidContainer(ionizedPlasma, new ItemStack(ionizedPlasmaBucket), new ItemStack(Items.bucket));
			BucketManager.INSTANCE.buckets.put(ionizedPlasmaBlock, ionizedPlasmaBucket);
		}
			
}
