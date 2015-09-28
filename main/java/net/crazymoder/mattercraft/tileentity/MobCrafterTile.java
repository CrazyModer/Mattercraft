package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Map.Entry;

import net.crazymoder.mattercraft.fluids.IonizedPlasma;
import net.crazymoder.mattercraft.helper.MatterHelper;
import net.crazymoder.mattercraft.helper.inventory.CostomInventory;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.material.FluidMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import scala.Array;

public class MobCrafterTile extends TileEntity implements ISidedInventory,IFluidHandler{
	
	private Random rand;
	
	public List<ItemStack> slots;
	public FluidTank plasmaTank;
	public int cooldown;
	public int maxCooldown;
	int index = 0;
	
	public MobCrafterTile() {
		rand = new Random();
		plasmaTank = new FluidTank(10000000);
		slots = new ArrayList<ItemStack>();
		for (int i = 0; i < 11; i++) {
			slots.add(i, null);
		}
	}
	
	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(worldObj.isRemote)return;
		if(cooldown > 0){
			cooldown--;
			return;
		}
		ItemStack stack = slots.get(index + 2);;
		for (int i = 0; i < 9; i++) {
			stack = slots.get(index + 2);
			index++;
			if(index > 8)index = 0;
			if(stack != null)break;
		}
		if(stack != null && stack.getItem().equals(AdvancedItemManager.mobSoul) && stack.hasTagCompound() && stack.stackTagCompound.hasKey("mobname") && stack.stackTagCompound.hasKey("plasma") && stack.stackTagCompound.hasKey("cooldown") && stack.stackTagCompound.hasKey("costomInventory") && slots.get(0) == null && plasmaTank.getFluidAmount() > 5000000){
			CostomInventory inv = new CostomInventory();
			NBTTagCompound tag = stack.getTagCompound();
			inv.readNBT(tag);
			int itemId = rand.nextInt(inv.getItemCount());
			ItemStack result;
			for(Entry<ItemStack, Integer> entry : inv.getMap().entrySet()) {
				itemId -= entry.getValue();
				if(itemId <= 0){
					result = entry.getKey();
					result.stackSize = Math.min(64, inv.getItemCount());
					slots.set(0, result);
					itemId = 1000000;
				}
			}
			maxCooldown = tag.getInteger("cooldown");
			cooldown = maxCooldown;
			plasmaTank.drain(tag.getInteger("plasma"), true);
		}
		if(slots.get(0) != null){
			if(slots.get(1) == null){
				slots.set(1,slots.get(0));
				slots.set(0, null);
			}else{
				if(MatterHelper.areItemStackTypesEqual(slots.get(0), slots.get(1))){
					int move = Math.min(slots.get(0).getMaxStackSize(), Math.min(slots.get(0).stackSize, slots.get(1).getMaxStackSize() - slots.get(1).stackSize));
					slots.get(1).stackSize += move;
					slots.get(0).stackSize -= move;
					if(slots.get(0).stackSize == 0)slots.set(0, null);
				}
			}
		}
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if(slot > 10)return null;
		return slots.get(slot);
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(slot > 10)return null;
		if(amount >= slots.get(slot).stackSize){
			ItemStack rv = slots.get(slot).copy();
			slots.set(slot,null);
			return rv;
		}
		ItemStack rv = slots.get(slot).copy();
		rv.stackSize = amount;
		slots.get(slot).stackSize -= amount;
		return rv;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if(slot > 10)return null;
		return slots.get(slot);
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if(slot > 10)return;
		slots.set(slot, stack);
	}

	@Override
	public String getInventoryName() {
		return "Mob Crafter";
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
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord) != BlockManager.mobCrafter ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
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
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		int[] slotIds = {1};
		return slotIds;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item, int side) {
		return slot == 1;
	}
	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if(resource.getFluid().equals(IonizedPlasma.ionizedPlasma))
			return plasmaTank.fill(resource, doFill);
		return 0;
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain){
		return null;
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain){
		return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		FluidTankInfo[] info = {plasmaTank.getInfo(),plasmaTank.getInfo()};
		return info;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		plasmaTank.writeToNBT(tag);
		for (int i = 0; i < slots.size(); i++) {
			if(slots.get(i) != null){
				NBTTagCompound itemTag = new NBTTagCompound();
				slots.get(i).writeToNBT(itemTag);
				tag.setTag("Item"+i, itemTag);
			}else{
				if(tag.hasKey("Item"+i)){
					tag.removeTag("Item"+i);
				}
			}
			
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		plasmaTank.readFromNBT(tag);
		for (int i = 0; i < slots.size(); i++) {
			if(tag.hasKey("Item"+i)){
				NBTTagCompound itemtag = (NBTTagCompound) tag.getTag("Item"+i);
				ItemStack stack = ItemStack.loadItemStackFromNBT(itemtag);
				slots.set(i, stack);
			}
		}
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		plasmaTank.writeToNBT(tag);
		tag.setInteger("maxCooldown", maxCooldown);
		tag.setInteger("cooldown", cooldown);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		plasmaTank.readFromNBT(tag);
		cooldown = tag.getInteger("cooldown");
		maxCooldown = tag.getInteger("maxCooldown");
	}
}
