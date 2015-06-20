package net.crazymoder.mattercraft.blockcontainer;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.crazymoder.mattercraft.Mattercraft;
import net.crazymoder.mattercraft.tileentity.ElectrolizerTile;
import net.crazymoder.mattercraft.tileentity.CryotheumAcceptorTile;
import net.crazymoder.mattercraft.tileentity.MemoryCardReaderTile;
import net.crazymoder.mattercraft.tileentity.QuarryTile;
import net.crazymoder.mattercraft.tileentity.ReactorTerminalTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MemoryCardReader extends BlockContainer
{	
	public IIcon[] icons = new IIcon[4];
	
	public MemoryCardReader()
	{
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new MemoryCardReaderTile();
	}
	
@Override
	public void breakBlock(World world, int x, int y,int z, Block p_149749_5_, int p_149749_6_) {
		if(!world.isRemote){
			MemoryCardReaderTile tile = (MemoryCardReaderTile) world.getTileEntity(x, y, z);
			if(tile.itemStack != null && tile.itemStack.stackSize > 0){
				EntityItem entityItem = new EntityItem(world, x, y, z, tile.itemStack);
				world.spawnEntityInWorld(entityItem);
			}
		}
		super.breakBlock(world, x, y, z,p_149749_5_, p_149749_6_);
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack){
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0){
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if (l == 1){
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	    }
		if (l == 2){
	            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if (l == 3){
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

	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int arg5, float arg6, float arg7, float arg8) {
		if(!world.isRemote){
			MemoryCardReaderTile tile = (MemoryCardReaderTile)world.getTileEntity(x, y, z);
			if(tile.itemStack == null || tile.itemStack.stackSize == 0){
				ItemStack playerStack = player.inventory.getCurrentItem();
				if(playerStack != null && playerStack.getUnlocalizedName().equals("item.mtc.chunkMemoryCard") && playerStack.hasTagCompound()){
					tile.itemStack = playerStack.copy();
					player.inventory.getCurrentItem().stackSize = 0;      
				}else{
					player.addChatMessage(new ChatComponentText("No Card Loaded"));
				}
			}
			else{
				ItemStack playerStack = player.inventory.getCurrentItem();
				if(playerStack == null){
					if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, tile.itemStack.copy());
						tile.itemStack = null;
					}else{
						player.addChatMessage(new ChatComponentText("Card Loaded"));
					}
				}else{
					player.addChatMessage(new ChatComponentText("Card Loaded"));
				}
			}
		}
		return true;
	}

}