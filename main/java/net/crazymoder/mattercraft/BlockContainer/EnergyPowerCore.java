package net.crazymoder.mattercraft.blockcontainer;

import net.crazymoder.mattercraft.tileentity.EnergyPowerCoreTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EnergyPowerCore extends BlockContainer{

	public EnergyPowerCore(Material material) {
		super(material);
	}
	
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new EnergyPowerCoreTile();
	}
	
}
