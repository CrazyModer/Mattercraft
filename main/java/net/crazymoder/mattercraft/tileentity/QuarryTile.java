package net.crazymoder.mattercraft.tileentity;

import java.util.LinkedHashMap;
import java.util.Random;

import cofh.api.inventory.IInventoryConnection;
import cofh.api.transport.IEnderItemHandler;
import cofh.api.transport.IItemDuct;

import com.sun.webkit.Utilities;

import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.helper.CostomInventory;
import net.crazymoder.mattercraft.helper.quarry.MultiBlockStructurManager;
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
import net.minecraft.util.AxisAlignedBB;
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

public class QuarryTile extends TileEntity{
	
	MultiBlockStructurManager mBsm = new MultiBlockStructurManager();
	Random r = new Random();
	boolean init = true;
	int loop = 10;
	
	public QuarryTile() {
	
	}
	
	@Override
	public void updateEntity() { 
		if(!worldObj.isRemote){
			if(init){
				init = false;
				mBsm.init(worldObj, xCoord, yCoord, zCoord);
			}
			loop--;
			if(loop < 1){
				loop = 10;
				System.out.println("Quarry MBS State = " + mBsm.checkMBS(true));
			}
		}
		
		
	}
	
	private void moveinventory(){
		int index = r.nextInt(mBsm.cardReaders.size());
		int enerylevel = 10;
		MemoryCardReaderTile cardReaderTile= mBsm.cardReaders.get(index);
		if(cardReaderTile.itemStack != null && cardReaderTile.itemStack.stackSize > 0 && cardReaderTile.itemStack.hasTagCompound()){
			mBsm.itemProviderTile.inv.readNBT(cardReaderTile.itemStack.stackTagCompound);
			enerylevel = 1000;
		}
		mBsm.powerAcceptorTile.energyStorage.extractEnergy(enerylevel*100, false);
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}

}
