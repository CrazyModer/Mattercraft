package net.crazymoder.mattercraft.tileentity;

import java.util.LinkedHashMap;
import java.util.Random;

import cofh.api.inventory.IInventoryConnection;
import cofh.api.transport.IEnderItemHandler;
import cofh.api.transport.IItemDuct;

import com.sun.webkit.Utilities;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.helper.CostomInventory;
import net.crazymoder.mattercraft.manager.ConfigurationManager;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class ItemProviderTile extends TileEntity implements ISidedInventory{
	
	public CostomInventory inv;
	public ItemStack currentStack;
	
	
	public ItemProviderTile() {
		inv  = new CostomInventory();
	}
	
	@Override
	public void updateEntity() { 
		if(!worldObj.isRemote){
			if(inv.getItemCount() > 0 && (currentStack == null || currentStack.stackSize == 0)){
				currentStack = inv.getNextItemStack(false);
			}
		}
	}


	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		if(p_70301_1_ == 0)return currentStack;
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		if(p_70298_1_ != 0)return null;
		if(p_70298_2_ >= currentStack.stackSize){
			ItemStack rv = currentStack.copy();
			currentStack = null;
			return rv;
		}
		ItemStack rv = currentStack.copy();
		rv.stackSize = p_70298_2_;
		currentStack.stackSize -= p_70298_2_;
		return rv;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		if(p_70304_1_ != 0)return null;
		return currentStack;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		if(p_70299_1_ == 0)
			currentStack = p_70299_2_;
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "ItemProvider";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		int[] slots = {0};
		return slots;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,int p_102007_3_) {
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,int p_102008_3_) {
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		CostomInventory sInv = new CostomInventory();
		sInv.setMap((LinkedHashMap<ItemStack, Integer>) inv.getMap().clone());
		if(currentStack != null)sInv.addItemStack(currentStack);
		sInv.writeNBT(tag);
		super.writeToNBT(tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		currentStack = null;
		inv = new CostomInventory();
		inv.readNBT(tag);
		super.readFromNBT(tag);
	}
	
}
