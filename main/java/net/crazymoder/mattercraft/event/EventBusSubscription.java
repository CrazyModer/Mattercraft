package net.crazymoder.mattercraft.event;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.crazymoder.mattercraft.helper.inventory.CostomInventory;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class EventBusSubscription {

	public EventBusSubscription() {}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(LivingDropsEvent event)
	{
		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem().equals(AdvancedItemManager.soulCollector) && event.drops.size() > 0) {
				Entity e = event.source.getEntity();
				System.out.println(event.entityLiving.getClass().getName());
				int plasma = 1000;
				int cooldown = 1;
				String name = "Unknown";
				if(event.entityLiving.getClass().getName().equals("net.minecraft.entity.monster.EntityZombie")){
					plasma = 100;
					name = "Zombie";
				}else
				if(event.entityLiving.getClass().getName().equals("net.minecraft.entity.boss.EntityWither")){
					cooldown = 100;
					plasma = 20000;
					name = "Wither";
				}else
				if(event.entityLiving.getClass().getName().equals("net.minecraft.entity.monster.EntityEnderman")){
					cooldown = 5;
					plasma = 2000;
					name = "Enderman";
				}
				CostomInventory inv = new CostomInventory();
				for (EntityItem item : event.drops) {
					inv.addItemStack(item.getEntityItem());
				}
				ItemStack drop = new ItemStack(AdvancedItemManager.mobSoul);
				NBTTagCompound tag = new NBTTagCompound();
				tag.setString("mobname", name);
				tag.setInteger("plasma", plasma);
				tag.setInteger("cooldown", cooldown);
				inv.writeNBT(tag);
				drop.stackTagCompound = tag;
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX,event.entity.posY, event.entity.posZ, drop));
			}
		}
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
