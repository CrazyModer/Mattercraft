package net.crazymoder.mattercraft.helper;

import net.minecraft.item.ItemStack;

public class MatterHelper {
	public static boolean areItemStackTypesEqual(ItemStack s1, ItemStack s2)
    {
		System.out.println("A");
		if(s1 == null && s2 == null)return true;
		System.out.println("B");
		if(s1 == null || s2 == null)return false;
		System.out.println("C");
		if(!s1.getUnlocalizedName().equals(s2.getUnlocalizedName()))return false;
		System.out.println("D");
		if(s1.getItemDamage() != s2.getItemDamage())return false;
		System.out.println("E");
		if((!s1.hasTagCompound() && s2.hasTagCompound())&& s1.hasTagCompound() || s2.hasTagCompound())return false;
		System.out.println("F");
		if(s1.hasTagCompound() && !s1.getTagCompound().equals(s2.getTagCompound()))return false;
		System.out.println("G");
		return true;
    }
}
