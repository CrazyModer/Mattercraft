package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.crazymoder.mattercraft.tileentity.core.GuiHandler;
import net.crazymoder.mattercraft.tileentity.core.LogisticHandler;
import net.crazymoder.mattercraft.tileentity.core.ReactorCoreTile;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

public class ReactorTerminalGui extends GuiScreen{

	ReactorTerminalTile tile;
	
	private int status;
	private int cryotheum;
	private int liquidMatter;
	private int stabilizer;
	private int hydrogen;
	private int plasma;
	private int toxicWaste;
	private int heatedCryotheum;
	private int energy;
	
	private GuiHandler guiH;
	private ReactorCoreTile core;
	
	int xSize = 256;
	int ySize = 165;
	
	private String statusString;
	
	private final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
	
	public ReactorTerminalGui(ReactorTerminalTile tile) {
		this.tile = tile;
	}
	
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public void getCore(){
		int direction = tile.getWorldObj().getBlockMetadata(tile.xCoord, tile.yCoord, tile.zCoord);
		if(direction == 4)
		if(tile.getWorldObj().getTileEntity(12+tile.xCoord, tile.yCoord, tile.zCoord) instanceof ReactorCoreTile){
			core = (ReactorCoreTile) tile.getWorldObj().getTileEntity(12+tile.xCoord, tile.yCoord, tile.zCoord);
		}
		if(direction == 5)
		if(tile.getWorldObj().getTileEntity(-12 + tile.xCoord, tile.yCoord, tile.zCoord) instanceof ReactorCoreTile){
			core = (ReactorCoreTile) tile.getWorldObj().getTileEntity(-12+tile.xCoord, tile.yCoord, tile.zCoord);
		}
		if(direction == 2)
		if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord,12 + tile.zCoord) instanceof ReactorCoreTile){
			core = (ReactorCoreTile) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord,12+ tile.zCoord);
		}
		if(direction == 3)
		if(tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord,-12 +  tile.zCoord) instanceof ReactorCoreTile){
			core = (ReactorCoreTile) tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord,-12 +  tile.zCoord);
		}
	}
	
	@Override
	public void drawScreen(int x, int y, float tick) {
		getCore();
		status = 0;
		if(core != null && !core.isInvalid())status = 1;
		if(status == 1){
			guiH = core.guiHandler;
			status = guiH.status;
			cryotheum = guiH.cryotheum;
			liquidMatter = guiH.liquidMatter;
			stabilizer = guiH.stabilizer;
			hydrogen = guiH.hydrogen;
			plasma = guiH.plasma;
			toxicWaste = guiH.toxicWaste;
			heatedCryotheum = guiH.heatedCryotheum;
			energy = guiH.energy;
		}
		
		if(status == 0)statusString = "Not Con";
		if(status == 1)statusString = "MBS NOT OK";
		if(status == 2)statusString = "MBS OK";
		if(status == 3)statusString = "Logistics OK";
		if(status == 4)statusString = "Running";

		mc.renderEngine.bindTexture(new ResourceLocation("mattercraft", "textures/gui/Terminal.png"));
		drawDefaultBackground();
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        int temp = 0;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        //liquidmatter
        temp = (int) (liquidMatter*0.71f);
        this.drawTexturedModalRect(k+7, l+158-temp, 7, 173, 29, temp);
        //cryotheum
        temp = (int) (cryotheum*0.71f);
        this.drawTexturedModalRect(k+37, l+158-temp, 37, 173, 29, temp);
        //stabilizer
        temp = (int) (stabilizer*0.71f);
        this.drawTexturedModalRect(k+67, l+158-temp, 67, 173, 29, temp);
        //hydrogen
        temp = (int) (hydrogen*0.71f);
        this.drawTexturedModalRect(k+97, l+158-temp, 97, 173, 29, temp);
        
        //plasma
        temp = (int) (plasma*0.71f);
        this.drawTexturedModalRect(k+158, l+158-temp, 158, 173, 29, temp);
        //toxicwaste
        temp = (int) (toxicWaste*0.71f);
        this.drawTexturedModalRect(k+188, l+158-temp, 188, 173, 29, temp);
        //heatedcryotheum
        temp = (int) (heatedCryotheum*0.71f);
        this.drawTexturedModalRect(k+218, l+158-temp, 218, 173, 29, temp);
        
        //status
    	this.fontRendererObj.drawString(statusString, (k + this.xSize / 2) - this.fontRendererObj.getStringWidth(statusString), l - 50 + this.ySize/2, 4210752);
	}
}
