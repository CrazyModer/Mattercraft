package net.crazymoder.mattercraft.craftingmanager;

import cofh.api.modhelpers.ThermalExpansionHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class ThermalExpansionCraftingManager {
	public ThermalExpansionCraftingManager(){
		ItemStack diablock = new ItemStack(Blocks.diamond_block);
		ItemStack diaitem = new ItemStack(Items.diamond,9);
		ItemStack emerald = new ItemStack(Items.emerald,1);
		ThermalExpansionHelper.addPulverizerRecipe(10000, diablock, diaitem, emerald, 50);
	}
}
