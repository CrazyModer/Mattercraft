package net.crazymoder.mattercraft.TileEntity;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class EnergyCollectorTile extends TileEntity{

	public EnergyCollectorTile() {
		super();
		System.out.println("Epic");
	}
	
	@Override
	public void updateEntity() {
		System.out.println("X: "+xCoord+" Y: "+yCoord+" Z: "+zCoord+" Updates: ");
		super.updateEntity();
	}
}
