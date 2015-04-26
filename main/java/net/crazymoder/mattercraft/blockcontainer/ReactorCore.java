package net.crazymoder.mattercraft.blockcontainer;

import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ReactorCore extends BlockContainer{

	public ReactorCore() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int arg1) {
		return new ReactorCoreTile();
	}

}
