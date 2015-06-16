package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.Callable;

import com.sun.webkit.Utilities;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.crazymoder.mattercraft.helper.CostomInventory;
import net.crazymoder.mattercraft.items.BasicItem;
import net.crazymoder.mattercraft.manager.ConfigurationManager;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ReportedException;
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

public class ChunkRegistratorTile extends TileEntity{
	
	int x,z,dim;
	boolean populate = true;
	InventoryBasic inventory;
	Random r;
	Block popAbleBlock;
	boolean init = true;
	
	public ChunkRegistratorTile() {
		r = new Random();
	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote){
			if(init){
				init = false;
				x = (int) Math.floor(xCoord/16f);
				z = (int) Math.floor(zCoord/16f);
				dim = worldObj.provider.dimensionId;
				popAbleBlock = ConfigurationManager.getPopulatable(dim);
				inventory = new InventoryBasic("inventory", false, 100);
			}
			if(populate){
				populate = false;
				populate(x,z);
				//blind();
			}
		}
	}
	private void blind(){
		ListIterator itl = worldObj.playerEntities.listIterator();
		double x = xCoord;
		double y = yCoord;
		double z = zCoord;
			while(itl.hasNext()){
				EntityPlayerMP player = (EntityPlayerMP) itl.next();
				double posX = player.posX;
				double posY = player.posY;
				double posZ = player.posZ;
				double dist = Math.sqrt(Math.pow(x-posX, 2)+Math.pow(y-posY, 2)+Math.pow(z-posZ, 2));
				if(dist < 16*8f){
					player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100,10));
				}
			}
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}
	
	private void populate(int x,int z){
		CostomInventory inv = new CostomInventory();
		int dim = worldObj.provider.dimensionId;
		Block popAbleBlock = ConfigurationManager.getPopulatable(dim);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < worldObj.getHeight(); k++) {
					if(toMine(worldObj.getBlock(i+x*16, k, j+z*16),popAbleBlock.getUnlocalizedName())){
						worldObj.setBlock(i+x*16, k, j+z*16, popAbleBlock);
					}
				}
			}
		}
		ChunkProviderServer cps = MinecraftServer.getServer().worldServerForDimension(dim).theChunkProviderServer;
		WorldServer wld = DimensionManager.getWorld(dim);
		Chunk chunk = cps.provideChunk(x, z);
		chunk.isTerrainPopulated = false;
		cps.populate(wld.getChunkProvider(), x, z);
		cps.recreateStructures(x, z);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < worldObj.getHeight(); k++) {
					Block block = worldObj.getBlock(i+x*16, k, j+z*16);
					ItemStack stack = null;
					if(toMine(worldObj.getBlock(i+x*16, k, j+z*16),popAbleBlock.getUnlocalizedName())){
						if(block.canSilkHarvest(worldObj, null, xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord))){
							stack = new ItemStack(block);
						}else{
							Item item = block.getItemDropped(1, new Random(), worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
							stack = new ItemStack(item);
						}
						if(stack != null)
							inv.addItemStack(1, stack);
					}
				}
			}
		}
		inv.Log();
		System.out.println("Chunk "+ x + " "+ z + " populated");
		System.out.println("");
		System.out.println("");
	}
	
	private boolean toMine(Block block,String popBlock){
		if(block instanceof BlockFluidBase)return false;
		if(block.getUnlocalizedName().equals(Blocks.water.getUnlocalizedName()))return false;
		if(block.getUnlocalizedName().equals(Blocks.lava.getUnlocalizedName()))return false;
		for (String entry : ConfigurationManager.multiblockAirBlocks) {
			if(block.getUnlocalizedName().equals(entry))return false;
		}
		if(block.getUnlocalizedName().equals(popBlock))return false;
		return true;
		
	}
	
}
