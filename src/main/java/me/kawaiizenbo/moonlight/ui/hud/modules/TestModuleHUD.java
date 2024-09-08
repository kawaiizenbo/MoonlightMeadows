package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class TestModuleHUD extends HUDModule
{
	public TestModuleHUD(int x, int y) 
	{
		super("Test HUD Module", x, y);
		this.width = 96;
		this.height = 12;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode);
		drawContext.drawText(textRenderer, "heloooooo", x, y, 0x55FFFF, false);
	}
}
