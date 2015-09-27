package net.crazymoder.mattercraft.container;

import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.tileentity.MobCrafterTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MobCrafterContainer extends Container{

	private World worldObj;
	private MobCrafterTile crafterTile;
	private int posX,posY,posZ;
	
	public MobCrafterContainer(EntityPlayer player, World world, int x, int y, int z) {
		crafterTile = (MobCrafterTile) world.getTileEntity(x, y, z);
		worldObj = world;
		posX=x; posY=y; posZ=z;
		
		this.addSlotToContainer(new Slot(crafterTile, 0, 120, 15));
		this.addSlotToContainer(new Slot(crafterTile, 1, 120, 55));
		
		for (int l = 0; l < 3; ++l)
        {
            for (int i = 0; i < 3; ++i)
            {
                this.addSlotToContainer(new Slot(crafterTile, i+l*3+2 , 30 + i * 18,  17 + l * 18));
            }
        }
	
		for (int l = 0; l < 3; ++l)
        {
            for (int i = 0; i < 9; ++i)
            {
                this.addSlotToContainer(new Slot(player.inventory, i + l * 9 + 9, 8 + i * 18, 84 + l * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(player.inventory, l, 8 + l * 18, 142));
        }

	}
	
	 public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
	    {
		 return null;
	        /*ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (p_82846_2_ == 0)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 46, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (p_82846_2_ >= 10 && p_82846_2_ < 37)
	            {
	                if (!this.mergeItemStack(itemstack1, 37, 46, false))
	                {
	                    return null;
	                }
	            }
	            else if (p_82846_2_ >= 37 && p_82846_2_ < 46)
	            {
	                if (!this.mergeItemStack(itemstack1, 10, 37, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(p_82846_1_, itemstack1);
	        }

	        return itemstack;*/
	    }
	
	public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != BlockManager.mobCrafter ? false : p_75145_1_.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

}
