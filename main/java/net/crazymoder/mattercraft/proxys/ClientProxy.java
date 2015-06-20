package net.crazymoder.mattercraft.proxys;

import net.crazymoder.mattercraft.helper.reactorcore.ParticelRenderer;
import net.crazymoder.mattercraft.manager.TileRenderingManager;
import net.minecraft.world.World;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{
	
	private ParticelRenderer particelRenderer;
	
	public void preInit(FMLPreInitializationEvent e){
		super.preInit(e);
		TileRenderingManager tileRenderingManager = new TileRenderingManager();
	}
	
	public void init(FMLInitializationEvent e){
		super.init(e);
	}
	
	public void postInit(FMLPostInitializationEvent e){
		super.postInit(e);
		particelRenderer = new ParticelRenderer();
	}
	
	public void render(World w,float x,float y,float z){
		particelRenderer.render(w, x, y, z);
	}
}
