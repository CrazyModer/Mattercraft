package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemManager {
	//declarate
	Item key;
	public ItemManager(){
		//initialize
		key = new Item();
		//configure
		key.setUnlocalizedName("mtc.key").setCreativeTab(CreativeTabManager.tabItems);
		//texture
		key.setTextureName("mattercraft:key");
		//register
		GameRegistry.registerItem(key, "mtc.key");
	}
}
