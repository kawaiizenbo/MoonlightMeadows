package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

public class ArmorDisplay extends HUDModule
{
	
	public ArmorDisplay(int x, int y) 
	{
		super("Armor Display", x, y);
		this.width = 16;
		this.height = 64;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		int yOffset = 0;
		for (int i = 39; i >= 36; i--)
		{
			ItemStack piece = mc.player.getInventory().getStack(i);
			drawContext.drawItem(piece, x, y+yOffset);
			drawContext.drawItemInSlot(textRenderer, piece, x, y+yOffset);
			yOffset += 16;
		}
	}
}
