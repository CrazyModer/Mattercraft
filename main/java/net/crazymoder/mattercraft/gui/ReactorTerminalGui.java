package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.crazymoder.mattercraft.tileentity.core.ReactorCoreTile;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ReactorTerminalGui extends GuiScreen{

	ReactorTerminalTile tile;
	
	private final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	
	public ReactorTerminalGui(ReactorTerminalTile tile) {
		this.tile = tile;
	}
	
	int xSize = 256;
	int ySize = 165;
	
	private String status;
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void drawScreen(int x, int y, float tick) {
		if(tile.status == 0)status = "Not Con";
		if(tile.status == 1)status = "MBS NOT OK";
		if(tile.status == 2)status = "MBS OK";
	

		mc.renderEngine.bindTexture(new ResourceLocation("mattercraft", "textures/gui/Terminal.png"));
		drawDefaultBackground();
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        int temp = 0;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        //liquidmatter
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+7, l+158-temp, 7, 173, 29, temp);
        //cryotheum
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+37, l+158-temp, 37, 173, 29, temp);
        //stabilizer
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+67, l+158-temp, 67, 173, 29, temp);
        //hydrogen
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+97, l+158-temp, 97, 173, 29, temp);
        
        //plasma
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+158, l+158-temp, 158, 173, 29, temp);
        //toxicwaste
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+188, l+158-temp, 188, 173, 29, temp);
        //heatedcryotheum
        temp = (int) (tile.cryotheum*0.71f);
        this.drawTexturedModalRect(k+218, l+158-temp, 218, 173, 29, temp);
        
        //status
    	this.fontRendererObj.drawString(status, (k + this.xSize / 2) - this.fontRendererObj.getStringWidth(status), l - 50 + this.ySize/2, 4210752);
	}
}
