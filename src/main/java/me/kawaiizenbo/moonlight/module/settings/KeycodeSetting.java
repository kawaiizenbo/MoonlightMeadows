package me.kawaiizenbo.moonlight.module.settings;

import me.kawaiizenbo.moonlight.ui.clickgui.KeybindScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class KeycodeSetting extends Setting 
{
    public int value;

    public KeycodeSetting(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			KeybindScreen kbs = new KeybindScreen();
            MinecraftClient.getInstance().setScreen(kbs);
            this.value = kbs.returnedKeycode;
		}
	}

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+8, 0xFFFFFF);
        String key = java.awt.event.KeyEvent.getKeyText(value);
        if (value == 0) key = "";
        int twidth = textRenderer.getWidth(key);
        drawContext.drawTextWithShadow(textRenderer, key, x+190-twidth, y+8, 0xFFFFFF);
    }
}
