package net.crazymoder.mattercraft.helper.reactorcore;

import java.util.Random;

import net.crazymoder.mattercraft.particels.CoreParticel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class ParticelRenderer {
	public Random rnd;
	public ParticelRenderer(){
		rnd = new Random();
	}
	
	public void render(World w,float x,float y,float z){
		x+=0.5f;
		z+=0.5f;
		float move1 = (float) rnd.nextGaussian()/30;
		float move2 = (float) rnd.nextGaussian()/50;
		float move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x+4, y+1, z, 0.0f+move1, 0.2f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x, y+1, z+4, 0.0f+move1, 0.2f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x-4, y+1, z, 0.0f+move1, 0.2f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x, y+1, z-4, 0.0f+move1, 0.2f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x+2, y+1, z+2, 0.0f+move1, 0.14f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x+2, y+1, z-2, 0.0f+move1, 0.14f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x-2, y+1, z+2, 0.0f+move1, 0.14f+move2, 0.0f+move3, 3.0f));
		move1 = (float) rnd.nextGaussian()/30;
		move2 = (float) rnd.nextGaussian()/50;
		move3 = (float) rnd.nextGaussian()/30;
		Minecraft.getMinecraft().effectRenderer.addEffect(new CoreParticel(w, x-2, y+1, z-2, 0.0f+move1, 0.14f+move2, 0.0f+move3, 3.0f));
	}
}
