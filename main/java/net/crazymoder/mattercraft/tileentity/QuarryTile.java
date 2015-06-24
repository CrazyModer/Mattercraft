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
	
	MultiBlockStructurManager mbsm = new MultiBlockStructurManager();
	Random r = new Random();
	boolean init = true;
	public int loop = 10;
	public int tier = 0;
	public int lasttier = 0;
	
	public QuarryTile() {
	
	}
	
	@Override
	public void updateEntity() { 
		if(!worldObj.isRemote){
			if(init){
				init = false;
				mbsm.init(worldObj, xCoord, yCoord, zCoord);
			}
			loop--;
			if(loop < 1){
				loop = 10;
				tier = mbsm.checkMBS(true);
			}else{
				tier = mbsm.checkMBS(false);
			}
			
			if(tier > 0 && lasttier <= 0)activate();
			if(lasttier > 0 && tier <= 0)deactivate();
			if(lasttier != tier && tier > 0)change();
			if(tier > 0)update();
			lasttier = tier;
		}
		
		
	}
	
	private void activate(){
		System.out.println("Activate");
	}
	
	private void deactivate(){
		System.out.println("Deactivate");
		//worldObj.createExplosion(null, xCoord, yCoord+10, zCoord, 50f, false);
	}
	
	private void change(){
		if(tier == 1){
			mbsm.powerAcceptorTile.energyStorage.setCapacity(100000000);
			mbsm.powerAcceptorTile.energyStorage.setMaxTransfer(50000);
		}else if(tier == 2){
			mbsm.powerAcceptorTile.energyStorage.setCapacity(200000000);
			mbsm.powerAcceptorTile.energyStorage.setMaxTransfer(150000);
		}else{
			mbsm.powerAcceptorTile.energyStorage.setCapacity(400000000);
			mbsm.powerAcceptorTile.energyStorage.setMaxTransfer(450000);
		}
	}
	
	private void update(){
		float relativEnergy = 0;
		if(mbsm.powerAcceptorTile.energyStorage.getMaxEnergyStored() > 0)relativEnergy = mbsm.powerAcceptorTile.energyStorage.getEnergyStored() / mbsm.powerAcceptorTile.energyStorage.getMaxEnergyStored();
		System.out.println(relativEnergy);
	}
	
	private void moveinventory(){
		int index = r.nextInt(mbsm.cardReaders.size());
		int enerylevel = 10;
		MemoryCardReaderTile cardReaderTile= mbsm.cardReaders.get(index);
		if(cardReaderTile.itemStack != null && cardReaderTile.itemStack.stackSize > 0 && cardReaderTile.itemStack.hasTagCompound()){
			mbsm.itemProviderTile.inv.readNBT(cardReaderTile.itemStack.stackTagCompound);
			enerylevel = 1000;
		}
		mbsm.powerAcceptorTile.energyStorage.extractEnergy(enerylevel*100, false);
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}

}
