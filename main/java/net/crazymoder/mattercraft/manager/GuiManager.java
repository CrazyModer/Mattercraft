package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.gui.CoolerGui;
import net.crazymoder.mattercraft.gui.ReactorTerminalGui;
import net.crazymoder.mattercraft.tileentity.CoolerTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiManager implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			ReactorTerminalTile reactorTerminalTile = (ReactorTerminalTile) world.getTileEntity(x, y, z);
			return new ReactorTerminalGui(reactorTerminalTile);
		}
		if(ID == 1){
			CoolerTile coolerTile = (CoolerTile) world.getTileEntity(x, y, z);
			return new CoolerGui(coolerTile);
		}
		return null;
	}

}
