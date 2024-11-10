package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Coordinates extends HUDModule
{
	public Coordinates(int x, int y) 
	{
		super("Coordinates", x, y);
		this.width = 128;
		this.height = 8;
		this.enabled = true;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		drawContext.drawTextWithShadow(mc.textRenderer, 
	            "X: " + ColorUtils.gray + String.format("%.1f", mc.player.getX()) + ColorUtils.reset + 
	            " Y: " + ColorUtils.gray + String.format("%.1f", mc.player.getY()) + ColorUtils.reset + 
	            " Z: " + ColorUtils.gray + String.format("%.1f", mc.player.getZ()), x, y, Moonlight.THEME.hudAccent.getRGB()
	        );
	}
}
