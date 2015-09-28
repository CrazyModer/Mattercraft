package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.items.BasicItem;
import net.crazymoder.mattercraft.items.advanced.ChunkMemoryCard;
import net.crazymoder.mattercraft.items.advanced.MatterManual;
import net.crazymoder.mattercraft.items.advanced.MobSoul;
import net.crazymoder.mattercraft.items.advanced.SoulCollector;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class AdvancedItemManager {
	//declarate 
	public static Item chunkMemoryCard;
	public static Item matterManual;
	public static Item mobSoul;
	public static Item soulCollector;
	
	public AdvancedItemManager(){
		//initialize
		chunkMemoryCard = new ChunkMemoryCard("mtc.chunkMemoryCard");
		matterManual = new MatterManual("mtc.matterManual");
		mobSoul = new MobSoul("mtc.mobSoul");
		soulCollector = new SoulCollector("mtc.soulCollector");
		
		
		//texture
		chunkMemoryCard.setTextureName("mattercraft:chunkMemoryCard");
		matterManual.setTextureName("mattercraft:matterManual");
		mobSoul.setTextureName("mattercraft:Mattermanual");
		soulCollector.setTextureName("mattercraft:soulCollector");		
		
		//register
		GameRegistry.registerItem(chunkMemoryCard, "mtc.chunkMemoryCard");
		GameRegistry.registerItem(matterManual, "mtc.matterManual");
		GameRegistry.registerItem(mobSoul, "mtc.mobSoul");
		GameRegistry.registerItem(soulCollector, "mtc.soulCollector");
	}
}
