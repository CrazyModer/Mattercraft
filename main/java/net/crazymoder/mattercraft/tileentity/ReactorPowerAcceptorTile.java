package net.crazymoder.mattercraft.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import cofh.api.transport.IEnderEnergyHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class ReactorPowerAcceptorTile extends TileEntity implements IEnergyReceiver{
	
	public EnergyStorage energyStorage = new EnergyStorage(100000000, 5000000);
	
	public ReactorPowerAcceptorTile(){
		
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(!worldObj.isRemote){
			System.out.println(energyStorage.getEnergyStored());
		}
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return energyStorage.receiveEnergy(maxReceive, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return energyStorage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return energyStorage.getEnergyStored();
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyStorage.readFromNBT(tag);
	}

	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		energyStorage.writeToNBT(tag);
	}

}
