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
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ReactorCoreTileRenderer extends TileEntitySpecialRenderer{

	private static final ResourceLocation iner_model_texture = new ResourceLocation("mattercraft", "textures/models/power_sphere_layer_1.png");
	private static final ResourceLocation outer_model_texture = new ResourceLocation("mattercraft", "textures/models/power_sphere_layer_2.png");
 	private static final ResourceLocation enderDragonCrystalBeamTextures = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
	private static final ResourceLocation beaconBeamTexture = new ResourceLocation("textures/entity/beacon_beam.png");
	private static final ResourceLocation stabilizerBeamTexture = new ResourceLocation("mattercraft", "textures/models/stabilizerBeam.png");
	private IModelCustom innerCore;
	
	double lastTime = 0;
	float rotation;

	public ReactorCoreTileRenderer(){
		innerCore = AdvancedModelLoader.loadModel(new ResourceLocation("mattercraft", "models/core1.obj"));
	}
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float timeSinceLastTick) {
		double time = System.nanoTime();
		double deltaTime = 0;
		if(lastTime != 0)
			deltaTime = time - lastTime;
		lastTime = time;
		
		x+=0.5f;
		z+=0.5f;
		y+=12.5f;
		
		if (tile == null || !(tile instanceof ReactorCoreTile)) return;
		ReactorCoreTile core = (ReactorCoreTile) tile;
		if(!core.renderingHandler.render)return;
		float capacity = (float)(core.renderingHandler.antiMatter) / (float)(LogisticHandler.antiMatter_m*2) + (float)(core.renderingHandler.matter) / (float)(LogisticHandler.matter_m*2);
		float inScale = 7f*capacity+1.5f;
	    rotation += (float) ((deltaTime/10000000f)*((core.renderingHandler.production/7000)+1f));
	    if(rotation > 100000000)
	    	rotation = 0;
		float outScale = 9.2f/inScale;
		float beamScale = 1.0f/outScale;
		double colour = (1f + (float)(core.renderingHandler.antiMatter - core.renderingHandler.matter) / 100000f)/2;
		
		
		GL11.glPushMatrix();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x, y, z);
		GL11.glScalef(inScale, inScale, inScale);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(iner_model_texture);
		colour = 1f - colour;
		GL11.glPushMatrix();
		GL11.glRotatef(rotation/2f, 1, 1F, 1F);
		GL11.glColor4d(colour,1-colour ,0, 1F);
		innerCore.renderAll();
		GL11.glPopMatrix();

		GL11.glScalef(outScale, outScale, outScale);
		GL11.glDepthMask(true);
		GL11.glColor4f(0.5F, 0.8F, 1F, 0.5F);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(outer_model_texture);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glRotatef(-rotation/4, 0F, 1F, 0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
		innerCore.renderAll();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		renderBeam1(x, y, z, x, y, z, x, y+12, z, rotation);
		renderBeam2(x, y, z, x, y, z, x+11, y, z, rotation);
		renderBeam2(x, y, z, x, y, z, x-11, y, z, rotation);
		renderBeam2(x, y, z, x, y, z, x, y, z+11.5, rotation);
		renderBeam2(x, y, z, x, y, z, x, y, z-11.5, rotation);
		
		renderBeam3(x, y, z, x, y, z, x-1f, y-11f, z-1f, rotation);
		renderBeam3(x, y, z, x, y, z, x+1f, y-11f, z-1f, rotation);
		renderBeam3(x, y, z, x, y, z, x-1f, y-11f, z+1f, rotation);
		renderBeam3(x, y, z, x, y, z, x+1f, y-11f, z+1f, rotation);
		renderBeam3(x, y, z, x, y, z, x-1f, y+12f, z-1f, rotation);
		renderBeam3(x, y, z, x, y, z, x+1f, y+12f, z-1f, rotation);
		renderBeam3(x, y, z, x, y, z, x-1f, y+12f, z+1f, rotation);
		renderBeam3(x, y, z, x, y, z, x+1f, y+12f, z+1f, rotation);
	}
	
	
	private void renderBeam1(double relX, double relY, double relZ, double centerX, double centerY, double centerZ, double targetX, double targetY, double targetZ, float tickStuff) {
		float f2 = 50000;
		float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
		f3 = (f3 * f3 + f3) * 0.2F;
		float wayX = (float) (targetX - centerX);
		float wayY = (float) (targetY - centerY);
		float wayZ = (float) (targetZ - centerZ);
		float distFlat = MathHelper.sqrt_float(wayX * wayX + wayZ * wayZ);
		float dist = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) relX, (float) relY, (float) relZ);
		GL11.glRotatef((float) (-Math.atan2(wayZ, wayX)) * 180.0F / (float) Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef((float) (-Math.atan2(distFlat, wayY)) * 180.0F / (float) Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(1.5f, 1.5f, 1f);
		Tessellator tessellator = Tessellator.instance;
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.bindTexture(beaconBeamTexture);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		float f9 = -(tickStuff * 0.005F);
		float f10 = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ) / 32.0F + f9;
		tessellator.startDrawing(5);
		//Add all 2*8 vertex/corners
		byte b0 = 8;
		for (int i = 0; i <= b0; ++i) {
			float f11 = 0.2F * (MathHelper.sin(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F);
			float f12 = 0.2F * (MathHelper.cos(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F);
			float f13 = i % b0 * 1.0F / b0;
			tessellator.setColorOpaque(0, 255, 150);
			tessellator.addVertexWithUV((f11), (f12), 0.0D, f13, f10);
			tessellator.setColorOpaque_I(16777215);
			tessellator.addVertexWithUV(f11, f12, dist, f13, f9);
		}

		tessellator.draw();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_FLAT);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}
	private void renderBeam2(double relX, double relY, double relZ, double centerX, double centerY, double centerZ, double targetX, double targetY, double targetZ, float tickStuff) {
		float f2 = 50000;
		float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
		f3 = (f3 * f3 + f3) * 0.2F;
		float wayX = (float) (targetX - centerX);
		float wayY = (float) (targetY - centerY);
		float wayZ = (float) (targetZ - centerZ);
		float distFlat = MathHelper.sqrt_float(wayX * wayX + wayZ * wayZ);
		float dist = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) relX, (float) relY, (float) relZ);
		GL11.glRotatef((float) (-Math.atan2(wayZ, wayX)) * 180.0F / (float) Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef((float) (-Math.atan2(distFlat, wayY)) * 180.0F / (float) Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
		Tessellator tessellator = Tessellator.instance;
		RenderHelper.disableStandardItemLighting();
		GL11.glScalef(1.7f, 1.7f, 1f);
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.bindTexture(enderDragonCrystalBeamTextures);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		float f9 = -(tickStuff * 0.005F);
		float f10 = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ) / 32.0F + f9;
		tessellator.startDrawing(5);
		byte b0 = 8;
		for (int i = 0; i <= b0; ++i) {
			float f11 = 0.2F * (MathHelper.sin(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F);
			float f12 = 0.2F * (MathHelper.cos(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F);
			float f13 = i % b0 * 1.0F / b0;
			tessellator.setColorOpaque(255, 100, 50);
			tessellator.addVertexWithUV((f11), (f12), 0.0D, f13, f10);
			tessellator.setColorOpaque(50, 100, 255);
			tessellator.addVertexWithUV(f11, f12, dist, f13, f9);
		}

		tessellator.draw();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_FLAT);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}
	private void renderBeam3(double relX, double relY, double relZ, double centerX, double centerY, double centerZ, double targetX, double targetY, double targetZ, float tickStuff) {
		float f2 = 50000;
		float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
		f3 = (f3 * f3 + f3) * 0.2F;
		float wayX = (float) (targetX - centerX);
		float wayY = (float) (targetY - centerY);
		float wayZ = (float) (targetZ - centerZ);
		float distFlat = MathHelper.sqrt_float(wayX * wayX + wayZ * wayZ);
		float dist = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) relX, (float) relY, (float) relZ);
		GL11.glRotatef((float) (-Math.atan2(wayZ, wayX)) * 180.0F / (float) Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef((float) (-Math.atan2(distFlat, wayY)) * 180.0F / (float) Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(1.2f, 1.2f, 1f);
		Tessellator tessellator = Tessellator.instance;
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.bindTexture(stabilizerBeamTexture);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		float f9 = -(tickStuff * 0.005F);
		float f10 = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ) / 32.0F + f9;
		tessellator.startDrawing(5);
		byte b0 = 8;
		for (int i = 0; i <= b0; ++i) {
			float f11 = 0.2F * (MathHelper.sin(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F);
			float f12 = 0.2F * (MathHelper.cos(i % b0 * (float) Math.PI * 2.0F / b0) * 0.75F);
			float f13 = i % b0 * 1.0F / b0;
			tessellator.setColorOpaque(50, 120, 50);
			tessellator.addVertexWithUV((f11), (f12), 0.0D, f13, f10);
			tessellator.setColorOpaque(255, 0, 0);
			tessellator.addVertexWithUV(f11, f12, dist, f13, f9);
		}

		tessellator.draw();
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_FLAT);
		RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}

}
