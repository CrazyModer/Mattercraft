package net.crazymoder.mattercraft.tileentity.renderer;


import java.awt.Color;
import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.client.FMLClientHandler;
import net.crazymoder.mattercraft.helper.reactorcore.LogisticHandler;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.tileentity.MemoryCardReaderTile;
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

public class MemoryCardReaderTileRenderer extends TileEntitySpecialRenderer{

 	private static final ResourceLocation enderDragonCrystalBeamTextures = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
 	private static final ResourceLocation cardTexture = new ResourceLocation("mattercraft", "textures/items/chunkMemoryCard.png");
	
	double lastTime = 0;
	float rotation;

	public MemoryCardReaderTileRenderer(){
	}
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float timeSinceLastTick) {
		MemoryCardReaderTile tile = (MemoryCardReaderTile) te;
		if(!tile.renderItem)return;
		double time = System.nanoTime();
		double deltaTime = 0;
		if(lastTime != 0)
			deltaTime = time - lastTime;
		lastTime = time;
		
		rotation += (float) (deltaTime/10000000f);
	    if(rotation > 100000000)
	    	rotation = 0;
		
		if (tile == null || !(tile instanceof MemoryCardReaderTile)) return;
		MemoryCardReaderTile core = (MemoryCardReaderTile) tile;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 200f, 200f);
		if(tile.renderBeam)renderBeam1(x+0.5f, y+12f, z+0.5f, x, y, z, x, y-11f, z, rotation);
		renderCard(x, y, z);
	}
	
	private void renderCard(double x, double y, double z){
		GL11.glPushMatrix();
		GL11.glTranslated(x+0.2F, y+0.75f, z+0.5f);
		GL11.glScaled(0.6f, 0.6f, 0.6f);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		RenderHelper.disableStandardItemLighting();
		this.bindTexture(cardTexture);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(255, 255, 255);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0, 0, 0, 1, 1);
        tessellator.addVertexWithUV(1, 0, 0, 0, 1);
        tessellator.addVertexWithUV(1, 1, 0, 0, 0);
        tessellator.addVertexWithUV(0, 1, 0, 1, 0);
        tessellator.draw();
        GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glPopMatrix();
	}
	
	private void renderBeam1(double x, double y, double z, double centerX, double centerY, double centerZ, double targetX, double targetY, double targetZ, float tickStuff) {
		float f2 = 50000;
		float f3 = MathHelper.sin(f2 * 0.2F) / 2.0F + 0.5F;
		f3 = (f3 * f3 + f3) * 0.2F;
		float wayX = (float) (targetX - centerX);
		float wayY = (float) (targetY - centerY);
		float wayZ = (float) (targetZ - centerZ);
		float distFlat = MathHelper.sqrt_float(wayX * wayX + wayZ * wayZ);
		float dist = MathHelper.sqrt_float(wayX * wayX + wayY * wayY + wayZ * wayZ);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
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
			tessellator.setColorOpaque(150, 000, 000);
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
}
