package net.crazymoder.mattercraft.tileentity.renderer;


import java.awt.Color;
import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.client.FMLClientHandler;
import net.crazymoder.mattercraft.tileentity.core.LogisticHandler;
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
		if(!core.renderingHandler.render)return;
		float capacity = (float)(core.renderingHandler.antiMatter) / (float)(LogisticHandler.antiMatter_m*2) + (float)(core.renderingHandler.matter) / (float)(LogisticHandler.matter_m*2);
		float inScale = 7f*capacity+1.5f;
		float outScale = 9.2f/inScale;
		float rotation = core.renderingHandler.rotation + (timeSinceLastTick / 2F)*(core.renderingHandler.production/5000)*4f;
		double colour = (1f + (float)(core.renderingHandler.antiMatter - core.renderingHandler.matter) / 100000f)/2;
		
		
		GL11.glPushMatrix();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 150f, 150f);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x, y, z);
		GL11.glScalef(inScale, inScale, inScale);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(iner_model_texture);
		colour = 1f - colour;
		GL11.glPushMatrix();
		GL11.glRotatef(rotation*0.5f, -0.5F, 1F, 0F);
		GL11.glColor4d(colour,1-colour ,0, 1F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
		innercore.renderAll();
		GL11.glPopMatrix();

		GL11.glScalef(outScale, outScale, outScale);
		GL11.glDepthMask(false);
		GL11.glColor4f(0.5F, 0.8F, 1F, 0.4F);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(outer_model_texture);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200F, 200F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glRotatef(-rotation, 0F, -1F, -0.5F);
		innercore.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glPopMatrix();
	}

}
