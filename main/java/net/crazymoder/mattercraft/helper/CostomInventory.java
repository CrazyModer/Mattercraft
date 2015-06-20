package net.crazymoder.mattercraft.helper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import scala.collection.parallel.mutable.ParArray.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class CostomInventory{
	LinkedHashMap<ItemStack, Integer> inv;
	public CostomInventory(){
		inv = new LinkedHashMap<ItemStack, Integer>();
	}
	public void addItemStack(ItemStack itemStack){
		addItemStack(itemStack.stackSize, itemStack);
	}
	public void addItemStack(int amount , ItemStack stack){
		ItemStack itemStack = stack.copy();
		itemStack.stackSize = 1;
		boolean exists = false;
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			try {
				if(entry.getKey().getUnlocalizedName().equals(itemStack.getUnlocalizedName()) && entry.getKey().getAttributeModifiers().equals(itemStack.getAttributeModifiers()) && entry.getKey().getItemDamage() == itemStack.getItemDamage()){
					entry.setValue(entry.getValue()+amount);
					exists = true;
				}
			} catch (Exception e) {exists = true;}
		}
		if(!exists){
			inv.put(itemStack, amount);
		}
	}
	public ItemStack getNextItemStack(boolean simulate){
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			ItemStack is = entry.getKey();
			int amount = entry.getValue();
			ItemStack outStack = is.copy();
			if(amount > 64)
				outStack.stackSize = 64;
			else
				outStack.stackSize = amount;
			if(!simulate)
				amount -= outStack.stackSize;
			entry.setValue(amount);
			if(entry.getValue() == 0){
				if(inv.remove(entry.getKey()) == null)System.out.println("ERROR");;
				
			}
			return outStack;
		}
		return null;
	}
	public ItemStack getItemStack(String unlocalizedName,int amount,boolean simulate){
		return null;
	}
	public int getItemCount(){
		int count = 0;
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			count += entry.getValue().intValue();
		}
		return count;
	}
	public int getStackCount(){
		int count = 0;
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			int icount = entry.getValue().intValue();
		    int i = (int) (icount/64f);
		    if(i != icount/64f)i++;
		    count += i;
		}
		return count;
	}
	public int getTypeCount(){
		int count = 0;
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			count++;
		}
		return count;
	}
	public LinkedHashMap<ItemStack, Integer> getMap(){
		return inv;
	}
	
	public void setMap(LinkedHashMap<ItemStack, Integer> map){
		inv = map;
	}
	
	public boolean readNBT(NBTTagCompound compound){
		if(compound.hasKey("costomInventory")){
			inv = new LinkedHashMap<ItemStack, Integer>();
			NBTTagList tagList = compound.getTagList("costomInventory", Constants.NBT.TAG_COMPOUND);
			for(int i = 0; i < tagList.tagCount(); i++)
		    {
			    NBTTagCompound entry = (NBTTagCompound)tagList.getCompoundTagAt(i);
			    ItemStack stack = ItemStack.loadItemStackFromNBT(entry);
			    int amount = entry.getInteger("a");
			    inv.put(stack, amount);
			}
			return true;
		}
		return false;
	}
	
	public void writeNBT(NBTTagCompound compound){
		NBTTagList tagList = new NBTTagList();
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			NBTTagCompound tagEntry = new NBTTagCompound();
			entry.getKey().writeToNBT(tagEntry);
			tagEntry.setInteger("a", entry.getValue());
			tagList.appendTag(tagEntry);
		}
		compound.setTag("costomInventory", tagList);
	}
	
	public void Log(){
		int count = 0;
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			System.out.println("Item: " + entry.getKey().getUnlocalizedName() + " Amount: " + entry.getValue().toString());
		}
		System.out.println("Items: "+getItemCount());
		System.out.println("Types: "+getTypeCount());
		System.out.println("Stacks: "+getStackCount());
	}
	
	
	
}
