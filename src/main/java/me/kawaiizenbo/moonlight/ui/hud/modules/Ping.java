package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Ping extends HUDModule
{
	public Ping(int x, int y) 
	{
		super("Ping", x, y);
		this.width = 48;
		this.height = 8;
		this.enabled = true;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		drawContext.drawTextWithShadow(mc.textRenderer, "Ping: " + ColorUtils.gray + (mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()) == null ? 0 : mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()).getLatency()), x, y, Moonlight.THEME.hudAccent.getRGB());
	}
}
