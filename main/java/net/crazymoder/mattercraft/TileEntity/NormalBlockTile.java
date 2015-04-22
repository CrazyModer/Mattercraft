package net.crazymoder.mattercraft.tileentity;

import com.sun.javafx.geom.Vec3d;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class NormalBlockTile extends TileEntity{
	public boolean visibility;
	public NormalBlockTile() {
		super();
		visibility = false;
	}
	public void setvisibility(boolean state){
		if(visibility != state){
			visibility = state;
			update();
		}
	}
	private void update(){
		
	}
}