package net.crazymoder.mattercraft;

import net.crazymoder.mattercraft.craftingmanager.ExternalCraftingManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.manager.FluidManager;
import net.crazymoder.mattercraft.manager.TileEntityManager;
import net.crazymoder.mattercraft.manager.TileEntityRenderingManager;
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
    	BlockManager blockManager = new BlockManager();
    	TileEntityManager tileEntityManger = new TileEntityManager();
    	ExternalCraftingManager extenalCM = new ExternalCraftingManager();
    	FluidManager fluidManager = new FluidManager();
    	TileEntityRenderingManager tileEntityRenderingManager = new TileEntityRenderingManager();
    }
}
