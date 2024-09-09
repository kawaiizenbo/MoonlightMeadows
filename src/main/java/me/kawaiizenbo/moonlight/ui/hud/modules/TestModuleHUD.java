package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;
import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class TestModuleHUD extends HUDModule
{
	public StringSetting text = new StringSetting("Text", "hii :3");
	public DoubleSetting number = new DoubleSetting("test", 1, 0, 10, 0);
	
	public TestModuleHUD(int x, int y) 
	{
		super("Test HUD Module", x, y);
		this.width = 96;
		this.height = 8;
		settings.add(text);
		settings.add(number);
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		drawContext.drawText(textRenderer, text.value, x, y, 0xFFFFFF, false);
	}
}
