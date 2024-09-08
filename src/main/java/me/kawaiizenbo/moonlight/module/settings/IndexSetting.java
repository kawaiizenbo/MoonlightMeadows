package me.kawaiizenbo.moonlight.module.settings;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class IndexSetting extends Setting
{
    public int index;
    public String[] elements;

    public IndexSetting(String name, int index, String... elements)
    {
        this.name = name;
        this.index = index;
        this.elements = elements;
    }

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+8, 0xFFFFFF);
        drawContext.fill(x+96, y+5, x+190, y+19, 0xFFFFFFFF);
        drawContext.fill(x+97, y+6, x+189, y+18, hovered(mouseX, mouseY) ? 0xFF333333 : 0xFF222222);
        drawContext.drawTextWithShadow(textRenderer, elements[index], x+98, y+8, 0xFFFFFF);
    }

    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			if (index >= elements.length-1) index = 0;
			else index++;
		}
	}
}
