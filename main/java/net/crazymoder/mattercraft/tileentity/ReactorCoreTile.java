package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ReactorCoreTile extends TileEntity{
	
	private int updatembstick = 40;
	private boolean mbsOK;
	
	private int x = xCoord;
	private int y = yCoord;
	private int z = zCoord;
	private World w = worldObj;
	private int xO = 0;//Offset
	private int yO = 0;
	private int zO = 0;
	
	public ArrayList<Object> guiinfo;
	
	public ReactorCoreTile(){
		mbsOK = false;
		guiinfo = new ArrayList<Object>();
		guiinfo.add("Hallo");
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			updatembstick--;
			if(updatembstick == 0){
				updatembstick = 40;
				updatembs();
			}
		}
		super.updateEntity();
	}
	
	
	private void updatembs(){
		mbsOK = checkmbs();
		addInterfaces();
	}
	
	private boolean checkmbs(){
		resetCords();
		return true;
	}
	
	
	private ReactorTerminalTile reactorTerminalTile;
	
	private void addInterfaces(){
		resetCords();
		yO++;
		if(isBlock("tile.mtc.reactorTerminal")){
			ReactorTerminalTile te = (ReactorTerminalTile) getTile();
			te.setCore(this);
		}
	}
	
	private TileEntity getTile(){
		return w.getTileEntity(x + xO, y + yO, z + zO);
	}
	//tile.mtc.
	private boolean isBlock(String name){
		Block block = w.getBlock(x + xO, y + yO, z + zO);
		return(block.getUnlocalizedName().equals(name));
	}
	
	private void resetCords(){
		x = xCoord;
		y = yCoord;
		z = zCoord;
		w = worldObj;
		xO = 0;//Offset
		yO = 0;
		zO = 0;
	}
	
}
