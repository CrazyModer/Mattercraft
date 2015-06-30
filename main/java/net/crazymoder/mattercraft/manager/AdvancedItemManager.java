package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.items.advanced.ChunkMemoryCard;
import net.crazymoder.mattercraft.items.advanced.MatterManual;
import net.minecraft.item.Item;

public class AdvancedItemManager {
	//declarate 
	public static Item chunkMemoryCard;
	public static Item matterManual;
	public AdvancedItemManager(){
		//initialize
		chunkMemoryCard = new ChunkMemoryCard("mtc.chunkMemoryCard");
		matterManual = new MatterManual("mtc.matterManual");
		
		//texture
		chunkMemoryCard.setTextureName("mattercraft:chunkMemoryCard");
		matterManual.setTextureName("mattercraft:matterManual");
		
		//register
		GameRegistry.registerItem(chunkMemoryCard, "mtc.chunkMemoryCard");
		GameRegistry.registerItem(matterManual, "mtc.matterManual");
	}
}
