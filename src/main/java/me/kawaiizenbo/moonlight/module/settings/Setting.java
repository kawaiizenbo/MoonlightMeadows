package me.kawaiizenbo.moonlight.module.settings;

import me.kawaiizenbo.moonlight.Moonlight;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class Setting 
{
    public String name;

    int x = 0, y = 0;
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer)
    { 
        this.x = x;
        this.y = y;
        drawContext.fill(x, y, x+192, y+24, hovered(mouseX, mouseY) ? Moonlight.THEME.hover.getRGB(): Moonlight.THEME.background.getRGB());
        
    }

	public void mouseClicked(double mouseX, double mouseY, int button) { }
	
	public void mouseReleased(double mouseX, double mouseY, int button) { }

    public void keyPressed(int keyCode, int scanCode, int modifiers) { }

    protected boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + 192 && mouseY >= y && mouseY <= y + 24;
	}
}
