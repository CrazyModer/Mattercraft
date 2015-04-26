package net.crazymoder.mattercraft.tileentity.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class ReactorCoreTileRenderer extends TileEntitySpecialRenderer{

	@Override
	public void renderTileEntityAt(TileEntity core, double x, double y,double z, float scale) {
		System.out.println(x);
	}

}
