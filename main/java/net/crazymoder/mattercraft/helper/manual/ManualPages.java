package net.crazymoder.mattercraft.helper.manual;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ManualPages {
	public int maxPage = 10;

	public ManualPages(){}
	
	
	public void init(int k,int l,List<GuiButton> buttons,int page){
		switch (page) {
		case 0:
			buttons.add(new LinkButton(1, k+35, l+100,"To 1"));
			buttons.add(new LinkButton(2, k+35, l+115,"Terminal"));
			break;
			
		case 1:
			//buttons.add(new LinkButton(0, k+35, l+100,"To 0"));
			break;
			
		case 2:
			//buttons.add(new LinkButton(0, k+35, l+100,"To 0"));
			break;
		}
	}
	
	public ResourceLocation getRl(int page){
		switch (page) {
			case 0:	return ManualResources.defaultRes;
			case 1:	return ManualResources.defaultRes;
			case 2: return ManualResources.screenShot1;
		}
		return ManualResources.defaultRes;
	}
	//space between lines 15 margin 30 §l 
	public void drawScreen(int x, int y,int k,int l, float tick,FontRenderer fontRenderer,int page){
		switch (page) {
		case 0:
			fontRenderer.drawString("§lMattermanual", k+030, l+25, 0);
			
			fontRenderer.drawString("Page 0", k+030, l+50, 0);
			break;
			
		case 1:
			
			break;
			
		case 2:
			fontRenderer.drawString("§lTerminal", k+030, l+25, 0);
			fontRenderer.drawString("To controll the Reactor you need a Terminal,", k+025, l+150, 0);
			fontRenderer.drawString("witch is placed on one of the four", k+025, l+162, 0);
			fontRenderer.drawString("stabilizerpillars facing in the middle.", k+025, l+174, 0);
			fontRenderer.drawString("The gui shows all the information you need.", k+025, l+186, 0);
			break;
			
		default:
			fontRenderer.drawString("ERROR", k+030, l+50, 0);
			break;
		}
	}
	
}
