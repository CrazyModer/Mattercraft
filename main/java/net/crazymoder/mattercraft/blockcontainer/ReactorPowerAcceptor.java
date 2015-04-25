package net.crazymoder.mattercraft.blockcontainer;

import java.util.Random;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import net.crazymoder.mattercraft.tileentity.ReactorPowerAcceptorTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ReactorPowerAcceptor extends BlockContainer{
	
	public ReactorPowerAcceptor() {
		super(Material.iron);
	}
	
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new ReactorPowerAcceptorTile();
	}
}
