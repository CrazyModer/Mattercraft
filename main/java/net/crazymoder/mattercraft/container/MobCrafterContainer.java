package net.crazymoder.mattercraft.container;

import net.crazymoder.mattercraft.helper.inventory.MobCrafterSlot;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
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
		Slot product = new Slot(crafterTile, 0, 140, 35);
		this.addSlotToContainer(new MobCrafterSlot(true, crafterTile, 0, 140, 24));
		this.addSlotToContainer(new MobCrafterSlot(true, crafterTile, 1, 140, 46));
		
		for (int l = 0; l < 3; ++l)
        {
            for (int i = 0; i < 3; ++i)
            {
                this.addSlotToContainer(new MobCrafterSlot(false,crafterTile, i+l*3+2 , 30 + i * 18,  17 + l * 18));
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
	
	@Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            //null checks and checks if the item can be stacked (maxStackSize > 1)
            if (slotObject != null && slotObject.getHasStack()) {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();

                    //merges the item into player inventory since its in the tileEntity
                    if (slot < crafterTile.getSizeInventory() + 1) {
                            if (!this.mergeItemStack(stackInSlot, crafterTile.getSizeInventory(), 36+crafterTile.getSizeInventory(), true)) {
                                    return null;
                            }
                    }
                    //places it into the tileEntity is possible since its in the player inventory
                    else if(stackInSlot.getItem().equals(AdvancedItemManager.mobSoul)&&stackInSlot.hasTagCompound()){
                    	if (!this.mergeItemStack(stackInSlot, 2, 11, false)) {
                            return null;
                    	}
                    }

                    if (stackInSlot.stackSize == 0) {
                            slotObject.putStack(null);
                    } else {
                            slotObject.onSlotChanged();
                    }

                    if (stackInSlot.stackSize == stack.stackSize) {
                            return null;
                    }
                    slotObject.onPickupFromSlot(player, stackInSlot);
            }
            return stack;
    }
	 
	 @Override
	public void detectAndSendChanges() {
		// TODO Auto-generated method stub
		super.detectAndSendChanges();
	}
	
	public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != BlockManager.mobCrafter ? false : p_75145_1_.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }

}
