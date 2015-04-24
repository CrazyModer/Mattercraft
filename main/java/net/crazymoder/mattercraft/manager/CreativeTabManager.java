package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabManager {

	public static CreativeTabs tabBlocks = new CreativeTabs("mtc.blocks") {
	    public Item getTabIconItem() {
	        return Item.getItemFromBlock(GameRegistry.findBlock("mattercraft", "mtc.groundPlating"));
	    }
	};
	public static CreativeTabs tabItems = new CreativeTabs("mtc.items") {
	    public Item getTabIconItem() {
	    	return GameRegistry.findItem("mattercraft", "mtc.ionizedPlasmaBucket");
	    }
	};
}
