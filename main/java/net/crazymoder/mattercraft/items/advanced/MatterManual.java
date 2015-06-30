package net.crazymoder.mattercraft.items.advanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.Set;

import net.crazymoder.mattercraft.Mattercraft;
import net.crazymoder.mattercraft.helper.inventory.CostomInventory;
import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.crazymoder.mattercraft.tileentity.ItemProviderTile;
import net.crazymoder.mattercraft.tileentity.QuarryTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class MatterManual extends Item{
	public MatterManual(String unlocalizedName){
		this.setCreativeTab(CreativeTabManager.tabItems);
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(1);
		 
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, final EntityPlayer player) {
		player.openGui(Mattercraft.INSTANCE, 4, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return itemStack;
	}
}
