package net.crazymoder.mattercraft.helper.inventory;

import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.tileentity.MobCrafterTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class MobCrafterSlot extends Slot{

	private boolean export; 
	public MobCrafterSlot(boolean export,MobCrafterTile inventory, int id, int x, int y) {
		super(inventory, id, x, y);
		this.export = export;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		if(export)return false;
		if(stack.getItem().equals(AdvancedItemManager.mobSoul) && stack.hasTagCompound())return true;
		return false;
	}
}
