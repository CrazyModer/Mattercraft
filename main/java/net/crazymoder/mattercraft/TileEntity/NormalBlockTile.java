package net.crazymoder.mattercraft.TileEntity;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class NormalBlockTile extends TileEntity{

	public NormalBlockTile() {
		super();
		System.out.println("Epic");
	}
	
	@Override
	public void updateEntity() {
		System.out.println("X: "+xCoord+" Y: "+yCoord+" Z: "+zCoord+" Updates: ");
		super.updateEntity();
	}
}