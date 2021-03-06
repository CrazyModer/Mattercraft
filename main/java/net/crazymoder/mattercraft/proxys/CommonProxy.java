package net.crazymoder.mattercraft.proxys;

import java.io.File;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.crazymoder.mattercraft.Mattercraft;
import net.crazymoder.mattercraft.craftingmanager.SmeltingManager;
import net.crazymoder.mattercraft.craftingmanager.StaticItemStacks;
import net.crazymoder.mattercraft.craftingmanager.ThermalExpansionCraftingManager;
import net.crazymoder.mattercraft.craftingmanager.VanillaCraftingManager;
import net.crazymoder.mattercraft.interfaces.INoisyTileEntity;
import net.crazymoder.mattercraft.manager.AdvancedItemManager;
import net.crazymoder.mattercraft.manager.BlockManager;
import net.crazymoder.mattercraft.manager.ConfigurationManager;
import net.crazymoder.mattercraft.manager.EventManager;
import net.crazymoder.mattercraft.manager.FluidManager;
import net.crazymoder.mattercraft.manager.GuiManager;
import net.crazymoder.mattercraft.manager.ItemBlockManager;
import net.crazymoder.mattercraft.manager.ItemManager;
import net.crazymoder.mattercraft.manager.TileEntityManager;
import net.crazymoder.mattercraft.manager.TileRenderingManager;
import net.crazymoder.mattercraft.manager.WorldGenManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		ConfigurationManager configurationManager = new ConfigurationManager(e);
		BlockManager blockManager = new BlockManager();
		ItemManager itemManager = new ItemManager();
		AdvancedItemManager advancedItemManager = new AdvancedItemManager();
		ItemBlockManager itemBlockManager = new ItemBlockManager();
    	TileEntityManager tileEntityManger = new TileEntityManager();
    	FluidManager fluidManager = new FluidManager();
    	GameRegistry.registerWorldGenerator(new WorldGenManager(), 0);
	}
	
	
	public void init(FMLInitializationEvent e){
		NetworkRegistry.INSTANCE.registerGuiHandler(Mattercraft.INSTANCE, new GuiManager());
		EventManager eventManager = new EventManager();
	}
	
	public void postInit(FMLPostInitializationEvent e){
		StaticItemStacks.init();
		ThermalExpansionCraftingManager thermalExpansionCraftingManager = new ThermalExpansionCraftingManager();
		SmeltingManager smeltingManager = new SmeltingManager();
		VanillaCraftingManager vanillaCraftingManager = new VanillaCraftingManager();
		System.out.println("Mattercraft loaded!");
	}

	public void render(World w,float x,float y,float z){}

	public void initTileSound(TileEntity tile, String name) {}
	
}
