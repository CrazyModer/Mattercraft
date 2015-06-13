package net.crazymoder.mattercraft.tileentity;

import com.sun.webkit.Utilities;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;

public class QuarryTile extends TileEntity{

	public QuarryTile() {
		
	}
	
	@Override
	public void updateEntity() { 
		int q = 1;
		int x = 0;
		int z = 0;
		x = (int)(xCoord/16f);
		if(xCoord < 0)x--;
		z = (int)(zCoord/16f);
		if(zCoord < 0)z--;
		System.out.println(x);
		int dim = worldObj.provider.dimensionId;
		if(!worldObj.isRemote && q == 1){
			int dia = 0;
			System.out.println("Stoner");
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					for (int k = 0; k < 64; k++) {
						if(worldObj.getBlock(i+x*16, k, j+z*16).equals(Blocks.diamond_ore))dia++;
					}
				}
			}
			System.out.println("Dia: "+dia);
		}
		if(!worldObj.isRemote && q == 1){
			System.out.println("Stoner");
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					for (int k = 0; k < 64; k++) {
						worldObj.setBlock(i+x*16, k, j+z*16, Blocks.stone);
					}
				}
			}
		}
		if(!worldObj.isRemote && q == 1){
			System.out.println("Populator");
			ChunkProviderServer cps = MinecraftServer.getServer().worldServerForDimension(dim).theChunkProviderServer;
			WorldServer wld = DimensionManager.getWorlds()[dim];
			Chunk chunk = cps.provideChunk(x, z);
			chunk.isTerrainPopulated = false;
			cps.populate(wld.getChunkProvider(), x, z);
			cps.recreateStructures(x, z);
		}
	}
}
