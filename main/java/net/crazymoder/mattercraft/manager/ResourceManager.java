package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.util.ResourceLocation;

public class ResourceManager {
	private static ResourceLocation defaultParticles;
	private static final ResourceLocation particles = new ResourceLocation("mattercraft", "textures/particels/particles.png");
	public static void bindDefaultParticles()
	{
		if (defaultParticles == null)
		{
			try
			{
				defaultParticles = (ResourceLocation) ReflectionHelper.getPrivateValue(EffectRenderer.class, null, "particleTextures", "field_110737_b");
			}
			catch (Exception e) {}
		}
		if (defaultParticles != null) bindTexture(defaultParticles);
	}
	
	public static void bindTexture(ResourceLocation texture)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	}
	
	public static void bindParticles()
	{
		bindTexture(particles);
	}
}
