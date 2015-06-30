package net.crazymoder.mattercraft.tileentity;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.Callable;

import com.sun.webkit.Utilities;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.crazymoder.mattercraft.helper.inventory.CostomInventory;
import net.crazymoder.mattercraft.items.BasicItem;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.manager.ConfigurationManager;
import net.crazymoder.mattercraft.particels.CoreParticel;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
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
	int state,laststate = 0;
	int cooldown = 0;
	boolean populate = true;
	Block spetialBlock;
	Random r;
	Block popAbleBlock;
	boolean init = true;
	
	public ChunkRegistratorTile() {
		r = new Random();
	}
	
	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(!worldObj.isRemote){
			state = getState();
			if(init){
				init = false;
				x = (int) Math.floor(xCoord/16f);
				z = (int) Math.floor(zCoord/16f);
				dim = worldObj.provider.dimensionId;
				popAbleBlock = ConfigurationManager.getPopulatable(dim);
			}
			if(state > 0){
				cooldown++;
			}
			if(state != laststate)cooldown = 0;
			if(cooldown >= 300){
				populate();
				blind();
				worldObj.setBlock(xCoord, yCoord, zCoord,BlockManager.emptyChunkRegistrator);
				worldObj.setBlock(xCoord, yCoord+1, zCoord,Blocks.air);
				worldObj.setBlock(xCoord+1, yCoord+1, zCoord+1,Blocks.air);
				worldObj.setBlock(xCoord+1, yCoord+1, zCoord-1,Blocks.air);
				worldObj.setBlock(xCoord-1, yCoord+1, zCoord+1,Blocks.air);
				worldObj.setBlock(xCoord-1, yCoord+1, zCoord-1,Blocks.air);
				worldObj.setBlock(xCoord+1, yCoord, zCoord+1,Blocks.air);
				worldObj.setBlock(xCoord+1, yCoord, zCoord,Blocks.air);
				worldObj.setBlock(xCoord+1, yCoord, zCoord-1,Blocks.air);
				worldObj.setBlock(xCoord, yCoord, zCoord-1,Blocks.air);
				worldObj.setBlock(xCoord, yCoord, zCoord+1,Blocks.air);
				worldObj.setBlock(xCoord-1, yCoord, zCoord-1,Blocks.air);
				worldObj.setBlock(xCoord-1, yCoord, zCoord+1,Blocks.air);
				worldObj.setBlock(xCoord-1, yCoord, zCoord,Blocks.air);
			}
			laststate = state;
		}else{
			if(state > 0){
				float move1 = (float) r.nextGaussian()/40;
				float move2 = (float) r.nextGaussian()/50;
				float move3 = (float) r.nextGaussian()/40;
				Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(worldObj, xCoord+0.5f, yCoord+2f, zCoord+0.5f, move1*5, 0.2f+move2, move3*5, 5.0f));
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
	
	private int getState(){
		if(!worldObj.getBlock(xCoord-1, yCoord, zCoord).getUnlocalizedName().equals("tile.mtc.osmiumPlating"))return 0;
		if(!worldObj.getBlock(xCoord+1, yCoord, zCoord).getUnlocalizedName().equals("tile.mtc.osmiumPlating"))return 0;
		if(!worldObj.getBlock(xCoord, yCoord, zCoord-1).getUnlocalizedName().equals("tile.mtc.osmiumPlating"))return 0;
		if(!worldObj.getBlock(xCoord, yCoord, zCoord+1).getUnlocalizedName().equals("tile.mtc.osmiumPlating"))return 0;
		
		if(worldObj.getBlock(xCoord, yCoord+1, zCoord).getUnlocalizedName().equals("tile.thermalexpansion.tank")){
			IFluidHandler t = (IFluidHandler) worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
			FluidTankInfo info = t.getTankInfo(ForgeDirection.DOWN)[0];
			if(info.fluid != null && info.fluid.amount == 512000 && info.fluid.getUnlocalizedName().equals("fluid.mtc.ionizedPlasma"))return 1;
		}
		
		if(!worldObj.getBlock(xCoord-1, yCoord, zCoord-1).getUnlocalizedName().equals("tile.blockDiamond"))return 0;
		if(!worldObj.getBlock(xCoord+1, yCoord, zCoord-1).getUnlocalizedName().equals("tile.blockDiamond"))return 0;
		if(!worldObj.getBlock(xCoord-1, yCoord, zCoord+1).getUnlocalizedName().equals("tile.blockDiamond"))return 0;
		if(!worldObj.getBlock(xCoord+1, yCoord, zCoord+1).getUnlocalizedName().equals("tile.blockDiamond"))return 0;
		
		if(worldObj.getBlock(xCoord-1, yCoord+1, zCoord-1).getUnlocalizedName().equals("tile.thermalexpansion.tank")){
			IFluidHandler t = (IFluidHandler) worldObj.getTileEntity(xCoord-1, yCoord+1, zCoord-1);
			FluidTankInfo info = t.getTankInfo(ForgeDirection.DOWN)[0];
			if(!(info.fluid != null && info.fluid.amount == 512000 && info.fluid.getUnlocalizedName().equals("fluid.mtc.ionizedPlasma")))return 0;
		}else return 0;
		if(worldObj.getBlock(xCoord+1, yCoord+1, zCoord-1).getUnlocalizedName().equals("tile.thermalexpansion.tank")){
			IFluidHandler t = (IFluidHandler) worldObj.getTileEntity(xCoord+1, yCoord+1, zCoord-1);
			FluidTankInfo info = t.getTankInfo(ForgeDirection.DOWN)[0];
			if(!(info.fluid != null && info.fluid.amount == 512000 && info.fluid.getUnlocalizedName().equals("fluid.mtc.ionizedPlasma")))return 0;
		}else return 0;
		if(worldObj.getBlock(xCoord-1, yCoord+1, zCoord+1).getUnlocalizedName().equals("tile.thermalexpansion.tank")){
			IFluidHandler t = (IFluidHandler) worldObj.getTileEntity(xCoord-1, yCoord+1, zCoord+1);
			FluidTankInfo info = t.getTankInfo(ForgeDirection.DOWN)[0];
			if(!(info.fluid != null && info.fluid.amount == 512000 && info.fluid.getUnlocalizedName().equals("fluid.mtc.ionizedPlasma")))return 0;
		}else return 0;
		if(worldObj.getBlock(xCoord+1, yCoord+1, zCoord+1).getUnlocalizedName().equals("tile.thermalexpansion.tank")){
			IFluidHandler t = (IFluidHandler) worldObj.getTileEntity(xCoord+1, yCoord+1, zCoord+1);
			FluidTankInfo info = t.getTankInfo(ForgeDirection.DOWN)[0];
			if(!(info.fluid != null && info.fluid.amount == 512000 && info.fluid.getUnlocalizedName().equals("fluid.mtc.ionizedPlasma")))return 0;
		}else return 0;
		
		for (String name : ConfigurationManager.multiblockAirBlocks) {
			if(name.equals(worldObj.getBlock(xCoord, yCoord+1, zCoord).getUnlocalizedName()))return 0;
		}
		
		if(worldObj.getTileEntity(xCoord, yCoord+1, zCoord) != null)return 0;
		
		spetialBlock = worldObj.getBlock(xCoord, yCoord+1, zCoord);
		
		return 2;
	}
	
	private void populate(){
		CostomInventory inv = new CostomInventory();
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < worldObj.getHeight(); k++) {
					if(toMine(worldObj.getBlock(i+x*16, k, j+z*16),popAbleBlock.getUnlocalizedName())){
						worldObj.setBlock(i+x*16, k, j+z*16, popAbleBlock);
					}
				}
			}
		}
		if(state == 2){
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					for (int k = 0; k < worldObj.getHeight(); k++) {
						if(worldObj.getBlock(i+x*16, k, j+z*16).equals(popAbleBlock)){
							worldObj.setBlock(i+x*16, k, j+z*16, spetialBlock);
						}
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
		if(state == 2){
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					for (int k = 0; k < worldObj.getHeight(); k++) {
						if(worldObj.getBlock(i+x*16, k, j+z*16).equals(spetialBlock)){
							worldObj.setBlock(i+x*16, k, j+z*16, popAbleBlock);
						}
					}
				}
			}
		}
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < worldObj.getHeight(); k++) {
					Block block = worldObj.getBlock(i+x*16, k, j+z*16);
					ItemStack stack = null;
					if(toMine(worldObj.getBlock(i+x*16, k, j+z*16),popAbleBlock.getUnlocalizedName())){
						int meta = worldObj.getBlockMetadata(i+x*16, k, j+z*16);
						if(block.canSilkHarvest(worldObj, null, xCoord, yCoord, zCoord, worldObj.getBlockMetadata(xCoord, yCoord, zCoord))){
							stack = new ItemStack(block,1,meta);
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
		ItemStack card = new ItemStack(AdvancedItemManager.chunkMemoryCard);
		NBTTagCompound compound = new NBTTagCompound();
		inv.writeNBT(compound);
		card.setTagCompound(compound);
		EntityItem entityItem = new EntityItem(worldObj, xCoord, yCoord+2, zCoord, card);
		worldObj.spawnEntityInWorld(entityItem);
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
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tagCompound = new NBTTagCompound();
		tagCompound.setInteger("state", state);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tagCompound = pkt.func_148857_g();
		state = tagCompound.getInteger("state");
	}
	
}
