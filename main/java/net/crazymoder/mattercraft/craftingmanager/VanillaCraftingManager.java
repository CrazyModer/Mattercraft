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

		GameRegistry.addRecipe(new ItemStack(ItemBlockManager.matterBlock,2), new Object[]{
			"AAA",
			"ABA",
			"AAA",
			'A', Blocks.cobblestone,'B',Blocks.stone
		});
		GameRegistry.addRecipe(new ItemStack(ItemBlockManager.commpressedMatterBlock,2), new Object[]{
		     "BAB",
		     "ABA",
		     "BAB",
		     'A', ItemBlockManager.matterBlock,'B',Blocks.sandstone
		});
		GameRegistry.addRecipe(new ItemStack(ItemBlockManager.doubleCommpressedMatterBlock,2), new Object[]{
		     "BAB",
		     "ABA",
		     "BAB",
		     'A', ItemBlockManager.commpressedMatterBlock,'B',Blocks.glass
		});
		GameRegistry.addRecipe(new ItemStack(ItemBlockManager.tripleCommpressedMatterBlock,2), new Object[]{
		     "BAB",
		     "ABA",
		     "BAB",
		     'A', ItemBlockManager.doubleCommpressedMatterBlock,'B',Blocks.obsidian
		});
		
	}
}
