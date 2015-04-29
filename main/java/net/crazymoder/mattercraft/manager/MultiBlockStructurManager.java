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
		y = -1;
		for ( x=-1; x <= 1; x++) {
			for ( z=-12; z <= 12; z++) {
				if(!isBlock("tile.mtc.reinforcedPlating"))return false;
			}
		}
		y = -1;
		for ( z=-1; z <= 1; z++) {
			for ( x=-12; x <= 12; x++) {
				if(!isBlock("tile.mtc.reinforcedPlating"))return false;
			}
		}
		y = -1;
		for ( z=-3; z <= 3; z++) {
			for ( x=-3; x <= 3; x++) {
				if(!isBlock("tile.mtc.reinforcedPlating"))return false;
			}
		}
		y = -1;
		x = -2;
		z = -4;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		y = -1;
		x = -4;
		z = -2;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		x = 4;
		z = 2;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		x = 2;
		z = 4;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		x = -2;
		z = 4;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		x = 2;
		z = -4;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		z = -2;
		x = 4;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		z = 2;
		x = -4;
		if(!isBlock("tile.mtc.reinforcedPlating"))return false;
		y = 0;
		z = -1;
		x = -1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 1;
		x = 1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;		
		z = -1;
		x = 1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 1;
		x = -1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 2;
		x = 0;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = -2;
		x = 0;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 0;
		x = 2;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 0;
		x = -2;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 3;
		x = -1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = -3;
		x = -1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 3;
		x = 1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = -3;
		x = 1;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = -1;
		x = -3;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 1;
		x = -3;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 1;
		x = 3;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = -1;
		x = 3;
		if(!isBlock("tile.mtc.osmiumPlating"))return false;
		z = 0;
		x = 4;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = 0;
		x = -4;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = 4;
		x = 0;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = -4;
		x = 0;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = 2;
		x = 2;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = -2;
		x = 2;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = 2;
		x = -2;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		z = -2;
		x = -2;
		if(!isBlock("tile.mtc.forceFieldEmitter"))return false;
		
		int xa = -5;
		int za = 0;
		  
		for (int i = 0; i < 5; i++) {
			xa++;
			za--;
			x = xa;
			z = za;
			for (int j = 0; j < 5; j++) {
				x++;
				z++;
				if(!isBlock("tile.mtc.iridiumPalting"))return false;
			}
		}

		y = 1;
		z = 1;
		x = 1;
		if(!isBlock("tile.mtc.wormHoleStabilizer"))return false;
		z = -1;
		x = 1;
		if(!isBlock("tile.mtc.wormHoleStabilizer"))return false;
		z = 1;
		x = -1;
		if(!isBlock("tile.mtc.wormHoleStabilizer"))return false;
		z = -1;
		x = -1;
		if(!isBlock("tile.mtc.wormHoleStabilizer"))return false;
		z = 1;
		x = 0;
		if(!isBlock("tile.mtc.iridiumPalting"))return false;
		z = 0;
		x = 0;
		if(!isBlock("tile.mtc.iridiumPalting"))return false;
		z = -1;
		x = 0;
		if(!isBlock("tile.mtc.iridiumPalting"))return false;
		z = 0;
		x = 1;
		if(!isBlock("tile.mtc.iridiumPalting"))return false;
		z = 0;
		x = -1;
		if(!isBlock("tile.mtc.iridiumPalting"))return false;
		y = 2;
		z = 0;
		x = 0;
		if(!isBlock("tile.mtc.plasmaExtractor"))return false;
		
		z = 10;
		x = 0;
		for ( y= 0; y <= 12; y++) {
		   if(!isBlock("tile.mtc.stabilizerPillar"))return false;
		}
		z = -10;
		x = 0;
		for ( y= 0; y <= 12; y++) {
		   if(!isBlock("tile.mtc.stabilizerPillar"))return false;
		}
		z = 0;
		x = 10;
		for ( y= 0; y <= 12; y++) {
		   if(!isBlock("tile.mtc.stabilizerPillar"))return false;
		}
		z = 0;
		x = -10;
		for ( y= 0; y <= 12; y++) {
		   if(!isBlock("tile.mtc.stabilizerPillar"))return false;
		}
		y = 13;
		x = 10;
		z = 0;
		 if(!isBlock("tile.mtc.stabilizer"))return false;
		y = 13;
		x = -10;
		z = 0;
		 if(!isBlock("tile.mtc.stabilizer"))return false;
		y = 13;
		x = 0;
		z = 10;
		 if(!isBlock("tile.mtc.stabilizer"))return false;
		y = 13;
		x = 0;
		z = -10;
		 if(!isBlock("tile.mtc.stabilizer"))return false;

		
		
		return true;
	}
	//
	private static boolean isBlock(String name){
		Block block = w.getBlock(x + xC, y + yC, z + zC);
		return(block.getUnlocalizedName().equals(name));
	}
}
