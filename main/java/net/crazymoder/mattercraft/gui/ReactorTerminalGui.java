package net.crazymoder.mattercraft.gui;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.client.gui.GuiScreen;

public class ReactorTerminalGui extends GuiScreen{

	private ReactorTerminalTile te;
	
	public ReactorTerminalGui(ReactorTerminalTile tile) {
		te = tile;
	}
	
	@Override
	public void drawScreen(int x, int y, float tick) {
		super.drawScreen(x, y, tick);
		drawDefaultBackground();
	}
}
