package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;
import java.util.List;

import net.crazymoder.mattercraft.tileentity.ElectrolizerTile;
import net.crazymoder.mattercraft.tileentity.core.LogisticHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ElectrolizerGui extends GuiScreen{
	private ElectrolizerTile electrolizerTile;
	private ResourceLocation texture;
	
	public ElectrolizerGui(ElectrolizerTile tile){
		electrolizerTile = tile;
		texture = new ResourceLocation("mattercraft", "textures/gui/Electrolizer.png");
	}
	private int xSize = 106;
	private int ySize = 91;
	public void drawScreen(int x, int y, float tick) {
		int k = (this.width - xSize) / 2;
        int l = (this.height - ySize) / 2;
        drawDefaultBackground();
        mc.renderEngine.bindTexture(texture);
        this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
        int temp;
        temp = Math.round((electrolizerTile.tankInDisplay/10000f)*65f);
        this.drawTexturedModalRect(k+15, l+80-temp, 15, 100, 20, temp);
        temp = Math.round((electrolizerTile.energyStorageDisplay/200000f)*65f);
        this.drawTexturedModalRect(k+42, l+80-temp, 42, 100, 21, temp);
        temp = Math.round((electrolizerTile.tankOutDisplay/10000f)*65f);
        this.drawTexturedModalRect(k+70, l+80-temp, 70, 100, 20, temp);
		String st = "Electrolizer";
    	this.fontRendererObj.drawString(st, k+22, l + 5, 0);
    	if(x > k+15 && y > l+15 && x < k+35 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Water:");
    		list.add(electrolizerTile.tankInDisplay/1000f+ "B/10.0B");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
    	if(x > k+42 && y > l+15 && x < k+63 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Energy:");
    		list.add(electrolizerTile.energyStorageDisplay/1000f+ "kRF/200.0kRF");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
    	if(x > k+70 && y > l+15 && x < k+90 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Hydrogen:");
    		list.add(electrolizerTile.tankOutDisplay/1000f+ "B/10.0B");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
