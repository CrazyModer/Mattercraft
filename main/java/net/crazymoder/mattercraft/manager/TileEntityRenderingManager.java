package net.crazymoder.mattercraft.manager;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.renderer.CryotheumAcceptorTileRenderer;

public class TileEntityRenderingManager {
	public TileEntityRenderingManager(){
		ClientRegistry.bindTileEntitySpecialRenderer(CryotheumAcceptorTile.class, new CryotheumAcceptorTileRenderer());
	}
}
