package net.crazymoder.mattercraft;

import net.crazymoder.mattercraft.craftingmanager.ExternalCraftingManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.manager.FluidManager;
import net.crazymoder.mattercraft.manager.TileEntityManager;
import net.crazymoder.mattercraft.manager.TileRenderingManager;
import net.crazymoder.mattercraft.proxys.CommonProxy;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Mattercraft.MODID, version = Mattercraft.VERSION)

public class Mattercraft
{
	@Instance(Mattercraft.MODID)
	public static Mattercraft INSTANCE;
	
	@SidedProxy(clientSide="net.crazymoder.mattercraft.proxys.ClientProxy",serverSide="net.crazymoder.mattercraft.proxys.ServerProxy")
	public static CommonProxy proxy;
	
    public static final String MODID = "mattercraft";
    public static final String VERSION = "0.1";
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        this.proxy.postInit(e);
    }
}
