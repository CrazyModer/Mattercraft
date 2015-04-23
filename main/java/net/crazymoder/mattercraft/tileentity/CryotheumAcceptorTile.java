package net.crazymoder.mattercraft.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class CryotheumAcceptorTile extends TileEntity{
	public CryotheumAcceptorTile() {
		
	}
	private int facingDirection;
	
	public int getFacingDirection()
    {
        return this.facingDirection;
    }
	
	public void setFacingDirection(int facing)
    {
        this.facingDirection = facing;
        System.out.println(this.facingDirection);
    }
	
	@Override
    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound); 
        facingDirection = nbttagcompound.getInteger("facingDirection");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setInteger("facingDirection", facingDirection);
    }
}
