package net.crazymoder.mattercraft.event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.crazymoder.mattercraft.helper.inventory.CostomInventory;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EventBusSubscription {

	public EventBusSubscription() {}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(LivingDropsEvent event)
	{
	    if (event.entity instanceof EntityWither)
	    {
	    	Random r = new Random();
	    	if(r.nextInt(5) == 0){
	    		CostomInventory inv = new CostomInventory();
	    		inv.addItemStack(new ItemStack(BlockManager.iridiumOre));
	    		ItemStack card = new ItemStack(AdvancedItemManager.chunkMemoryCard);
	    		NBTTagCompound compound = new NBTTagCompound();
				inv.writeNBT(compound);
				card.setTagCompound(compound);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX,event.entity.posY, event.entity.posZ, card));
	    	}
	    }
	
	} 

}
