package net.crazymoder.mattercraft.items.advanced;

import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class SoulCollector extends Item{

	public SoulCollector(String string) {
		this.setCreativeTab(CreativeTabManager.tabItems);
		this.setUnlocalizedName(string);
	}

}
