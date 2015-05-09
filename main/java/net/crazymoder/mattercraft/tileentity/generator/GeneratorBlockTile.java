package net.crazymoder.mattercraft.tileentity.generator;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class GeneratorBlockTile extends TileEntity{
	private GeneratorControllerTile controllerTile;
	private boolean state;
	
	public GeneratorBlockTile(){
		
	}
	
	private void changestate(){
		System.out.println(state);
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			if(controllerTile != null && !controllerTile.isInvalid()){
				if(controllerTile.isMbsOK && !state){
					state = true;
					changestate();
				}
				if(!controllerTile.isMbsOK && state){
					state = false;
					changestate();
				}
			}else{
				if(state == true){
					state = false;
					changestate();
				}
				state = false;
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		if(controllerTile != null && !controllerTile.isInvalid()){
			int[] cords = {controllerTile.xCoord,controllerTile.yCoord,controllerTile.zCoord};
			tag.setIntArray("controler", cords);
			super.writeToNBT(tag);
		}
	}
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		if(tag.hasKey("controler")){
			int[] cords = tag.getIntArray("controler");
			TileEntity tile = worldObj.getTileEntity(cords[0], cords[1], cords[2]);
			if(tile != null && tile instanceof GeneratorBlockTile){
				controllerTile = (GeneratorControllerTile) tile;
			}
		}
		super.readFromNBT(tag);
	}
	
	
	public void setController(GeneratorControllerTile tile){
		controllerTile = tile;
	}

}
