package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;
import java.util.List;

import net.crazymoder.mattercraft.helper.manual.LinkButton;
import net.crazymoder.mattercraft.helper.manual.ManualPages;
import net.crazymoder.mattercraft.helper.manual.ManualResources;
import net.crazymoder.mattercraft.helper.reactorcore.GuiHandler;
import net.crazymoder.mattercraft.helper.reactorcore.LogisticHandler;
import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ManualGui extends GuiScreen{

	boolean reinit = false;
	
	int xSize = 256;
	int ySize = 256;
	
	int page = 0;
	int maxPage = 0;
	
	ResourceLocation background;
	
	ManualPages pages;
	
	public ManualGui() {
		pages = new ManualPages();
		maxPage = pages.maxPage;
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        
		this.buttonList.add(new GuiButton(100, k+213, l+230, 12, 12, "<"));
		this.buttonList.add(new GuiButton(101, k+225, l+230, 12, 12, "H"));
		this.buttonList.add(new GuiButton(102, k+237, l+230, 12, 12, ">"));
		
		background = pages.getRl(page);
		pages.init(k, l, this.buttonList, page);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case 100:
			if(page > 0)page--;
			break;
		case 101:
			page = 0;
			break;
		case 102:
			if(page < maxPage)page++;
			break;
		default:
			page = button.id;
			break;
		}
		reinit = true;
	}
	
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void drawScreen(int x, int y, float tick) {
		if(reinit){
			reinit = false;
			initGui();
		}
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        drawDefaultBackground(); 
        mc.renderEngine.bindTexture(background);
        drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        this.fontRendererObj.drawString("Page: " + page + "/" + maxPage, k+152, l+233, 0);
        pages.drawScreen(x, y, k, l, tick, this.fontRendererObj, page);
        super.drawScreen(x, y, tick);
	}
	
	@Override
	protected void keyTyped(char par1, int par2)
	{
		if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()){
			this.mc.thePlayer.closeScreen();
		}
	}
}
