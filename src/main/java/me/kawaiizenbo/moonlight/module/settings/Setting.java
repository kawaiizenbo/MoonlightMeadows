package me.kawaiizenbo.moonlight.module.settings;

import java.lang.reflect.Method;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Setting 
{
    public String name;
    public Method onValueChanged;
    protected TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
    public int height = 24;

    int x = 0, y = 0;
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY)
    { 
        this.x = x;
        this.y = y;
        drawContext.fill(x, y, x+192, y+height, hovered(mouseX, mouseY) ? 0xFF444444: 0xFF222222);
        
    }

	public void mouseClicked(double mouseX, double mouseY, int button) { }
	
	public void mouseReleased(double mouseX, double mouseY, int button) { }

    public void keyPressed(int keyCode, int scanCode, int modifiers) { }

    protected boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + 192 && mouseY >= y && mouseY <= y + height;
	}
}
