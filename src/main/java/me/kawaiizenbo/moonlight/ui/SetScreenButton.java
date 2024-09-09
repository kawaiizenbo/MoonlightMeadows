package me.kawaiizenbo.moonlight.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class SetScreenButton 
{
    String text;
    Screen screen;
    int x, y, color, width;

    public SetScreenButton(String text, int x, int y, int color, Screen screen)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
        this.screen = screen;
    }

    public void render(DrawContext drawContext, TextRenderer textRenderer, int mouseX, int mouseY, int x, int y)
    {
    	this.x = x;
        this.y = y;
        width = textRenderer.getWidth(text);
        drawContext.fill(x-1, y-1, x + width + 1, y + 10, hovered(mouseX, mouseY) ? 0x55FFFFFF : 0);
        drawContext.drawText(textRenderer, Text.literal(text), x, y, color, true);
    }

    public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 10;
	}

    public void mouseClicked(int mouseX, int mouseY) 
    {
		if (hovered(mouseX, mouseY)) 
        {
            MinecraftClient.getInstance().setScreen(screen);
		}
	}
}
