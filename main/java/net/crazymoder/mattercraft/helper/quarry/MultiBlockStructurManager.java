package net.crazymoder.mattercraft.helper.quarry;

import java.util.ArrayList;
import java.util.List;

import scala.reflect.internal.Trees.This;
import net.crazymoder.mattercraft.manager.ConfigurationManager;
import net.crazymoder.mattercraft.tileentity.ItemProviderTile;
import net.crazymoder.mattercraft.tileentity.MemoryCardReaderTile;
import net.crazymoder.mattercraft.tileentity.QuarryPowerAcceptorTile;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MultiBlockStructurManager {
	public ItemProviderTile itemProviderTile;
	public QuarryPowerAcceptorTile powerAcceptorTile;
	public List<MemoryCardReaderTile> cardReaders;
	private World w;
	private int xC,yC,zC;
	private int x,y,z;
	private final int[] cVal = {3,6,8,9,10,11,12,12,13,13,13,14,14,14,14,14,14,14,13,13,13,12,12,11,10,9,8,6,3};
	private final int[][][] cardCords = {
			{
				{0,11},
				{8,8},
				{11,0},
				{8,-8},
				{0,-11},
				{-8,-8},
				{-11,0},
				{-8,8}
			},{
				{4,10},
				{-4,10},
				{-4,-10},
				{4,-10},
				{10,4},
				{-10,4},
				{-10,-4},
				{10,-4}
			},{
				{11,2},
				{-11,2},
				{-11,-2},
				{11,-2},
				{2,11},
				{-2,11},
				{-2,-11},
				{2,-11},
				{9,6},
				{-9,6},
				{-9,-6},
				{9,-6},
				{6,9},
				{-6,9},
				{-6,-9},
				{6,-9}
			}
	};
	private final String buildingBlockName= "tile.mtc.groundPlating";
	private int t1c, t2c;

		private boolean checkAir(){
			boolean air = false;
				for (String entry : ConfigurationManager.multiblockAirBlocks) {
					if(isBlock(entry))air = true;
				}
			return air;
		}
		
		private boolean isBlock(String name){
			Block block = w.getBlock(x + xC, y + yC, z + zC);
			return(block.getUnlocalizedName().equals(name));
		}
		
		private TileEntity getTile(){
			return(w.getTileEntity(x + xC, y + yC, z + zC));
		}
	public void init(World w_,int x_,int y_,int z_){
		w = w_;
		xC = x_;
		yC = y_;
		zC = z_;
		x = 0;
		y = 0;
		z = 0;
		cardReaders = new ArrayList<MemoryCardReaderTile>();
	}
	
	
	//-1 BaseERROR -2 AreaERROR -3 ReaderERROR 0 Tire ERROR 1-3 Tier
	public int checkMBS(boolean air){
		if(!checkBase())return -1;
		if(air && !checkArea())return -2;
		int tier = checkTier();
		if(tier == 0)return 0;
		if(!checkCardReaders(tier))return -3;
		return tier;
	}
	
	private boolean checkCardReaders(int tier){
		cardReaders.clear();
		for (int i = 0; i < cardCords[0].length; i++) {
			if(!isCardReader(cardCords[0][i][0], cardCords[0][i][1]))return false;
		}
		if(tier > 1){
			for (int i = 0; i < cardCords[1].length; i++) {
				if(!isCardReader(cardCords[1][i][0], cardCords[1][i][1]))return false;
			}
			if(tier > 2){
				for (int i = 0; i < cardCords[2].length; i++) {
					if(!isCardReader(cardCords[2][i][0], cardCords[2][i][1]))return false;
				}
			}
		}
		return true;
	}
	
	private boolean isCardReader(int x , int z){
		if(w.getBlock(x + xC, y + yC, z + zC).getUnlocalizedName().equals("tile.mtc.memoryCardReader")){
			cardReaders.add((MemoryCardReaderTile) w.getTileEntity(x + xC, y + yC, z + zC));
			return true;
		}
		return false;
	}
	
	private boolean checkBase(){
		x = 0;
		y =-1;
		z = 0;
		t1c = 0;
		t2c = 0;
		if(!checkTile())return false;
		x = -1;
		if(!checkTile())return false;
		x = 1;
		if(!checkTile())return false;
		z = -1; x = 0;
		if(!checkTile())return false;
		z = 1;
		if(!checkTile())return false;
		return (t1c == 1 && t2c == 1);
	}
	
	private int checkTier(){
		y = -1;
		String blockName =   w.getBlock(1 + xC,yC -1,1 + zC).getUnlocalizedName();
		if(!blockName.equals(w.getBlock(xC - 1,yC -1,1 + zC).getUnlocalizedName()))return 0;
		if(!blockName.equals(w.getBlock(1 + xC,yC -1,zC - 1).getUnlocalizedName()))return 0;
		if(!blockName.equals(w.getBlock(xC - 1,yC -1,zC - 1).getUnlocalizedName()))return 0;
		if(blockName.equals("tile.mtc.osmiumPlating"))return 1;
		if(blockName.equals("tile.mtc.iridiumPalting"))return 2;
		if(blockName.equals("tile.mtc.reinforcedPlating"))return 3;
		return 0;
	}
	
	private boolean checkTile(){
		if(!isBlock(buildingBlockName)){
			if(isBlock("tile.mtc.itemProvider")){
				itemProviderTile = (ItemProviderTile) getTile();
				t1c++;
			}else if(isBlock("tile.mtc.quarryPowerAcceptor")){
				powerAcceptorTile = (QuarryPowerAcceptorTile) getTile();
				t2c++;
			}else return false;
		}
		return true;
	}
	
	private boolean checkArea(){
		for (int x_ = 0; x_ <= 28; x_++) {
			x = x_ -14;
			for (z = 0-cVal[x_]; z <= cVal[x_]; z++) {
				for (y = 0; y < 13; y++) {
					if(x != 0 || y != 0 || z != 0){
						if(!checkAir())return false;
					}
				}
			}
		}
		return true;
	}
	
	
	
}
