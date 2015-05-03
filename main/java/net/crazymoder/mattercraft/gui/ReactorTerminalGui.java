package net.crazymoder.mattercraft.gui;

import java.util.ArrayList;
import java.util.List;

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
	private int matter;
	private int antiMatter;
	private int energy;
	private int power;
	private int topower;
	private float efficiency;
	private int production;
	private int matterRate;
	private int antiRate;
	
	private GuiHandler guiH;
	private ReactorCoreTile core;
	
	int xSize = 256;
	int ySize = 165;
	
	private String statusString;
	
	private ResourceLocation texture1,texture2;
	
	
	public ReactorTerminalGui(ReactorTerminalTile tile) {
		this.tile = tile;
		texture1 = new ResourceLocation("mattercraft", "textures/gui/Terminal1.png");
		texture2 = new ResourceLocation("mattercraft", "textures/gui/Terminal2.png");
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
			matter = guiH.matter;
			antiMatter = guiH.antiMatter;
			energy = guiH.energy;
			power = guiH.power;
			topower = guiH.topower;
			efficiency = guiH.efficiency;
			production = guiH.production;
			matterRate = guiH.matterRate;
			antiRate = guiH.antiMatter;
		}
		
		if(status == 0)statusString = "Reactor Terminal: Not Connected";
		if(status == 1)statusString = "Reactor Terminal: Multiblockstructure Error";
		if(status == 2)statusString = "Reactor Terminal: No Logistics";
		if(status == 3)statusString = "Reactor Terminal: Ready to Activate";
		if(status == 4)statusString = "Reactor Terminal: Core Running";
		
		int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        drawDefaultBackground();
		mc.renderEngine.bindTexture(texture1);
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        mc.renderEngine.bindTexture(texture2);
        //fluids
        int temp;
        //liquidmatter
        temp = (int) (((float)(liquidMatter)/LogisticHandler.liquidMatter_m)*100f*0.71f);
        this.drawTexturedModalRect(k+7, l+158-temp, 7, 173, 29, temp);
        //cryotheum
        temp = (int) (((float)(cryotheum)/LogisticHandler.cryotheum_m)*100f*0.71f);
        this.drawTexturedModalRect(k+37, l+158-temp, 37, 173, 29, temp);
        //stabilizer
        temp = (int) (((float)(stabilizer)/LogisticHandler.stabilizer_m)*100f*0.71f);
        this.drawTexturedModalRect(k+67, l+158-temp, 67, 173, 29, temp);
        //hydrogen
        temp = (int) (((float)(hydrogen)/LogisticHandler.hydrogen_m)*100f*0.71f);
        this.drawTexturedModalRect(k+97, l+158-temp, 97, 173, 29, temp);
        //energy
        temp = (int) (((float)(energy)/LogisticHandler.energy_m)*100f*0.71f);
        this.drawTexturedModalRect(k+127, l+158-temp, 127, 173, 30, temp);
        //plasma
        temp = (int) (((float)(plasma)/LogisticHandler.plasma_m)*100f*0.71f);
        this.drawTexturedModalRect(k+158, l+158-temp, 158, 173, 29, temp);
        //toxicwaste
        temp = (int) (((float)(toxicWaste)/LogisticHandler.toxicWaste_m)*100f*0.71f);
        this.drawTexturedModalRect(k+188, l+158-temp, 188, 173, 29, temp);
        //heatedcryotheum
        temp = (int) (((float)(heatedCryotheum)/LogisticHandler.heatedCryotheum_m)*100f*0.71f);
        this.drawTexturedModalRect(k+218, l+158-temp, 218, 173, 29, temp);
        
        //power
    	temp = (int) (((float)(power)/1100000)*100f*1.18f);
    	this.drawTexturedModalRect(8+k, 70+l, 0, 0, temp, 12);
    	
    	//topower
    	temp = (int) (((float)(topower)/1100000)*100f*1.18f);
    	this.drawTexturedModalRect(8+k+temp, 68+l, 118, 0, 2, 16);
    	
        //tooltips
        if(x > 7 + k && x < k + 247 && y > 87 + l && y < l + 158){
        	List list = new ArrayList();
        	if(x > k+218){
        		list.add("Heated Cryotheum:");
        		list.add(heatedCryotheum/1000f+ "B/"+ LogisticHandler.heatedCryotheum_m/1000f+"B");
        	}else if(x > k+188){
        		list.add("Toxic Waste:");
        		list.add(toxicWaste/1000f+ "B/"+ LogisticHandler.toxicWaste_m/1000f+"B");
        	}else if(x > k+158){
        		list.add("Plasma:");
        		list.add(plasma/1000000f+ "KB/"+ LogisticHandler.plasma_m/1000000f+"KB");
        	}else if(x > k+125){
        		list.add("RF:");
        		list.add(energy/1000000f+ "MRF/"+ LogisticHandler.energy_m/1000000f+"MRF");
        	}else if(x > k+97){
        		list.add("Hydrogen:");
        		list.add(hydrogen/1000f+ "B/"+ LogisticHandler.hydrogen_m/1000f+"B");
        	}else if(x > k+67){
        		list.add("Stabilizer:");
        		list.add(stabilizer/1000f+ "B/"+ LogisticHandler.stabilizer_m/1000f+"B");
        	}else if(x > k+37){
        		list.add("Cryotheum:");
        		list.add(cryotheum/1000f+ "B/"+ LogisticHandler.cryotheum_m/1000f+"B");
        	}else {
        		list.add("Liquid Matter:");
        		list.add(liquidMatter/1000f+ "B/"+ LogisticHandler.liquidMatter_m/1000f+"B");
        	}
        	this.drawHoveringText(list, (int)x, (int)y, this.fontRendererObj);
        }
        //status
    	this.fontRendererObj.drawString(statusString, (k + this.xSize / 2) - this.fontRendererObj.getStringWidth(statusString)/2, l - 75 + this.ySize/2, 0);
    	//power
    	String st = topower/1000f + "kW > " + power/1000f + "kW";
    	this.fontRendererObj.drawString(st, k+12, l + 60, 0);
	}
}
