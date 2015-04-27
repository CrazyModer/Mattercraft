package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;

import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ReactorTerminalGui extends GuiScreen{

	ArrayList<Object> guiinfo;
	ReactorTerminalTile tile;
	
	private final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	
	public ReactorTerminalGui(ReactorTerminalTile tile) {
		this.tile = tile;
	}
	
	int xSize = 256;
	int ySize = 165;
	
	private String string;
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void drawScreen(int x, int y, float tick) {
		guiinfo = tile.guiinfo;
		if(guiinfo.isEmpty()){
			string = "Not connected";
		}else{
			string = (String) guiinfo.get(0);
		}
		mc.renderEngine.bindTexture(new ResourceLocation("mattercraft", "textures/gui/Terminal.png"));
		drawDefaultBackground();
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    	this.fontRendererObj.drawString(string, (k + this.xSize / 2) - this.fontRendererObj.getStringWidth(string), l + this.ySize/2, 4210752);
	}
}
