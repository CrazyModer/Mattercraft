package net.crazymoder.mattercraft.tileentity.generator;

import cofh.api.energy.IEnergyReceiver;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class GeneratorEnergyPortTile extends TileEntity implements IEnergyReceiver{
	
	private GeneratorControllerTile master;
	
	public GeneratorEnergyPortTile() {
		
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			if(hasMaster()){
				//System.out.println("EnergyX: "+xCoord);
			}
		}
	}
	
	public void setMaster(GeneratorControllerTile tile){
		master = tile;
	}
	public boolean hasMaster(){
		if(master != null && master instanceof GeneratorControllerTile && !master.isInvalid()){
			return true;
		}
		master = null;
		return false;
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return hasMaster();
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive,boolean simulate) {
		if(hasMaster()){
			master.energyStorage.receiveEnergy(maxReceive, simulate);
		}
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		if(hasMaster()){
			return master.energyStorage.getEnergyStored();
		}
		return 0;
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		if(hasMaster()){
			return master.energyStorage.getMaxEnergyStored();
		}
		return 0;
	}
}
