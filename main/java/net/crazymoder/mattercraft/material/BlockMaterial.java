package net.crazymoder.mattercraft.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockMaterial extends Material{

	public BlockMaterial(MapColor p_i2116_1_) {
		super(p_i2116_1_);
	}
	
	public static Material matter = new BlockMaterial(MapColor.tntColor).setRequiresTool();
}
