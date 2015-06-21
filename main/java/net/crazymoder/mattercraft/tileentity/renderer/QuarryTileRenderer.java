package net.crazymoder.mattercraft.tileentity.renderer;


import java.awt.Color;
import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.client.FMLClientHandler;
import net.crazymoder.mattercraft.helper.reactorcore.LogisticHandler;
import net.crazymoder.mattercraft.tileentity.QuarryTile;
import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
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

public class QuarryTileRenderer extends TileEntitySpecialRenderer{

	private static final ResourceLocation modelTexture = new ResourceLocation("mattercraft", "textures/models/quarryTorusSegment.png");
	private IModelCustom quarryModel;
	
	double lastTime = 0;
	float rotation;

	public QuarryTileRenderer(){
		quarryModel = AdvancedModelLoader.loadModel(new ResourceLocation("mattercraft", "models/quarry.obj"));
	}
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float timeSinceLastTick) {
		QuarryTile tile = (QuarryTile) te;
		double time = System.nanoTime();
		double deltaTime = 0;
		if(lastTime != 0)
			deltaTime = time - lastTime;
		lastTime = time;
		
		x+=0.5f;
		z+=0.5f;
		y+=10f;
		
	    rotation += (float) (deltaTime/10000000f)*2;
	    if(rotation > 100000000)
	    	rotation = 0;
	    
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
	    FMLClientHandler.instance().getClient().getTextureManager().bindTexture(modelTexture);
		GL11.glPushMatrix();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x, y, z);
		GL11.glScalef(13f, 13f, 13f);
		GL11.glRotatef(rotation, 0f, 1f, 0f);
		quarryModel.renderAll();
		GL11.glPopMatrix();

	}

}
