package net.crazymoder.mattercraft.items.advanced;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.Set;

import net.crazymoder.mattercraft.helper.CostomInventory;
import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ChunkMemoryCard extends Item{
	public ChunkMemoryCard(String unlocalizedName){
		this.setCreativeTab(CreativeTabManager.tabItems);
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(1);
		 
	}
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		if(!itemStack.hasTagCompound())
			itemStack.stackTagCompound = new NBTTagCompound();
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, final EntityPlayer entityPlayer) {
		if(itemStack.hasTagCompound()){
			CostomInventory inv = new CostomInventory();
			inv.readNBT(itemStack.stackTagCompound);
			entityPlayer.addChatMessage(new ChatComponentText("Scanned Blocks:"));
			inv.getMap().forEach(new BiConsumer<ItemStack, Integer>() {
				@Override
				public void accept(ItemStack stack, Integer amount) {
					entityPlayer.addChatMessage(new ChatComponentText(stack.getDisplayName()+": "+amount));
				}
			});
			entityPlayer.addChatMessage(new ChatComponentText(""));
		}
		return itemStack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
		if(stack.hasTagCompound()){
			CostomInventory inv = new CostomInventory();
			inv.readNBT(stack.stackTagCompound);
			list.add("Items: "+inv.getItemCount());
			list.add("Types: "+inv.getTypeCount());
			list.add("Stacks: "+inv.getStackCount());
		}
	}
}
