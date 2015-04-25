package net.crazymoder.mattercraft.manager;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketManager {
	public static BucketManager INSTANCE = new BucketManager();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    private BucketManager() {
    }
    
    public void onBucketFill(FillBucketEvent event) {

            ItemStack result = fillCustomBucket(event.world, event.target);

            if (result == null)
                    return;

            event.result = result;
            event.setResult(Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {

            Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

            Item bucket = buckets.get(block);
            if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
                    world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
                    return new ItemStack(bucket);
            } else
                    return null;

    }
}
