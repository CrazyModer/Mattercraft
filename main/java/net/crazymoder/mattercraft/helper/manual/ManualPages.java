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
	public int maxPage = 15;

	public ManualPages(){}
	
	
	public void init(int k,int l,List<GuiButton> buttons,int page){
		switch (page) {
		case 0:
			buttons.add(new LinkButton(1, k+15, l+30,"1"));
			buttons.add(new LinkButton(2, k+15, l+40,"2"));
			buttons.add(new LinkButton(3, k+15, l+50,"3"));
			buttons.add(new LinkButton(4, k+15, l+60,"4"));
			buttons.add(new LinkButton(5, k+15, l+70,"5"));
			buttons.add(new LinkButton(6, k+15, l+80,"6"));
			buttons.add(new LinkButton(7, k+15, l+90,"7"));
			buttons.add(new LinkButton(8, k+15, l+100,"8"));
			buttons.add(new LinkButton(9, k+15, l+110,"9"));
			buttons.add(new LinkButton(10, k+15, l+120,"10"));
			buttons.add(new LinkButton(11, k+15, l+130,"11"));
			buttons.add(new LinkButton(12, k+15, l+140,"12"));
			buttons.add(new LinkButton(13, k+15, l+150,"13"));
			buttons.add(new LinkButton(14, k+15, l+160,"14"));
			buttons.add(new LinkButton(15, k+15, l+170,"15"));
			break;
		}
	}
	
	public ResourceLocation getRl(int page){
		if(page > 0 && page < 16){
			return ManualResources.screens.get(page-1);
		}
		return ManualResources.defaultRes;
	}
	//space between lines 15 margin 30 §l 
	public void drawScreen(int x, int y,int k,int l, float tick,FontRenderer fontRenderer,int page){
		switch (page) {
		case 0:
			fontRenderer.drawString("§lMattermanual", k+15, l+15, 0);
			break;
		}
	}
	
}
