package net.crazymoder.mattercraft.gui;

import org.lwjgl.opengl.GL11;

import net.crazymoder.mattercraft.Container.QuarryContainer;
import net.crazymoder.mattercraft.tileentity.QuarryTile;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class QuarryGui extends GuiContainer{

	private QuarryTile tile;
	private ResourceLocation texture;
	
	public QuarryGui(InventoryPlayer playerInv,QuarryTile te) {
		super(new QuarryContainer(playerInv,te));
		tile = te;
		texture = new ResourceLocation("mattercraft", "textures/gui/Quarry.png");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(texture);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

}
