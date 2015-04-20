package net.crazymoder.mattercraft.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EnergyCoreTile extends TileEntity{

	public EnergyCoreTile() {
		super();
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		World world = worldObj;
		
	}
}
