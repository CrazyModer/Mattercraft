package net.crazymoder.mattercraft.tileentity.generator;

import cofh.api.energy.EnergyStorage;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidTank;

public class GeneratorControllerTile extends TileEntity{
	private boolean init = true;
	private int a,b,y,x,z;
	private int direction;
	private GeneratorEnergyPortTile energyPortTile;
	private GeneratorFluidPortTile fluidPortTile1;
	private GeneratorFluidPortTile fluidPortTile2;
	
	public int energyStorageDisplay = 0;
	public int tank1Display = 0;
	public int tank2Display = 0;
	
	public int productionRate = 0;
	
	public FluidTank watertank = new FluidTank(2500000);
	public FluidTank plasmaTank = new FluidTank(250000);
	public EnergyStorage energyStorage = new EnergyStorage(2000000000,10000000);
	
	public GeneratorControllerTile(){
		a=b=y=x=z=0;
	}
	
	@Override
	public void updateEntity() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		markDirty();
		if(!worldObj.isRemote){
			if(init){
				init = false;
				direction = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
			}
			if(checkMbs()){
				System.out.println("MBS OK");
				energyPortTile.setMaster(this);
				fluidPortTile1.setMaster(this);
				fluidPortTile2.setMaster(this);
				if(energyStorage.getEnergyStored() + 10000000< energyStorage.getMaxEnergyStored() && watertank.getFluidAmount() >= 25000 && plasmaTank.getFluidAmount() >= 2500){
					productionRate = (int) (Math.min(watertank.getFluidAmount()/10f, plasmaTank.getFluidAmount())/100f);
					energyStorage.receiveEnergy(productionRate * 1000, false);
					watertank.drain(productionRate * 10, true);
					plasmaTank.drain(productionRate, true);
				}else{
					productionRate = 0;
				}
				energyStorageDisplay = energyStorage.getEnergyStored();
				tank1Display = watertank.getFluidAmount();
				tank2Display = plasmaTank.getFluidAmount();
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		NBTTagCompound tankCompaund1 = new NBTTagCompound();
		NBTTagCompound tankCompaund2 = new NBTTagCompound();
		NBTTagCompound tankCompaund3 = new NBTTagCompound();
		watertank.writeToNBT(tankCompaund1);
		plasmaTank.writeToNBT(tankCompaund2);
		energyStorage.writeToNBT(tankCompaund3);
		tag.setTag("tank1", tankCompaund1);
		tag.setTag("tank2", tankCompaund2);
		tag.setTag("tank3", tankCompaund3);
		super.writeToNBT(tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		NBTTagCompound tankCompaund1 = (NBTTagCompound) tag.getTag("tank1");
		NBTTagCompound tankCompaund2 = (NBTTagCompound) tag.getTag("tank2");
		NBTTagCompound tankCompaund3 = (NBTTagCompound) tag.getTag("tank3");
		watertank.readFromNBT(tankCompaund1);
		plasmaTank.readFromNBT(tankCompaund2);
		energyStorage.readFromNBT(tankCompaund3);
		super.readFromNBT(tag);
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tagCompound = new NBTTagCompound();
		tagCompound.setInteger("energy",energyStorageDisplay);
		tagCompound.setInteger("tank1",tank1Display);
		tagCompound.setInteger("tank2",tank2Display);
		tagCompound.setInteger("rate",productionRate);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, tagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tagCompound = pkt.func_148857_g();
		energyStorageDisplay = tagCompound.getInteger("energy");
		tank1Display = tagCompound.getInteger("tank1");
		tank2Display = tagCompound.getInteger("tank2");
		productionRate = tagCompound.getInteger("rate");
	}
	
	public boolean checkMbs(){
		b = y = 0;
		a = -1;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a += 2;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		b = 1;
		a = -2;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.waterInjector"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.waterInjector"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		b++;
		a = -2;
		if(!isBlock("tile.mtc.generatorFluidPort"))return false;
		if(!(worldObj.getTileEntity(x + xCoord, y + yCoord, z + zCoord) instanceof GeneratorFluidPortTile))return false;
		fluidPortTile1 = (GeneratorFluidPortTile) worldObj.getTileEntity(x + xCoord, y + yCoord, z + zCoord);
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.plasmaInjector"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorFluidPort"))return false;
		if(!(worldObj.getTileEntity(x + xCoord, y + yCoord, z + zCoord) instanceof GeneratorFluidPortTile))return false;
		fluidPortTile2 = (GeneratorFluidPortTile) worldObj.getTileEntity(x + xCoord, y + yCoord, z + zCoord);
		b++;
		a = -2;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.waterInjector"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.waterInjector"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a = -1;
		b++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorEnergyPort"))return false;
		if(!(worldObj.getTileEntity(x + xCoord, y + yCoord, z + zCoord) instanceof GeneratorEnergyPortTile))return false;
		energyPortTile = (GeneratorEnergyPortTile) worldObj.getTileEntity(x + xCoord, y + yCoord, z + zCoord);
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		for(y=1;y<16;y++){
			b=0;
			for(a=-1;a<2;a++)
				if(!isBlock("tile.mtc.generatorPlating"))return false;
			b=4;
			for(a=-1;a<2;a++)
				if(!isBlock("tile.mtc.generatorPlating"))return false;
			a=-2;
			for(b=1;b<4;b++)
				if(!isBlock("tile.mtc.generatorPlating"))return false;
			a=2;
			for(b=1;b<4;b++)
				if(!isBlock("tile.mtc.generatorPlating"))return false;
			a=-1;
			b=1;
			if(!isBlock("tile.mtc.heatSink"))return false;
			a++;
			if(!isBlock("tile.mtc.peltier"))return false;
			a++;
			if(!isBlock("tile.mtc.heatSink"))return false;
			a=-1;
			b++;
			if(!isBlock("tile.mtc.peltier"))return false;
			a++;
			if(!isBlock("tile.mtc.heatSink"))return false;
			a++;
			if(!isBlock("tile.mtc.peltier"))return false;
			a=-1;
			b++;
			if(!isBlock("tile.mtc.heatSink"))return false;
			a++;
			if(!isBlock("tile.mtc.peltier"))return false;
			a++;
			if(!isBlock("tile.mtc.heatSink"))return false;			
		}
		y=16;
		a=-1;
		b=1;
		if(!isBlock("tile.mtc.exhaustPipe"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.exhaustPipe"))return false;
		a=-1;
		b++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.exhaustPipe"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a=-1;
		b++;
		if(!isBlock("tile.mtc.exhaustPipe"))return false;
		a++;
		if(!isBlock("tile.mtc.generatorPlating"))return false;
		a++;
		if(!isBlock("tile.mtc.exhaustPipe"))return false;
		return true;
	}
	
	private boolean isBlock(String name){
		if(direction == 2){
			x = -a;
			z = b;
		}
		if(direction == 4){
			x = b;
			z = a;
		}
		if(direction == 5){
			x = -b;
			z = -a;
		}
		if(direction == 3){
			x = a;
			z = -b;
		}
		Block block = worldObj.getBlock(x + xCoord, y + yCoord, z + zCoord);
		//System.out.println(block.getUnlocalizedName());
		return(block.getUnlocalizedName().equals(name));
	}
}