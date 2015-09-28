package net.crazymoder.mattercraft.gui;

import org.lwjgl.opengl.GL11;

import net.crazymoder.mattercraft.container.MobCrafterContainer;
import net.crazymoder.mattercraft.tileentity.MobCrafterTile;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MobCrafterGui extends GuiContainer{

	private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("textures/gui/container/crafting_table.png");
    private static final String __OBFID = "CL_00000750";
    private MobCrafterTile tile;

    public MobCrafterGui(EntityPlayer player, World world, int x, int y, int z)
    {
        super(new MobCrafterContainer(player, world, x, y, z));
        tile = (MobCrafterTile) world.getTileEntity(x, y, z);
    }

    public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int val1 = (int)(((float)tile.plasmaTank.getFluidAmount() / (float)tile.plasmaTank.getCapacity())*54f);
        int val2 = (int)(((float)tile.cooldown / (float)tile.maxCooldown)*54f);
        this.drawTexturedModalRect(k+101, l+70-val2, 0, 0, 24, val2);
        this.drawTexturedModalRect(k+103, l+70-val1, 0, 0, 20, val1);
        fontRendererObj.drawString("Plasma: "+tile.plasmaTank.getFluidAmount()/1000 + "B Cooldown: " + tile.cooldown, k+19, l+73, 200, false);
    }

}
