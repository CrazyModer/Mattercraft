package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;
import java.util.List;

import net.crazymoder.mattercraft.tileentity.CoolerTile;
import net.crazymoder.mattercraft.tileentity.core.LogisticHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class CoolerGui extends GuiScreen{
	private CoolerTile coolerTile;
	private ResourceLocation texture;
	
	public CoolerGui(CoolerTile tile){
		coolerTile = tile;
		texture = new ResourceLocation("mattercraft", "textures/gui/Cooler.png");
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
        temp = Math.round((coolerTile.tankInDisplay/10000f)*65f);
        this.drawTexturedModalRect(k+15, l+80-temp, 15, 100, 20, temp);
        temp = Math.round((coolerTile.energyStorageDisplay/200000f)*65f);
        this.drawTexturedModalRect(k+42, l+80-temp, 42, 100, 21, temp);
        temp = Math.round((coolerTile.tankOutDisplay/10000f)*65f);
        this.drawTexturedModalRect(k+70, l+80-temp, 70, 100, 20, temp);
		String st = "Cooler";
    	this.fontRendererObj.drawString(st, k+35, l + 5, 0);
    	if(x > k+15 && y > l+15 && x < k+35 && y < l + 80){
    		List list = new ArrayList();
    		list.add("HeatedCryotheum:");
    		list.add(coolerTile.tankInDisplay/1000f+ "B/10.0B");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
    	if(x > k+42 && y > l+15 && x < k+63 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Energy:");
    		list.add(coolerTile.energyStorageDisplay/1000f+ "kRF/200.0kRF");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
    	if(x > k+70 && y > l+15 && x < k+90 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Cryotheum:");
    		list.add(coolerTile.tankOutDisplay/1000f+ "B/10.0B");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
