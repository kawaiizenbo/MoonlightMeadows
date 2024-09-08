package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class ClientTag extends HUDModule
{
	public ClientTag(int x, int y) 
	{
		super("Client Tag", x, y);
		this.width = 128;
		this.height = 8;
		this.enabled = true;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		drawContext.drawTextWithShadow(mc.textRenderer, Moonlight.clientTag + " " + Moonlight.versionTag, x, y, 16777215);
	}
}
