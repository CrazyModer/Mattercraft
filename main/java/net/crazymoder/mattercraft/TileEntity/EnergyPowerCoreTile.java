package net.crazymoder.mattercraft.TileEntity;

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
		count = 0;
	}
	private int count;
	@Override
	public void updateEntity() {
		count++;
		super.updateEntity();
		if(count > 9){
			count = 0;
			World world = this.worldObj;
			Block b1 = world.getBlock(xCoord, yCoord+1, zCoord);
			if(b1.getUnlocalizedName().equals("tile.blockdiamond")){
				
			}
		}
	}
}
