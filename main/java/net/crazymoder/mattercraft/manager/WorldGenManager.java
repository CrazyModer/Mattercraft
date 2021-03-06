package net.crazymoder.mattercraft.manager;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenManager implements IWorldGenerator {
	
	public WorldGenManager(){
		
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
	}

	private void generateEnd(World world, Random random, int x, int z) {
	}

	private void generateSurface(World world, Random random, int x, int z) {
		generateBlock(BlockManager.osmiumOre, world, random, x, z, 10, 10, 2);
		generateIridium(world, x, z);
	}

	private void generateNether(World world, Random random, int x, int z) {
	}
	
	private void generateBlock(Block block,World world,Random random,int x,int z,int maxY,int size,int rate){
		for(int k = 0; k<= random.nextInt(rate*2);k++){
			int firstBlockXCoord = x + random.nextInt(16);
	    	int firstBlockYCoord = random.nextInt(maxY);
	    	int firstBlockZCoord = z + random.nextInt(16);
			new WorldGenMinable(block, size).generate(world, random, firstBlockXCoord, firstBlockYCoord,firstBlockZCoord);	
		}
	}
	private void generateIridium(World world,int x,int z){
		Random random = new Random();
		int iter = 500;
		int rate = 1 + random.nextInt(4);
		while (iter > 0){
			iter--;
			int firstBlockXCoord = x + random.nextInt(16);
	    	int firstBlockYCoord = random.nextInt(16);
	    	int firstBlockZCoord = z + random.nextInt(16);
	    	Block b = world.getBlock(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	    	if(b == BlockManager.osmiumPlating){
	    		rate--;
	    		world.setBlock(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord, BlockManager.iridiumOre);
	    	}
	    	if(rate == 0)iter = 0;
		}
	}
}
