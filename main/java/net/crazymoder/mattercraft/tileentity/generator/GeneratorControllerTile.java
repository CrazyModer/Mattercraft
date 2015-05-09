package net.crazymoder.mattercraft.tileentity.generator;

import net.minecraft.tileentity.TileEntity;

public class GeneratorControllerTile extends TileEntity{
	public boolean isMbsOK;
	private int count = 0;
	private int x,y,z;
	public GeneratorControllerTile(){
		
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			count++;
			if(count >= 100){
				count = 0;
				checkMbs();
			}
		}
	}
	
	
	private void checkMbs(){
		
	}
	
}