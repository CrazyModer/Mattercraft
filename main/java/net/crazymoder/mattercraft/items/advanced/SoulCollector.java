package net.crazymoder.mattercraft.items.advanced;

import net.crazymoder.mattercraft.helper.MobCrafter.MobCrafterConfiguration;
import net.crazymoder.mattercraft.manager.CreativeTabManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;

public class SoulCollector extends Item{

	public SoulCollector(String string) {
		this.setCreativeTab(CreativeTabManager.tabItems);
		this.setUnlocalizedName(string);
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if(MobCrafterConfiguration.editmode)player.addChatComponentMessage(new ChatComponentText(entity.getClass().getName()));
		return super.onLeftClickEntity(stack, player, entity);
	}

}
