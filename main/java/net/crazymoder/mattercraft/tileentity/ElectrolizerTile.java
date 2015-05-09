package net.crazymoder.mattercraft.tileentity;

import java.util.Random;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class ElectrolizerTile extends TileEntity implements IFluidHandler , IEnergyReceiver{
	
	private FluidTank tankIn = new FluidTank(10000);
	private FluidTank tankOut = new FluidTank(10000);
	private EnergyStorage energyStorage = new EnergyStorage(200000,2500);
	
	public int energyStorageDisplay = 0;
	public int tankInDisplay = 0;
	public int tankOutDisplay = 0;
	
	public ElectrolizerTile(){
	}
	
	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(!worldObj.isRemote){
			if(energyStorage.getEnergyStored() >= 2000 && tankIn.getFluidAmount() >= 100 && tankOut.getFluidAmount() <= tankOut.getCapacity() - 100){
				energyStorage.extractEnergy(2000, false);
				tankOut.fill(new FluidStack(new Fluid("mtc.hydrogen"),100), true);
				tankIn.drain(100, true);
			}
			energyStorageDisplay = energyStorage.getEnergyStored();
			tankInDisplay = tankIn.getFluidAmount();
			tankOutDisplay = tankOut.getFluidAmount();
		}
	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if(resource.getFluid().getUnlocalizedName().equals("fluid.tile.water"))
			return this.tankIn.fill(resource, doFill);
		return 0;
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
	{
		return this.tankOut.drain(resource.amount, doDrain);
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
	{
		return this.tankOut.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		FluidTankInfo[] info = {tankIn.getInfo(),tankOut.getInfo()};
		return info;
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
	
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		NBTTagCompound tankCompaund1 = new NBTTagCompound();
		NBTTagCompound tankCompaund2 = new NBTTagCompound();
		NBTTagCompound tankCompaund3 = new NBTTagCompound();
		tankIn.writeToNBT(tankCompaund1);
		tankOut.writeToNBT(tankCompaund2);
		energyStorage.writeToNBT(tankCompaund3);
		tag.setTag("tank1", tankCompaund1);
		tag.setTag("tank2", tankCompaund2);
		tag.setTag("tank3", tankCompaund3);
		super.writeToNBT(tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		NBTTagCompound tankCompaund1 = (NBTTagCompound) tag.getTag("tank1");
		NBTTagCompound tankCompaund2 = (NBTTagCompound) tag.getTag("tank2");
		NBTTagCompound tankCompaund3 = (NBTTagCompound) tag.getTag("tank3");
		tankIn.readFromNBT(tankCompaund1);
		tankOut.readFromNBT(tankCompaund2);
		energyStorage.readFromNBT(tankCompaund3);
		super.readFromNBT(tag);
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tagCompound = new NBTTagCompound();
		tagCompound.setInteger("energy",energyStorageDisplay);
		tagCompound.setInteger("tankIn",tankInDisplay);
		tagCompound.setInteger("tankOut",tankOutDisplay);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tagCompound = pkt.func_148857_g();
		energyStorageDisplay = tagCompound.getInteger("energy");
		tankInDisplay = tagCompound.getInteger("tankIn");
		tankOutDisplay = tagCompound.getInteger("tankOut");
	}

}