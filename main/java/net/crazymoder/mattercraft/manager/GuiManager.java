package net.crazymoder.mattercraft.manager;

import net.crazymoder.mattercraft.blockcontainer.Electrolizer;
import net.crazymoder.mattercraft.gui.CoolerGui;
import net.crazymoder.mattercraft.gui.ElectrolizerGui;
import net.crazymoder.mattercraft.gui.GeneratorControllerGui;
import net.crazymoder.mattercraft.gui.ReactorTerminalGui;
import net.crazymoder.mattercraft.tileentity.CoolerTile;
import net.crazymoder.mattercraft.tileentity.ElectrolizerTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.crazymoder.mattercraft.tileentity.generator.GeneratorControllerTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiManager implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if(id == 0){
			ReactorTerminalTile reactorTerminalTile = (ReactorTerminalTile) world.getTileEntity(x, y, z);
			return new ReactorTerminalGui(reactorTerminalTile);
		}
		if(id == 1){
			CoolerTile coolerTile = (CoolerTile) world.getTileEntity(x, y, z);
			return new CoolerGui(coolerTile);
		}
		if(id == 2){
			ElectrolizerTile electrolizerTile = (ElectrolizerTile) world.getTileEntity(x, y, z);
			return new ElectrolizerGui(electrolizerTile);
		}
		if(id == 3){
			GeneratorControllerTile electrolizerTile = (GeneratorControllerTile) world.getTileEntity(x, y, z);
			return new GeneratorControllerGui(electrolizerTile);
		}
		return null;
	}

}
