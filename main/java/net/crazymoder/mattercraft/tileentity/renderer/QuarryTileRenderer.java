package net.crazymoder.mattercraft.tileentity.renderer;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

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
	private static final ResourceLocation beaconBeamTexture = new ResourceLocation("textures/entity/beacon_beam.png");
	private IModelCustom quarryModel;
	
	int rb = 0;
	
	Random r = new Random();
	
	double lastTime = 0;
	float rotation;
	float rotation2;

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
		
	    rotation += (float) (deltaTime/10000000f);
	    rotation2 += (float) (deltaTime/10000000f);
	    if(rotation > 100000000)
	    	rotation = 0;
	    	
	    if(rotation2 > 50){
	    	rotation2 = 0;
	    	rb = rb == 0 ? 1 : 0;
	    }
	    
	    
	    
	    OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
	    FMLClientHandler.instance().getClient().getTextureManager().bindTexture(modelTexture);
		GL11.glPushMatrix();
		GL11.glColor4f(1F, 1F, 1F, 1F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(x+0.5f, y+10f, z+0.5f);
		GL11.glScalef(13f, 13f, 13f);
		GL11.glRotatef(rotation, 0f, 1f, 0f);
		quarryModel.renderAll();
		GL11.glPopMatrix();
		
		renderBeam(x+1.5f, y-0.1, z+1.5f, x, y, z, x+7, y+10f, z+7, rotation);
		renderBeam(x+1.5f, y-0.1, z-0.5f, x, y, z, x+7, y+10f, z-7, rotation);
		renderBeam(x-0.5f, y-0.1, z+1.5f, x, y, z, x-7, y+10f, z+7, rotation);
		renderBeam(x-0.5f, y-0.1, z-0.5f, x, y, z, x-7, y+10f, z-7, rotation);
		
		if(rb == 0)renderBeam(x+1.5f, y-0.1, z+1.5f, x, y, z, x-1, y+10f, z+8.5f, rotation);
		if(rb == 0)renderBeam(x+1.5f, y-0.1, z-0.5f, x, y, z, x+8.5, y+10f, z+1, rotation);
		if(rb == 0)renderBeam(x-0.5f, y-0.1, z+1.5f, x, y, z, x-8.5, y+10f, z-1f, rotation);
		if(rb == 0)renderBeam(x-0.5f, y-0.1, z-0.5f, x, y, z, x+1, y+10f, z-8.5f, rotation);
		
		if(rb == 1)renderBeam(x+1.5f, y-0.1, z+1.5f, x, y, z, x+8.5f, y+10f, z-1f, rotation);
		if(rb == 1)renderBeam(x+1.5f, y-0.1, z-0.5f, x, y, z, x-1, y+10f, z-8.5f, rotation);
		if(rb == 1)renderBeam(x-0.5f, y-0.1, z+1.5f, x, y, z, x+1, y+10f, z+8.5f, rotation);
		if(rb == 1)renderBeam(x-0.5f, y-0.1, z-0.5f, x, y, z, x-8.5, y+10f, z+1f, rotation);
		
	}
	
	private void renderBeam(double relX, double relY, double relZ, double centerX, double centerY, double centerZ, double targetX, double targetY, double targetZ, float tickStuff) {
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
}
