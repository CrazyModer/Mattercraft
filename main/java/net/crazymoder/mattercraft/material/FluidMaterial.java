package net.crazymoder.mattercraft.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class FluidMaterial extends MaterialLiquid{

	public FluidMaterial() {
		super(MapColor.adobeColor);
		this.setReplaceable();
	}

}
