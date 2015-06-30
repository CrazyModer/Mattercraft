package net.crazymoder.mattercraft.helper.manual;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;

public class LinkButton extends GuiButton{

	public LinkButton(int id, int x, int y, String text) {
		super(id, x, y, Minecraft.getMinecraft().fontRenderer.getStringWidth(text)+10, 12, text);
	}
	
	@Override
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_,int p_146112_3_) {
		if (this.visible)
        {
            FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            GL11.glColor4f(1F, 1F, 1.0F, 1.0F);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = Color.cyan.getRGB();

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = Color.yellow.getRGB();
            }
            else if (this.field_146123_n)
            {
                l = Color.white.getRGB();
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
	}
	
	@Override
	public void drawCenteredString(FontRenderer p_73732_1_, String p_73732_2_, int p_73732_3_, int p_73732_4_, int p_73732_5_) {
		 p_73732_1_.drawStringWithShadow(p_73732_2_, p_73732_3_ - p_73732_1_.getStringWidth(p_73732_2_) / 2, p_73732_4_, p_73732_5_);
	}
}
