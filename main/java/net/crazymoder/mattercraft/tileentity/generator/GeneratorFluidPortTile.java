package net.crazymoder.mattercraft.tileentity.generator;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class GeneratorFluidPortTile extends TileEntity implements IFluidHandler{
	private GeneratorControllerTile master;
	
	public GeneratorFluidPortTile(){
		
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			if(hasMaster()){
				System.out.println("FluidX: "+xCoord);
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
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if(hasMaster()){
			if(resource.getUnlocalizedName().equals("fluid.mtc.ionizedPlasma")){
				System.out.println("plasma");
				return master.plasmaTank.fill(resource, doFill);
			}
			if(resource.getUnlocalizedName().equals("fluid.tile.water")){
				System.out.println("water");
				return master.watertank.fill(resource, doFill);
			}
		}
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,boolean doDrain) {
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		if(hasMaster()){
			return true;
		}
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		if(hasMaster()){
			FluidTankInfo[] info = {master.watertank.getInfo(),master.plasmaTank.getInfo()};
			return info;
		}
		return null;
	}
}
