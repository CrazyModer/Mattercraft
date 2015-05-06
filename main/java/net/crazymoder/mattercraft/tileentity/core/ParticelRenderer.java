package net.crazymoder.mattercraft.tileentity.core;

import net.minecraft.world.World;

public class ParticelRenderer {
	private ReactorCoreTile tile;
	private int x,y,z;
	private World w;
	private boolean init;
	
	public ParticelRenderer(ReactorCoreTile tile){
		this.tile = tile;
		init = true;
	}
	public void render(){
		if(init){
			init = false;
			x = tile.xCoord;
			y = tile.yCoord;
			z = tile.zCoord;
			w = tile.getWorldObj();
		}
		//w.spawnParticle("spell", x, y-5, z, 0.1f, 0f, 0.1f);
	}
}
