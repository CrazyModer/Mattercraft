package net.crazymoder.mattercraft.tileentity.generator;

import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class GeneratorEnergyPortTile extends TileEntity implements IEnergyProvider{
	
	private GeneratorControllerTile master;
	
	public GeneratorEnergyPortTile() {
		
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(!worldObj.isRemote && hasMaster()){
			if(worldObj.getTileEntity(xCoord, yCoord-1, zCoord) instanceof IEnergyReceiver){
				IEnergyReceiver te = (IEnergyReceiver) worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
				//System.out.println(te.receiveEnergy(ForgeDirection.UP, master.energyStorage.extractEnergy(master.energyStorage.getMaxExtract(), false), false));
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
		return true;
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

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract,boolean simulate) {
		if(hasMaster()){
			master.energyStorage.extractEnergy(maxExtract, simulate);
		}
		return 0;
	}
}
