package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.items.advanced.ChunkMemoryCard;
import net.minecraft.item.Item;

public class AdvancedItemManager {
	//declarate 
	public static Item chunkMemoryCard;
	public AdvancedItemManager(){
		//initialize
		chunkMemoryCard = new ChunkMemoryCard("mtc.chunkMemoryCard");
		
		//texture
		chunkMemoryCard.setTextureName("mattercraft:chunkMemoryCard");
		
		//register
		GameRegistry.registerItem(chunkMemoryCard, "mtc.chunkMemoryCard");
		
	}
}
