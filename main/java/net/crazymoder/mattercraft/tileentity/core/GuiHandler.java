package net.crazymoder.mattercraft.tileentity.core;

public class GuiHandler {
	
	public int status;
	public int cryotheum;
	
	public GuiHandler(){
		status = 0;
		cryotheum = 0;
	}
	
	public void update(){
		cryotheum ++;
		if (cryotheum > 100)cryotheum = 0;
	}
	
}
