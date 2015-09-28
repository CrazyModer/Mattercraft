package net.crazymoder.mattercraft.items.advanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.Set;

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

public class MobSoul extends Item{
	public MobSoul(String unlocalizedName){
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
		if(itemStack.hasTagCompound() && itemStack.stackTagCompound.hasKey("mobname") && itemStack.stackTagCompound.hasKey("plasma") && itemStack.stackTagCompound.hasKey("cooldown") && itemStack.stackTagCompound.hasKey("costomInventory")){
			CostomInventory inv = new CostomInventory();
			inv.readNBT(itemStack.stackTagCompound);
			int plasma = itemStack.stackTagCompound.getInteger("plasma");
			int cooldown = itemStack.stackTagCompound.getInteger("cooldown");
			String mobname = itemStack.stackTagCompound.getString("mobname");
			entityPlayer.addChatMessage(new ChatComponentText(mobname + " Plasma: " + plasma + " Cooldown: " + cooldown));
			entityPlayer.addChatMessage(new ChatComponentText("Lüt:"));
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
	public String getItemStackDisplayName(ItemStack is) {
		if(is.hasTagCompound() && is.stackTagCompound.hasKey("mobname") && is.stackTagCompound.hasKey("plasma") && is.stackTagCompound.hasKey("cooldown") && is.stackTagCompound.hasKey("costomInventory")){
			return super.getItemStackDisplayName(is) + ": " + is.stackTagCompound.getString("mobname");
		}
		return "Empty " + super.getItemStackDisplayName(is);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
		if(stack.hasTagCompound() && stack.stackTagCompound.hasKey("mobname") && stack.stackTagCompound.hasKey("plasma") && stack.stackTagCompound.hasKey("cooldown") && stack.stackTagCompound.hasKey("costomInventory")){
			CostomInventory inv = new CostomInventory();
			inv.readNBT(stack.stackTagCompound);
			int plasma = stack.stackTagCompound.getInteger("plasma");
			int cooldown = stack.stackTagCompound.getInteger("cooldown");
			String mobname = stack.stackTagCompound.getString("mobname");
			list.add("Name: "+mobname);
			list.add("Plasma: "+plasma);
			list.add("Cooldown: "+cooldown);
			list.add("Lüt: "+inv.getItemCount()+" Items");
		}
	}
}
