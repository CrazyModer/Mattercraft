package net.crazymoder.mattercraft.blockcontainer;

import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CryotheumAcceptor extends BlockContainer
{	
	public CryotheumAcceptor() {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}

	//And this tell it that you can see through this block, and neighbor blocks should be rendered.
	public boolean isOpaqueCube()
	{
	   return false;
	}
   
    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack itemStack)
    {
        int facing = MathHelper.floor_double((double) ((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        int newFacing = 0;
        if (facing == 0)
        {
        	newFacing = 2;
        }
        if (facing == 1)
        {
        	newFacing = 5;
        }
        if (facing == 2)
        {
        	newFacing = 3;
        }
        if (facing == 3)
        {
        	newFacing = 4;
        }
        TileEntity te = world.getTileEntity(i, j, k);
        if (te != null && te instanceof CryotheumAcceptorTile)
        {
        	CryotheumAcceptorTile cryotheumAcceptorTile = (CryotheumAcceptorTile) te;
        	cryotheumAcceptorTile.setFacingDirection(newFacing);
            world.markBlockForUpdate(i, j, k);
        }
    }

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new CryotheumAcceptorTile();
	}

}
