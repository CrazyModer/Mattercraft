package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.tileentity.ReactorCoreTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.crazymoder.mattercraft.tileentity.renderer.ReactorCoreTileRenderer;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileRenderingManager {
	public TileRenderingManager(){
		ClientRegistry.bindTileEntitySpecialRenderer(ReactorCoreTile.class, new ReactorCoreTileRenderer());
	}
}
