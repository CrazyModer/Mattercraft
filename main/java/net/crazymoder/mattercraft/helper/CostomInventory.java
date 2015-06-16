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
			if(entry.getKey().getUnlocalizedName() == itemStack.getUnlocalizedName()){
				System.out.println("exists");
				entry.setValue(entry.getValue()+amount);
				exists = true;
			}
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
		return 0;
	}
	public int getStackCount(){
		return 0;
	}
	public String[][] getInfo(){
		List<String[]> info = new ArrayList<String[]>();
		for(Entry<ItemStack, Integer> entry : inv.entrySet()) {
			String[] entryInfo = {entry.getKey().getUnlocalizedName(),entry.getValue().toString()};
			info.add(entryInfo);
		}
		return (String[][]) info.toArray();
	}
}
