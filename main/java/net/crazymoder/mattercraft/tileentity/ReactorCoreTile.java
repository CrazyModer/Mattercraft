package net.crazymoder.mattercraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ReactorCoreTile extends TileEntity{
	private int updatembstick = 40;
	public ReactorCoreTile(){
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
		System.out.println(checkBlocks());
	}
	
	private boolean checkBlocks(){
		int x = xCoord;
		int y = yCoord;
		int z = zCoord;
		World w = worldObj;
		int xO = 0;//Offset
		int yO = 0;
		int zO = 0;
		
		return true;
	}
}
