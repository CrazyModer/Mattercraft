package net.crazymoder.mattercraft.tileentity.renderer;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class ReactorCoreTileRenderer extends TileEntitySpecialRenderer{

	int sphereId;
	public ReactorCoreTileRenderer(){
		
	}
	@Override
	public void renderTileEntityAt(TileEntity core, double x, double y,double z, float scale) {
		
		System.out.println("x");
		Sphere pumpkin = new Sphere();
        pumpkin.setDrawStyle(GLU.GLU_FILL);
        pumpkin.setNormals(GLU.GLU_SMOOTH);
        pumpkin.setOrientation(GLU.GLU_OUTSIDE);

       // BufferedImage bi = new BufferedImage(1, 1 /*change these to 32, 32 eventually*/, BufferedImage.TYPE_INT_ARGB_PRE);
        //bi.setRGB(0, 0, Color.red.getRGB());
        sphereId = GL11.glGenLists(1);
        GL11.glNewList(sphereId, GL11.GL_COMPILE);
        GL11.glTranslatef(1.5F, 1.5F, 1.5F);
        pumpkin.draw(0.5F, 32, 32);
        GL11.glEndList();
		
		GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glCallList(sphereId);
        GL11.glPopMatrix();
	}

}
