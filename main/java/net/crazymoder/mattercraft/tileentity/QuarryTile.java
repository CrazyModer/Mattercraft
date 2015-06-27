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
import net.crazymoder.mattercraft.helper.sound.LoopableTileEntitySound;
import net.crazymoder.mattercraft.interfaces.INoisyTileEntity;
import net.crazymoder.mattercraft.manager.ConfigurationManager;
import net.crazymoder.mattercraft.proxys.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
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

public class QuarryTile extends TileEntity implements INoisyTileEntity{
	
	public MultiBlockStructurManager mbsm = new MultiBlockStructurManager();
	private Random r = new Random();
	private boolean init = true;
	public int loop = 00;
	public int tier = 0;
	public int lasttier = 0;
	public float relativEnergy = 0;
	public QuarryTile() {
	
	}
	
	@Override
	public void updateEntity() { 
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(!worldObj.isRemote){
			if(init){
				mbsm.init(worldObj, xCoord, yCoord, zCoord);
				lasttier = mbsm.checkMBS(true);
				tier = lasttier;
			}
			loop--;
			if(loop < 1){
				loop = 10;
				tier = mbsm.checkMBS(true);
				if(tier > 0){
					for (MemoryCardReaderTile iterTile : mbsm.cardReaders) {
						iterTile.cooldown = 20;
						iterTile.renderBeam = true;
					}
				}
			}else{
				if(tier != -2)
				tier = mbsm.checkMBS(false);
			}
			if(tier > 0 && lasttier <= 0 && lasttier != tier)activate();
			if(lasttier > 0 && tier <= 0 && lasttier != tier)deactivate();
			if(lasttier != tier && tier > 0)change();
			if(tier > 0)update();
			if(init){
				if(tier > 0)
					change();
				init = false;
			}
			lasttier = tier;
		}else{
			if(init){
				init = false;
				ISound eventHorizonSound = new LoopableTileEntitySound("step.wood", this, 1F, 1F);
				Minecraft.getMinecraft().getSoundHandler().playSound(eventHorizonSound);
			}
		}
	}
	
	private void activate(){
		change();
	}
	
	private void deactivate(){
		worldObj.createExplosion(null, xCoord, yCoord+10, zCoord, 50f, false);
	}
	
	private void change(){
		if(tier == 1){
			mbsm.powerAcceptorTile.energyStorage.setCapacity(100000000);
			mbsm.powerAcceptorTile.energyStorage.setMaxTransfer(10000);
		}else if(tier == 2){
			mbsm.powerAcceptorTile.energyStorage.setCapacity(300000000);
			mbsm.powerAcceptorTile.energyStorage.setMaxTransfer(500000);
		}else{
			mbsm.powerAcceptorTile.energyStorage.setCapacity(1000000000);
			mbsm.powerAcceptorTile.energyStorage.setMaxTransfer(1000000000);
		}				
	}
	
	private void update(){
		if(mbsm.powerAcceptorTile.energyStorage.getMaxEnergyStored() > 0)relativEnergy = (float) mbsm.powerAcceptorTile.energyStorage.getEnergyStored() / mbsm.powerAcceptorTile.energyStorage.getMaxEnergyStored();
		if(relativEnergy == 1 && mbsm.itemProviderTile.inv.getItemCount() == 0)moveinventory();
	}
	
	private void moveinventory(){
		int index = r.nextInt(mbsm.cardReaders.size());
		MemoryCardReaderTile cardReaderTile= mbsm.cardReaders.get(index);
		if(cardReaderTile.itemStack != null && cardReaderTile.itemStack.stackSize > 0 && cardReaderTile.itemStack.hasTagCompound()){
			mbsm.itemProviderTile.inv.readNBT(cardReaderTile.itemStack.stackTagCompound);
			mbsm.powerAcceptorTile.energyStorage.setEnergyStored(0);
			worldObj.playSoundEffect((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D, "step.wood", 1F, 0.1F);
		}else{
			mbsm.powerAcceptorTile.energyStorage.setEnergyStored((int) (mbsm.powerAcceptorTile.energyStorage.getMaxEnergyStored()*0.9f));
		}
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tagCompound = new NBTTagCompound();
		tagCompound.setInteger("tier", tier);
		tagCompound.setFloat("relativEnergy", relativEnergy);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tagCompound = pkt.func_148857_g();
		tier = tagCompound.getInteger("tier");
		relativEnergy = tagCompound.getFloat("relativEnergy");
	}

	@Override
	public boolean isplaying() {
		return tier > 0;
	}

	@Override
	public float getPitch() {
		return 0.5f + (relativEnergy / 2f);
	}

	@Override
	public float getVolume() {
		return 1f;
	}

}
