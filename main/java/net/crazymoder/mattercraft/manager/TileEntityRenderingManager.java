package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.crazymoder.mattercraft.tileentity.renderer.ReactorTermianlTileRenderer;

public class TileEntityRenderingManager {
	public TileEntityRenderingManager(){
		ClientRegistry.bindTileEntitySpecialRenderer(ReactorTerminalTile.class, new ReactorTermianlTileRenderer());
	}
}
