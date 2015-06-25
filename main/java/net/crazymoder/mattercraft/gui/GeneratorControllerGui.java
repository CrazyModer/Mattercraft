package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;
import java.util.List;

import net.crazymoder.mattercraft.helper.reactorcore.LogisticHandler;
import net.crazymoder.mattercraft.tileentity.CoolerTile;
import net.crazymoder.mattercraft.tileentity.GeneratorControllerTile;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GeneratorControllerGui extends GuiScreen{
	private GeneratorControllerTile coolerTile;
	private ResourceLocation texture;
	
	public GeneratorControllerGui(GeneratorControllerTile tile){
		coolerTile = tile;
		texture = new ResourceLocation("mattercraft", "textures/gui/Generator.png");
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
        temp = Math.round((coolerTile.tank1Display/250000f)*65f);
        this.drawTexturedModalRect(k+15, l+80-temp, 15, 100, 20, temp);
        temp = Math.round((coolerTile.tank2Display/250000f)*65f);
        this.drawTexturedModalRect(k+42, l+80-temp, 42, 100, 21, temp);
        temp = Math.round((coolerTile.energyStorageDisplay/2000000000f)*65f);
        this.drawTexturedModalRect(k+70, l+80-temp, 70, 100, 20, temp);
		String st = "Generator";
    	this.fontRendererObj.drawString(st, k+30, l + 5, 0);
    	st = "Out: "+ coolerTile.productionRate+"kRF/t";
    	this.fontRendererObj.drawString(st, k+25, l + 80, 0);
    	if(x > k+15 && y > l+15 && x < k+35 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Water:");
    		list.add(coolerTile.tank1Display/1000f+ "B/250.0B");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
    	if(x > k+42 && y > l+15 && x < k+63 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Plasma:");
    		list.add(coolerTile.tank2Display/1000f+ "B/250.0B");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
    	if(x > k+70 && y > l+15 && x < k+90 && y < l + 80){
    		List list = new ArrayList();
    		list.add("Energy:");
    		list.add(coolerTile.energyStorageDisplay/1000000f+ "MRF/2000MRF");
    		this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
    	}
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
