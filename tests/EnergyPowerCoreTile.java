package net.crazymoder.mattercraft.tileentity;

import java.util.List;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EnergyPowerCoreTile extends TileEntity implements IEnergyProvider{
	
	public EnergyPowerCoreTile() {
		super();
	}
	@Override
	public void updateEntity() {
		super.updateEntity();
		if(worldObj.getBlock(xCoord, yCoord+1, zCoord).hasTileEntity(1) && !worldObj.isRemote){
			if(worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof IEnergyReceiver){
				IEnergyReceiver te = (IEnergyReceiver) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
				System.out.println(te.receiveEnergy(ForgeDirection.DOWN, 1000, false));
			}
		}
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		// TODO Auto-generated method stub
		return (from == ForgeDirection.UP);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract,
			boolean simulate) {
		// TODO Auto-generated method stub
		return maxExtract;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return 100000;
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		// TODO Auto-generated method stub
		return 200000;
	}
	
}
