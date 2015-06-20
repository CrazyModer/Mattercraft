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

public class QuarryTile extends TileEntity implements ISidedInventory{
	
	ItemStack[] stacks; 
	
	public int demoval;
	
	public QuarryTile() {
	
	}
	
	@Override
	public void updateEntity() { 
		if(!worldObj.isRemote){
			
		}
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return stacks[slot];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return stacks[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		stacks[slot] = is;
	}

	@Override
	public String getInventoryName() {
		return "";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
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
	public boolean isItemValidForSlot(int slot, ItemStack p_94041_2_) {
		if(stacks[slot] == null || stacks[slot].stackSize == 0)return true;
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		int[] slots = {};
		return slots;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,int p_102007_3_) {
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,int p_102008_3_) {
		return false;
	}

	
}
