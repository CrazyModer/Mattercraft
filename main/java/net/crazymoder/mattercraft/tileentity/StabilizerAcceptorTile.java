package net.crazymoder.mattercraft.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class StabilizerAcceptorTile extends TileEntity implements IFluidHandler{
	public FluidTank tank = new FluidTank(50000);
	public StabilizerAcceptorTile() {
	}
	
	public void updateEntity() {
		super.updateEntity();
		if(!worldObj.isRemote){
			System.out.println(tank.getFluidAmount());
		}
	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
	{
		if(resource.getFluid().getUnlocalizedName().equals("fluid.mtc.stabilizer"))
			return this.tank.fill(resource, doFill);
		return 0;
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
	{
		return new FluidStack(new Fluid("mtc.stabilizer"),0);
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
	{
		return new FluidStack(new Fluid("mtc.stabilizer"),0);
	}

	public boolean canFill(ForgeDirection from, Fluid fluid)
	{
		return true;
	}

	public boolean canDrain(ForgeDirection from, Fluid fluid)
	{
		return false;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from)
	{
		return new FluidTankInfo[] {this.tank.getInfo()};
	}
	

	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		tank.readFromNBT(tag);
	}

	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tank.writeToNBT(tag);
	}
}
