package net.crazymoder.mattercraft.manager;

import scala.reflect.internal.Trees.This;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class MultiBlockStructurManager {
	private static World w;
	private static int xC,yC,zC;
	private static int x,y,z;//Offsetwerte
	public static void init(World w_,int x_,int y_,int z_){
		w = w_;
		xC = x_;
		yC = y_;
		zC = z_;
		x = 0;
		y = 0;
		z = 0;
	}
	//if(!isBlock("tile.mtc.groundPlating"))return false; CheckBlock
	//x y z Offset cords
	
	public static boolean checkReactorCoreMBS(){
		y = -2;
		for ( x=-13; x <= 13; x++) {
			for ( z=-13; z <= 13; z++) {
				if(!isBlock("tile.mtc.groundPlating"))return false;
			}
		}
		
		return true;
	}
	//
	private static boolean isBlock(String name){
		Block block = w.getBlock(x + xC, y + yC, z + zC);
		return(block.getUnlocalizedName().equals(name));
	}
}
