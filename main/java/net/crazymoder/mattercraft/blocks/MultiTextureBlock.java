package net.crazymoder.mattercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class MultiTextureBlock extends Block{
	public IIcon[] icons = new IIcon[6];
	
	public MultiTextureBlock(Material arg0) {
		super(arg0);
	}

	@Override
	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	        this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
	    }
	}
	
	
	@Override
	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}
}
