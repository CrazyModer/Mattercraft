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
				master.energyStorage.extractEnergy(te.receiveEnergy(ForgeDirection.UP, master.energyStorage.extractEnergy(master.energyStorage.getMaxExtract(), true), false), false);
			}
			if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 2 && worldObj.getTileEntity(xCoord, yCoord, zCoord-1) instanceof IEnergyReceiver){
				IEnergyReceiver te = (IEnergyReceiver) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
				master.energyStorage.extractEnergy(te.receiveEnergy(ForgeDirection.SOUTH, master.energyStorage.extractEnergy(master.energyStorage.getMaxExtract(), true), false), false);
			}
			if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 3 && worldObj.getTileEntity(xCoord, yCoord, zCoord+1) instanceof IEnergyReceiver){
				IEnergyReceiver te = (IEnergyReceiver) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
				master.energyStorage.extractEnergy(te.receiveEnergy(ForgeDirection.NORTH, master.energyStorage.extractEnergy(master.energyStorage.getMaxExtract(), true), false), false);
			}
			if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 4 && worldObj.getTileEntity(xCoord-1, yCoord, zCoord) instanceof IEnergyReceiver){
				IEnergyReceiver te = (IEnergyReceiver) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
				master.energyStorage.extractEnergy(te.receiveEnergy(ForgeDirection.EAST, master.energyStorage.extractEnergy(master.energyStorage.getMaxExtract(), true), false), false);
			}
			if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 5 && worldObj.getTileEntity(xCoord+1, yCoord, zCoord) instanceof IEnergyReceiver){
				IEnergyReceiver te = (IEnergyReceiver) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
				master.energyStorage.extractEnergy(te.receiveEnergy(ForgeDirection.WEST, master.energyStorage.extractEnergy(master.energyStorage.getMaxExtract(), true), false), false);
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
