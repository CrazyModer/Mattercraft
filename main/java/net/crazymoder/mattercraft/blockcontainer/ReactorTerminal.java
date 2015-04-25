package net.crazymoder.mattercraft.blockcontainer;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ReactorTerminal extends BlockContainer{

	public ReactorTerminal() {
		super(Material.iron);
	}

	@Override
	    public boolean isOpaqueCube(){
	        return false;
	    }

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new ReactorTerminalTile();
	}
}
