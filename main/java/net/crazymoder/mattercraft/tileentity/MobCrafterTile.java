package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import scala.Array;

public class MobCrafterTile extends TileEntity implements ISidedInventory{
	
	public List<ItemStack> slots;
	
	public MobCrafterTile() {
		slots = new ArrayList<ItemStack>();
		for (int i = 0; i < 11; i++) {
			slots.add(i, null);
		}
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 11;
	}

	@Override
	public ItemStack getStackInSlot(int slotId) {
		return slots.get(slotId);
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		slots.get(slot).stackSize = slots.get(slot).stackSize - amount;
		ItemStack returnStack = ItemStack.copyItemStack(slots.get(slot));
		returnStack.stackSize = slots.get(slot).stackSize - amount > -1 ? returnStack.stackSize - amount : 0;
		return ItemStack.copyItemStack(slots.get(slot));
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return slots.get(slot);
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		slots.set(slot, stack);
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return slot != 0;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}
}
