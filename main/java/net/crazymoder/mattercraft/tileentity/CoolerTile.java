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

public class CoolerTile extends TileEntity implements IFluidHandler{
    

	private FluidTank fluidTank1 = new FluidTank(20000);
	private FluidTank fluidTank2 = new FluidTank(20000);
	
	public CoolerTile() {
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			System.out.println(fluidTank1.getFluidAmount());
		}
		super.updateEntity();
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		
	}

	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		
	}

	@Override
	public boolean canDrain(ForgeDirection arg0, Fluid arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canFill(ForgeDirection arg0, Fluid arg1) {
		
		return true;
	}

	@Override
	public FluidStack drain(ForgeDirection arg0, FluidStack arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fill(ForgeDirection arg0, FluidStack resource, boolean doFill) {
		System.out.println(resource.getFluid().getUnlocalizedName());
		if(resource.getFluid().getUnlocalizedName().equals("fluid.tile.water"))
			return this.fluidTank1.fill(resource, doFill);
		return 0;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection arg0) {
		return new FluidTankInfo[] {this.fluidTank1.getInfo(),this.fluidTank2.getInfo()};
	}
}
