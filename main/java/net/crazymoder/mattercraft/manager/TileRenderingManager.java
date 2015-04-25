package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.crazymoder.mattercraft.tileentity.renderer.ReactorTermianlTileRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class TileRenderingManager {
	public TileRenderingManager(){
		ClientRegistry.bindTileEntitySpecialRenderer(ReactorTerminalTile.class, new ReactorTermianlTileRenderer());
	}
}
