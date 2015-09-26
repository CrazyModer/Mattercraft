package net.crazymoder.mattercraft.helper.manual;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.ResourceLocation;

public class ManualResources {
	public static ResourceLocation defaultRes;
	public static List<ResourceLocation> screens;
	public static int index = 0; 
	
	public static void register(){
		defaultRes = new ResourceLocation("mattercraft", "textures/gui/Manual/default.png");
		screens = new ArrayList<ResourceLocation>();
		for (int i = 0; i < 15; i++) {
			screens.add(new ResourceLocation("mattercraft", "textures/gui/Manual/"+(i+1)+".png"));
		}
	}
}
