package net.crazymoder.mattercraft.craftingmanager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class StaticItemStacks {
	public static ItemStack dustCryotheum;
	public static ItemStack dustBlizz;
	public static ItemStack dustNiter;
	public static ItemStack dustEnderium;
	
	public static void init(){
		dustCryotheum = GameRegistry.findItemStack("ThermalFoundation", "dustCryotheum", 1);
		dustBlizz = GameRegistry.findItemStack("ThermalFoundation", "dustBlizz", 1);
		dustNiter = GameRegistry.findItemStack("ThermalFoundation", "dustNiter", 1);
		dustEnderium = GameRegistry.findItemStack("ThermalFoundation", "dustEnderium", 1);
	}
}
