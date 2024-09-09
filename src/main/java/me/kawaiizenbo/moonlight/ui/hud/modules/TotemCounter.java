package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import me.kawaiizenbo.moonlight.util.MathUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

public class TotemCounter extends HUDModule
{
	
	public TotemCounter(int x, int y) 
	{
		super("Totem Counter", x, y);
		this.width = 24;
		this.height = 16;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		int count = 0;
		for (int i = 0; i < 36; i++)
		{
			ItemStack stack = mc.player.getInventory().getStack(i);
			if (stack.getItem() == Items.TOTEM_OF_UNDYING) count += stack.getCount();
		}
		drawContext.drawItem(Items.TOTEM_OF_UNDYING.getDefaultStack(), x, y);
		drawContext.drawTextWithShadow(textRenderer, count+"", x+16, y+8, 16777215);
	}
}
