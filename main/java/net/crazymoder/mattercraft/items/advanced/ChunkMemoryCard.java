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
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int posx, int posy, int posz, int side, float blockx, float blocky, float blockz){
		if(!world.isRemote && world.getBlock(posx, posy, posz).getUnlocalizedName().equals("tile.mtc.itemProvider")){
			if(item.hasTagCompound()){
				CostomInventory inv = new CostomInventory();
				inv.readNBT(item.stackTagCompound);
				ItemProviderTile quarryTile = (ItemProviderTile) world.getTileEntity(posx, posy, posz);
				quarryTile.inv = inv;
			}
		}
		return false;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack is) {
		if(is.hasTagCompound())
			return super.getItemStackDisplayName(is);
		return "Empty " + super.getItemStackDisplayName(is);
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
