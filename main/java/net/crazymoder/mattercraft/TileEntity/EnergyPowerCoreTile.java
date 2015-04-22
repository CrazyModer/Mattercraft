package net.crazymoder.mattercraft.tileentity;

import java.util.List;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EnergyPowerCoreTile extends TileEntity{

	public EnergyPowerCoreTile() {
		super();
	}
	@Override
	public void updateEntity() {
		super.updateEntity();
		World world = this.worldObj;
		Block b1 = world.getBlock(xCoord, yCoord+1, zCoord);
		if(b1.getUnlocalizedName().equals("tile.normalBlock")){
				System.out.println("Y");
		}
	}
}
