package net.crazymoder.mattercraft.craftingmanager;

import java.util.ArrayList;

import net.crazymoder.mattercraft.manager.ItemBlockManager;
import net.crazymoder.mattercraft.manager.ItemManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaCraftingManager {
	
	public VanillaCraftingManager(){
		
		StaticItemStacks.dustCryotheum.stackSize=64;
		GameRegistry.addRecipe(StaticItemStacks.dustCryotheum, new Object[]{
		     "ABA",
		     "BCB",
		     "ABA",
		     'A', Items.snowball,'B',StaticItemStacks.dustBlizz,'C',ItemManager.absorbedToxicWaste
		});
		
		GameRegistry.addRecipe(new ItemStack(ItemBlockManager.stoneWool,8), new Object[]{
			"ABA",
			"BCB",
			"ABA",
			'A', Blocks.obsidian,'B',Blocks.stone,'C',Blocks.wool
		});
		
	}
}
