package net.crazymoder.mattercraft.craftingmanager;

import cofh.api.modhelpers.ThermalExpansionHelper;
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
				new ItemStack(ItemBlockManager.stoneWool),
				new ItemStack(ItemManager.absorber),
				new ItemStack(Items.string),50);
		
		ThermalExpansionHelper.addTransposerFill(1000,
				new ItemStack(ItemManager.absorber),
				new ItemStack(ItemManager.absorbedToxicWaste),
				new FluidStack(ToxicWaste.toxicWaste, 1000), false);
		
	}
}
