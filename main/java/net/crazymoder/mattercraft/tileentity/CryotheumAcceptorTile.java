package net.crazymoder.mattercraft.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class CryotheumAcceptorTile extends TileEntity implements IFluidTank{
	public CryotheumAcceptorTile() {
		fluidStack = new FluidStack(FluidRegistry.getFluid("cryotheum"), 0);
	}
	
	private FluidStack fluidStack;
	private int capacity = 10000;
	
	public void updateEntity() {
		super.updateEntity();
		if(!worldObj.isRemote){
			System.out.println(fluidStack.amount);
		}
	}
	
	

	@Override
	public FluidStack drain(int arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return new FluidStack(fluidStack, 0);
	}

	@Override
	public int fill(FluidStack arg0, boolean arg1) {
		// TODO Auto-generated method stub
		int temp = capacity - arg0.amount - fluidStack.amount;
		fluidStack.amount += arg0.amount;
		return arg0.amount;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public FluidStack getFluid() {
		// TODO Auto-generated method stub
		return fluidStack;
	}

	@Override
	public int getFluidAmount() {
		// TODO Auto-generated method stub
		return fluidStack.amount;
	}

	@Override
	public FluidTankInfo getInfo() {
		// TODO Auto-generated method stub
		return new FluidTankInfo(fluidStack, capacity);
	}
}
