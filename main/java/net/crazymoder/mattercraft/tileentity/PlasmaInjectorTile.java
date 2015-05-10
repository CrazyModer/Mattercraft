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

public class PlasmaInjectorTile extends TileEntity implements IFluidHandler{

	@Override
	public boolean canDrain(ForgeDirection arg0, Fluid arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canFill(ForgeDirection arg0, Fluid arg1) {
		// TODO Auto-generated method stub
		return false;
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
	public int fill(ForgeDirection arg0, FluidStack arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
