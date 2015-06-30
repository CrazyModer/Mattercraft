package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.items.BasicItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemManager {
	
	
	//declarate
	public static Item absorber;
	public static Item absorbedToxicWaste; 
	public static Item stabilizerDust;
	public static Item enrichedStabilizerDust; 
	public static Item glasDust;

	public ItemManager(){
		//initialize
		absorber = new BasicItem("mtc.absorber");
		absorbedToxicWaste = new BasicItem("mtc.absorbedToxicWaste");
		stabilizerDust = new BasicItem("mtc.stabilizerDust");
		enrichedStabilizerDust = new BasicItem("mtc.enrichedStabilizerDust");
		glasDust = new BasicItem("mtc.glasDust");
		
		//texture
		absorber.setTextureName("mattercraft:absorber");
		absorbedToxicWaste.setTextureName("mattercraft:absorbedToxicWaste");
		stabilizerDust.setTextureName("mattercraft:stabilizerDust"); 
		enrichedStabilizerDust.setTextureName("mattercraft:enrichedStabilizerDust");
		glasDust.setTextureName("mattercraft:glasDust");
		
		
		//register
		GameRegistry.registerItem(absorber, "mtc.absorber","mattercraft");
		GameRegistry.registerItem(absorbedToxicWaste, "mtc.absorbedToxicWaste");
		GameRegistry.registerItem(stabilizerDust, "mtc.stabilizerDust");
		GameRegistry.registerItem(enrichedStabilizerDust, "mtc.enrichedStabilizerDust");
		GameRegistry.registerItem(glasDust, "mtc.glasDust");
	}
}
