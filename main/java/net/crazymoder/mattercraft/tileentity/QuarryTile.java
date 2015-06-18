package net.crazymoder.mattercraft.tileentity;

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

public class QuarryTile extends TileEntity implements IInventoryConnection , ISidedInventory{
	
	public CostomInventory inv;
	public ItemStack currentStack;
	
	
	public QuarryTile() {
		inv  = new CostomInventory();
		currentStack = new ItemStack(Items.diamond,64);
	}
	
	@Override
	public void updateEntity() { 
		if(!worldObj.isRemote){
			put();
		}
	}
	
	private void put(){
		if(currentStack != null){
			TileEntity entity = worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
			if(entity instanceof IItemDuct){
				IItemDuct itemDuct = (IItemDuct) entity;
				currentStack = itemDuct.insertItem(ForgeDirection.DOWN, currentStack);
			}else if(entity instanceof ISidedInventory){
				System.out.println("A");
				ISidedInventory iSidedInventory = (ISidedInventory) entity;
				int[] slots = iSidedInventory.getAccessibleSlotsFromSide(0);
				for (int i = slots.length-1;  i >= 0; i--) {
					if(iSidedInventory.canInsertItem(i, currentStack, 0)){
						ItemStack slotStack = iSidedInventory.getStackInSlot(i);
						if(slotStack == null){
							iSidedInventory.setInventorySlotContents(i, currentStack);
							currentStack = null;
						}else{
							if(ItemStack.areItemStacksEqual(slotStack, currentStack)){
								int itemcount = slotStack.stackSize + currentStack.stackSize;
								if(itemcount <= slotStack.getMaxStackSize()){
									slotStack.stackSize = itemcount;
									currentStack = null;
								}else{
									slotStack.stackSize = slotStack.getMaxStackSize();
									currentStack.stackSize = itemcount - slotStack.getMaxStackSize();
								}
							}
						}
					}else if(entity instanceof IInventory){
						System.out.println("B");
						IInventory iInventory = (IInventory) entity;
						for (int j = getSizeInventory()-1;  j >= 0; j--) {
							ItemStack slotStack = iInventory.getStackInSlot(j);
							if(slotStack == null){
								iInventory.setInventorySlotContents(j, currentStack);
								currentStack = null;
							}else{
								if(ItemStack.areItemStacksEqual(slotStack, currentStack)){
									int itemcount = slotStack.stackSize + currentStack.stackSize;
									if(itemcount <= slotStack.getMaxStackSize()){
										slotStack.stackSize = itemcount;
										currentStack = null;
									}else{
										slotStack.stackSize = slotStack.getMaxStackSize();
										currentStack.stackSize = itemcount - slotStack.getMaxStackSize();
									}
									iInventory.setInventorySlotContents(j, slotStack);
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public ConnectionType canConnectInventory(ForgeDirection from) {
		return ConnectionType.FORCE;
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "inv";
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO Auto-generated method stub
		int[] slots = {0};
		return slots;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
