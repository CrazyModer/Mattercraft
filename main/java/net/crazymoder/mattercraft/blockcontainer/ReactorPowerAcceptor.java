package net.crazymoder.mattercraft.blockcontainer;

import java.util.Random;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import net.crazymoder.mattercraft.tileentity.ReactorPowerAcceptorTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
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
	
	public IIcon[] icons = new IIcon[6];

	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	    	if(i == 0){
	    		//bottom
	    		this.icons[i] = reg.registerIcon(this.textureName + "_B");
	    	}else if(i == 1){
	    		//top
	    		this.icons[i] = reg.registerIcon(this.textureName + "_T");
	    	}else{
	    		//side
	    		this.icons[i] = reg.registerIcon(this.textureName + "_S");
	    	}
	    }
	}

	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}
}
