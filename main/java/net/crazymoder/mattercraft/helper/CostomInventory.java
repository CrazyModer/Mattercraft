package net.crazymoder.mattercraft.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import scala.collection.parallel.mutable.ParArray.Map;
import net.minecraft.item.ItemStack;

public class CostomInventory {
	HashMap<ItemStack, Integer> inv;
	public CostomInventory(){
		inv = new HashMap<ItemStack, Integer>();
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
	public HashMap<ItemStack, Integer> getMap(){
		return inv;
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
