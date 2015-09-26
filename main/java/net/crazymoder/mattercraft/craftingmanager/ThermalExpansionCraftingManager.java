package net.crazymoder.mattercraft.craftingmanager;

import cofh.api.modhelpers.ThermalExpansionHelper;
import net.crazymoder.mattercraft.fluids.IonizedPlasma;
import net.crazymoder.mattercraft.fluids.LiquidMatter;
import net.crazymoder.mattercraft.fluids.LiquidStabilizer;
import net.crazymoder.mattercraft.fluids.ToxicWaste;
import net.crazymoder.mattercraft.manager.ItemBlockManager;
import net.crazymoder.mattercraft.manager.ItemManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fluids.FluidStack;

public class ThermalExpansionCraftingManager {
	public ThermalExpansionCraftingManager(){
		
		ThermalExpansionHelper.addPulverizerRecipe(1000,
				new ItemStack(Blocks.glass_pane),
				new ItemStack(ItemManager.absorber));
		
		
		ThermalExpansionHelper.addTransposerFill(1000,
				new ItemStack(ItemManager.absorber),
				new ItemStack(ItemManager.absorbedToxicWaste),
				new FluidStack(ToxicWaste.toxicWaste, 1000), false);
		
		ThermalExpansionHelper.addTransposerFill(1000,
				new ItemStack(ItemBlockManager.tripleCommpressedMatterBlock),
				new ItemStack(ItemBlockManager.superCommpressedMatterBlock),
				new FluidStack(LiquidMatter.liquidMatter, 1000), false);
		
		ThermalExpansionHelper.addChargerRecipe(100000, new ItemStack(ItemManager.stabilizerDust), new ItemStack(ItemManager.enrichedStabilizerDust));
		
		ThermalExpansionHelper.addCrucibleRecipe(10000, new ItemStack(ItemManager.enrichedStabilizerDust), new FluidStack(LiquidStabilizer.liquidStabilizer, 1000));
		
		ThermalExpansionHelper.addCrucibleRecipe(100000, new ItemStack(ItemBlockManager.tripleCommpressedMatterBlock), new FluidStack(LiquidMatter.liquidMatter, 50));
		
		ThermalExpansionHelper.addCrucibleRecipe(50000, new ItemStack(ItemBlockManager.superCommpressedMatterBlock), new FluidStack(LiquidMatter.liquidMatter, 20000));
		
	}
}
