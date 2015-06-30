package net.crazymoder.mattercraft.helper.manual;

import net.minecraft.util.ResourceLocation;

public class ManualResources {
	public static ResourceLocation defaultRes;
	public static ResourceLocation screenShot1;
	
	public static void register(){
		defaultRes = new ResourceLocation("mattercraft", "textures/gui/Manual/default.png");
		screenShot1 = new ResourceLocation("mattercraft", "textures/gui/Manual/1.png");
	}
}
