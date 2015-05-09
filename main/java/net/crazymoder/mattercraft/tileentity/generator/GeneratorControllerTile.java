package net.crazymoder.mattercraft.tileentity.generator;

import net.minecraft.tileentity.TileEntity;

public class GeneratorControllerTile extends TileEntity{
	private boolean init = true;
	private int x,y,z;
	private int direction;
	private GeneratorEnergyPortTile energyPortTile;
	private GeneratorFluidPortTile fluidPortTile1;
	private GeneratorFluidPortTile fluidPortTile2;
	public GeneratorControllerTile(){
		
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			if(init){
				init = false;
				direction = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			}
			if(checkMbs()){
				
			}
		}
	}
	
	
	private boolean checkMbs(){
		boolean OK = true;
		System.out.println(xCoord+" "+yCoord+" "+zCoord+" "+direction);
		
		return OK;
	}
	
}