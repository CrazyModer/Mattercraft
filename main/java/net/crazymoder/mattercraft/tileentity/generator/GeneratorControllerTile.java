package net.crazymoder.mattercraft.tileentity.generator;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class GeneratorControllerTile extends TileEntity{
	private boolean init = true;
	private int a,b,y,x,z;
	private int direction;
	private GeneratorEnergyPortTile energyPortTile;
	private GeneratorFluidPortTile fluidPortTile1;
	private GeneratorFluidPortTile fluidPortTile2;
	public GeneratorControllerTile(){
		a=0;b=0;y=0;x=0;z=0;
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
		System.out.println(xCoord+" "+yCoord+" "+zCoord+" "+direction);
		
		isBlock("tile.air");
		return true;
	}
	
	private boolean isBlock(String name){
		if(direction == 2){
			x = -a;
			z = b;
		}
		if(direction == 4){
			x = b;
			z = a;
		}
		if(direction == 5){
			x = -b;
			z = a;
		}
		if(direction == 3){
			x = a;
			z = -b;
		}
		Block block = worldObj.getBlock(x + xCoord, y + yCoord, z + zCoord);
		System.out.println(block.getUnlocalizedName());
		return(block.getUnlocalizedName().equals(name));
	}
}