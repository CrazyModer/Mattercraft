package net.crazymoder.mattercraft.blockcontainer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crazymoder.mattercraft.Mattercraft;
import net.crazymoder.mattercraft.tileentity.ChunkRegistratorTile;
import net.crazymoder.mattercraft.tileentity.ElectrolizerTile;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.QuarryTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ChunkRegistrator extends BlockContainer
{	
	public IIcon[] icons = new IIcon[6];
	
	public ChunkRegistrator()
	{
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new ChunkRegistratorTile();
	}

	public void registerBlockIcons(IIconRegister reg) {
	    for (int i = 0; i < 6; i ++) {
	    	if(i == 0){
	    		//bottom
	    		this.icons[i] = reg.registerIcon(this.textureName + "_B");
	    	}else if(i == 1){
	    		//top
	    		this.icons[i] = reg.registerIcon(this.textureName + "_T");
	    	}else{
	    		//side
	    		this.icons[i] = reg.registerIcon(this.textureName + "_S");
	    	}
	    }
	}
	

	public IIcon getIcon(int side, int meta) {
	    return this.icons[side];
	}

}