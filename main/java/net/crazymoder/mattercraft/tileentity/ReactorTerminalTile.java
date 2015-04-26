package net.crazymoder.mattercraft.tileentity;

import net.minecraft.tileentity.TileEntity;

public class ReactorTerminalTile extends TileEntity{
	
	public ReactorCoreTile core;
	
	public ReactorTerminalTile(){
		core = null;
	}
	
	public void setCore(ReactorCoreTile rcore){
		core = rcore;
	}
}
