package net.crazymoder.mattercraft.blockcontainer;

import javax.swing.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crazymoder.mattercraft.gui.ReactorTerminalGui;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ReactorTerminal extends BlockContainer{

	public IIcon[] icons = new IIcon[4];
	
	public ReactorTerminal() {
		super(Material.iron);
	}

	 public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
	    {
	        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	        }

	        if (l == 1)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	        }

	        if (l == 2)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	        }

	        if (l == 3)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	        }

	    }
	 
	public void registerBlockIcons(IIconRegister reg) {	   
		this.icons[0] = reg.registerIcon(this.textureName + "_T");
		this.icons[1] = reg.registerIcon(this.textureName + "_B");
		this.icons[2] = reg.registerIcon(this.textureName + "_S");
		this.icons[3] = reg.registerIcon(this.textureName + "_F");
	}
		

	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.icons[0] : (side == 0 ? this.icons[1] : (side != meta ? this.icons[2] : this.icons[3]));
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new ReactorTerminalTile();
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int arg5, float arg6, float arg7, float arg8) {
		if(!world.isRemote){
			System.out.println("Hallo");
			super.onBlockClicked(world, x, y, z, player);
			ReactorTerminalTile te = (ReactorTerminalTile) world.getTileEntity(x, y, z);
			Minecraft.getMinecraft().displayGuiScreen(new ReactorTerminalGui(te));
		}
		return true;
	}
}
