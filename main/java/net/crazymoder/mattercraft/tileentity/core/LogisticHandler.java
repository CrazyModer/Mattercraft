package net.crazymoder.mattercraft.tileentity.core;

import net.crazymoder.mattercraft.blockcontainer.CryotheumAcceptor;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.HeatedCryotheumEjectorTile;
import net.crazymoder.mattercraft.tileentity.HydrogenAcceptorTile;
import net.crazymoder.mattercraft.tileentity.LiquidMatterAcceptorTile;
import net.crazymoder.mattercraft.tileentity.PlasmaEjectorTile;
import net.crazymoder.mattercraft.tileentity.ReactorPowerAcceptorTile;
import net.crazymoder.mattercraft.tileentity.StabilizerAcceptorTile;
import net.crazymoder.mattercraft.tileentity.ToxicWasteEjectorTile;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class LogisticHandler {
	public int cryotheum_a = 0;
	public int hydrogen_a = 0;
	public int stabilizer_a = 0;
	public int liquidMatter_a = 0;
	public int heatedCryotheum_a = 0;
	public int toxicWaste_a = 0;
	public int plasma_a = 0;
	public int energy_a = 0;
	public int matter_a = 0;
	public int antiMatter_a = 0;
	
	public static int cryotheum_m = 1000000;
	public static int hydrogen_m = 10000000;
	public static int stabilizer_m = 1000000;
	public static int liquidMatter_m = 500000;
	public static int heatedCryotheum_m = 1000000;
	public static int toxicWaste_m = 1000000;
	public static int plasma_m =640000000;
	public static int energy_m = 1000000000;
	public static int matter_m = 100000;
	public static int antiMatter_m = 100000;
	
	private CryotheumAcceptorTile cryotheumAcceptorTile;
	private HydrogenAcceptorTile hydrogenAcceptorTile;
	private StabilizerAcceptorTile stabilizerAcceptorTile;
	private LiquidMatterAcceptorTile liquidMatterAcceptorTile;
	private ReactorPowerAcceptorTile reactorPowerAcceptorTile;
	private HeatedCryotheumEjectorTile heatedCryotheumEjectorTile;
	private ToxicWasteEjectorTile toxicWasteEjectorTile;
	private PlasmaEjectorTile plasmaEjectorTile;
	
	public LogisticHandler(){}
	public boolean checkLogistic(ReactorCoreTile tile){
		if(!checkexisting()){
			override(tile);
			if(!checkexisting())return false;
		}
		move();
		return true;
	}
	
	private void move(){
		//energy
		energy_a += reactorPowerAcceptorTile.energyStorage.extractEnergy(energy_m - energy_a, false);
		//import
		if(cryotheumAcceptorTile.tank.getFluidAmount() > 0)
		cryotheum_a += cryotheumAcceptorTile.tank.drain(cryotheum_m - cryotheum_a, true).amount;
		if(hydrogenAcceptorTile.tank.getFluidAmount() > 0)
		hydrogen_a += hydrogenAcceptorTile.tank.drain(hydrogen_m - hydrogen_a, true).amount;
		if(stabilizerAcceptorTile.tank.getFluidAmount() > 0)
		stabilizer_a += stabilizerAcceptorTile.tank.drain(stabilizer_m - stabilizer_a, true).amount;
		if(liquidMatterAcceptorTile.tank.getFluidAmount() > 0)
		liquidMatter_a += liquidMatterAcceptorTile.tank.drain(liquidMatter_m - liquidMatter_a, true).amount;
		//export
		plasma_a -= plasmaEjectorTile.tank.fill(new FluidStack(new Fluid("mtc.ionizedPlasma"),plasma_a), true);
		heatedCryotheum_a -= heatedCryotheumEjectorTile.tank.fill(new FluidStack(new Fluid("mtc.heatedCryotheum"),heatedCryotheum_a), true);
		toxicWaste_a -= toxicWasteEjectorTile.tank.fill(new FluidStack(new Fluid("mtc.toxicWaste"),toxicWaste_a), true);
	}
	
	private boolean checkexisting(){
		if(cryotheumAcceptorTile == null)return false;
		if(hydrogenAcceptorTile == null)return false;
		if(stabilizerAcceptorTile == null)return false;
		if(liquidMatterAcceptorTile == null)return false;
		if(reactorPowerAcceptorTile == null)return false;
		if(heatedCryotheumEjectorTile == null)return false;
		if(toxicWasteEjectorTile == null)return false;
		if(plasmaEjectorTile == null)return false;
		if(cryotheumAcceptorTile.isInvalid())return false;
		if(hydrogenAcceptorTile.isInvalid())return false;
		if(stabilizerAcceptorTile.isInvalid())return false;
		if(liquidMatterAcceptorTile.isInvalid())return false;
		if(reactorPowerAcceptorTile.isInvalid())return false;
		if(heatedCryotheumEjectorTile.isInvalid())return false;
		if(toxicWasteEjectorTile.isInvalid())return false;
		if(plasmaEjectorTile.isInvalid())return false;
		return true;
	}
	
	private void override(ReactorCoreTile tile){
		int y = tile.yCoord - 1;
		int x,z;
		
		x = tile.xCoord + 5;
		z = tile.zCoord + 2;
		for (int i = x; i < x+8; i++) {
			settile(i, y, z,tile);
		}
		x = tile.xCoord + 5;
		z = tile.zCoord - 2;
		for (int i = x; i < x+8; i++) {
			settile(i, y, z,tile);
		}
		x = tile.xCoord - 5;
		z = tile.zCoord - 2;
		for (int i = x; i > x-8; i--) {
			settile(i, y, z,tile);
		}
		x = tile.xCoord - 5;
		z = tile.zCoord + 2;
		for (int i = x; i > x-8; i--) {
			settile(i, y, z,tile);
		}
		z = tile.zCoord + 5;
		x = tile.xCoord + 2;
		for (int i = z; i < z+8; i++) {
			settile(x, y, i,tile);
		}
		z = tile.zCoord + 5;
		x = tile.xCoord - 2;
		for (int i = z; i < z+8; i++) {
			settile(x, y, i,tile);
		}
		z = tile.zCoord - 5;
		x = tile.xCoord - 2;
		for (int i = z; i > z-8; i--) {
			settile(x, y, i,tile);
		}
		z = tile.zCoord - 5;
		x = tile.xCoord + 2;
		for (int i = z; i > z-8; i--) {
			settile(x, y, i,tile);
		}
		x = tile.xCoord;
		z = tile.zCoord;
		y = tile.yCoord + 24;
		TileEntity check = tile.getWorldObj().getTileEntity(x, y, z);
		if(check instanceof LiquidMatterAcceptorTile)liquidMatterAcceptorTile = (LiquidMatterAcceptorTile) check;
	}
	private void settile(int x,int y,int z,ReactorCoreTile tile){
		TileEntity check = tile.getWorldObj().getTileEntity(x, y, z);
		if(check != null){
			if(check instanceof CryotheumAcceptorTile)cryotheumAcceptorTile = (CryotheumAcceptorTile) check;
			if(check instanceof HydrogenAcceptorTile)hydrogenAcceptorTile = (HydrogenAcceptorTile) check;
			if(check instanceof StabilizerAcceptorTile)stabilizerAcceptorTile = (StabilizerAcceptorTile) check;
			if(check instanceof ReactorPowerAcceptorTile)reactorPowerAcceptorTile = (ReactorPowerAcceptorTile) check;
			if(check instanceof HeatedCryotheumEjectorTile)heatedCryotheumEjectorTile = (HeatedCryotheumEjectorTile) check;
			if(check instanceof ToxicWasteEjectorTile)toxicWasteEjectorTile = (ToxicWasteEjectorTile) check;
			if(check instanceof PlasmaEjectorTile)plasmaEjectorTile = (PlasmaEjectorTile) check;
		}
	}
	
	public void writeNBT(NBTTagCompound tag){
		tag.setInteger("cryotheum_a", cryotheum_a);
		tag.setInteger("hydrogen_a", hydrogen_a);
		tag.setInteger("stabilizer_a", stabilizer_a);
		tag.setInteger("liquidMatter_a", liquidMatter_a);
		tag.setInteger("heatedCryotheum_a", heatedCryotheum_a);
		tag.setInteger("toxicWaste_a", toxicWaste_a);
		tag.setInteger("plasma_a", plasma_a);
		tag.setInteger("energy_a", energy_a);
		tag.setInteger("matter_a", matter_a);
		tag.setInteger("antiMatter_a", antiMatter_a);
	}
	public void readNBT(NBTTagCompound tag){
		cryotheum_a = tag.getInteger("cryotheum_a");
		hydrogen_a = tag.getInteger("hydrogen_a");
		stabilizer_a = tag.getInteger("stabilizer_a");
		liquidMatter_a = tag.getInteger("liquidMatter_a");
		heatedCryotheum_a = tag.getInteger("heatedCryotheum_a");
		toxicWaste_a = tag.getInteger("toxicWaste_a");
		plasma_a = tag.getInteger("plasma_a");
		energy_a = tag.getInteger("energy_a");
		matter_a = tag.getInteger("matter_a");
		antiMatter_a = tag.getInteger("antiMatter_a");
	}
}
