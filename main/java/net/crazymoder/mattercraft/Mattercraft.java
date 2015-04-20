package net.crazymoder.mattercraft;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Mattercraft.MODID, version = Mattercraft.VERSION)
public class Mattercraft
{
    public static final String MODID = "mattercraft";
    public static final String VERSION = "0.1";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    	for (int i = 0; i < 1000; i++) {
    		 System.out.println("DIAMOND BLOCK >> "+Blocks.diamond_block.getUnlocalizedName());
		}    
    }
}
