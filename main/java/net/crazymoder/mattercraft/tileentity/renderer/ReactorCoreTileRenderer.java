package net.crazymoder.mattercraft.tileentity.renderer;


import java.awt.Color;
import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.client.FMLClientHandler;
import net.crazymoder.mattercraft.tileentity.core.ReactorCoreTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ReactorCoreTileRenderer extends TileEntitySpecialRenderer{

	private static final ResourceLocation iner_model_texture = new ResourceLocation("mattercraft", "textures/models/power_sphere_layer_1.png");
	private static final ResourceLocation outer_model_texture = new ResourceLocation("mattercraft", "textures/models/power_sphere_layer_2.png");
	private IModelCustom innercore;

	public ReactorCoreTileRenderer(){
		innercore = AdvancedModelLoader.loadModel(new ResourceLocation("mattercraft", "models/core1.obj"));
	}
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float timeSinceLastTick) {
		y+=12;
		if (tile == null || !(tile instanceof ReactorCoreTile)) return;
		ReactorCoreTile core = (ReactorCoreTile) tile;
		if(!core.render)return;
		float scale = 8.5f;
		core.rotation += (timeSinceLastTick / 2F)*9001f;
		float rotation = core.rotation;

		GL11.glPushMatrix();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 150f, 150f);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x+0.5, y+0.5, z+0.5);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(iner_model_texture);


		double colour = Math.sin((float)Minecraft.getSystemTime() / 1f);
		float brightness = (float)Math.abs(Math.sin((float) Minecraft.getSystemTime() / 3000f) * 100f);

		colour = 1f - colour;
		GL11.glScalef(scale, scale, scale);
		GL11.glPushMatrix();
		GL11.glRotatef(rotation, 0F, 1F, 0.5F);
		GL11.glColor4d(1F, colour * 0.3f, colour * 0.7f, 1F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 80f + brightness, 80f + brightness);
		innercore.renderAll();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glScalef(0.8F, 0.8F, 0.8F);
		GL11.glColor4d(1F, 1f, 0.2f, 1F);
		GL11.glRotatef(rotation, 0F, 1F, 0.5F);
		innercore.renderAll();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glScalef(0.9F, 0.9F, 0.9F);
		GL11.glColor4d(1F, 0f, 0.2f, 1F);
		GL11.glRotatef(rotation, 0F, 1F, 0.5F);
		innercore.renderAll();
		GL11.glPopMatrix();

		GL11.glScalef(1.1F, 1.1F, 1.1F);
		GL11.glDepthMask(false);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(outer_model_texture);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200F, 200F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glRotatef(rotation*0.5F, 0F, -1F, -0.5F);
		GL11.glColor4f(0.5F, 2F, 2F, 0.7F);
		innercore.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);


		GL11.glPopMatrix();
	}

}
