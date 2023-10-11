package me.kawaiizenbo.moonlight.module.settings;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class StringSetting extends Setting
{
    public String value;

    public StringSetting(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+4, 0xFFFFFF);
        int twidth = textRenderer.getWidth(value);
        drawContext.drawTextWithShadow(textRenderer, value, x+190-twidth, y+4, 0xFFFFFF);
        drawContext.drawTextWithShadow(textRenderer, "WIP, please use the .setting command", x+2, y+14, 0xFFFFFF);
    }
}
