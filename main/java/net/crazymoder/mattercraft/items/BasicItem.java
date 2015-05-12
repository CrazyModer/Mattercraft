package net.crazymoder.mattercraft.items;

import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;

public class BasicItem extends Item{
	public BasicItem(String unlocalizedName){
		this.setCreativeTab(CreativeTabManager.tabItems);
		this.setUnlocalizedName(unlocalizedName);
	}
}
