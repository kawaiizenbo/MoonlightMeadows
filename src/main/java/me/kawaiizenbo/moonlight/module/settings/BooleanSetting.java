package me.kawaiizenbo.moonlight.module.settings;

import me.kawaiizenbo.moonlight.Moonlight;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BooleanSetting extends Setting
{
    public boolean value;

    public BooleanSetting(String name, boolean value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawText(textRenderer, Text.literal(name), x+2, y+8, Moonlight.THEME.text.getRGB(), false);
        drawContext.fill(x+180, y+7, x+190, y+17, Moonlight.THEME.border.getRGB());
        drawContext.fill(x+181, y+8, x+189, y+16, Moonlight.THEME.background.getRGB());
        drawContext.fill(x+182, y+9, x+188, y+15, value ? Moonlight.THEME.accent.getRGB() : Moonlight.THEME.background.getRGB());
    }
    
    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			this.value = !value;
		}
	}
}
