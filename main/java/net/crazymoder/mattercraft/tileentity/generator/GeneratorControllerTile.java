package net.crazymoder.mattercraft.tileentity.generator;

import net.minecraft.tileentity.TileEntity;

public class GeneratorControllerTile extends TileEntity{
	public boolean isMbsOK;
	private boolean init = true;
	private int count = 0;
	private int x,y,z;
	private int direction;
	public GeneratorControllerTile(){
		
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			if(init){
				init = false;
				direction = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			}
			count++;
			if(count >= 100){
				count = 0;
				checkMbs();
			}
		}
	}
	
	
	private void checkMbs(){
		System.out.println(xCoord+" "+yCoord+" "+zCoord+" "+direction);
	}
	
}