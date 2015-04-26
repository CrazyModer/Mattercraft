package net.crazymoder.mattercraft.gui;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ReactorTerminalGui extends GuiScreen{

	private ReactorTerminalTile te;
	private final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	
	public ReactorTerminalGui(ReactorTerminalTile tile) {
		te = tile;
	}
	
	@Override
	public void drawScreen(int x, int y, float tick) {
		mc.renderEngine.bindTexture(new ResourceLocation("mattercraft", "textures/gui/Terminal.png"));
		drawDefaultBackground();
		drawTexturedModalRect(100, 100, 0, 0, 200, 300);
	}
}
