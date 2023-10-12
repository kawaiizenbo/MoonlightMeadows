package me.kawaiizenbo.moonlight.module.settings;

import me.kawaiizenbo.moonlight.util.KeycodeUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class StringSetting extends Setting
{
    public String value;
    private boolean focused = false;

    public StringSetting(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+8, 0xFFFFFF);
        int twidth = textRenderer.getWidth(value);
        drawContext.fill(x+96, y+5, x+190, y+19, 0xFFFFFFFF);
        drawContext.fill(x+97, y+6, x+189, y+18, 0xFF222222);
        int cursorPos = x+98+twidth;
        if (focused) drawContext.fill(cursorPos, y+7, cursorPos+1, y+17, 0xFF55FFFF);
        drawContext.drawTextWithShadow(textRenderer, value, x+98, y+8, 0xFFFFFF);
    }

    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
        if (focused)
        {
            focused = false;
            return;
        }
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			focused = true;
		}
	}

    @Override
    public void keyPressed(int keyCode, int scanCode, int modifiers)
    {
        if (focused)
        {
            if (keyCode == 256 || keyCode == 257)
            {
                // escape or enter was pressed, exit safely
                focused = false;
                return;
            }
            if (keyCode == 259)
            {
                // backspace, remove a character
                if (value.length() > 0) value = value.substring(0, value.length() - 1);
                return;
            }
            if (keyCode > 96) return; // not a typing key
            String append = KeycodeUtils.keyTable[keyCode];
            if (modifiers == 1) append = KeycodeUtils.shiftedKeyTable[keyCode];
            if (append == "Unknown") return;
            if (append == "Space") append = " ";
            value += append;
        }
    }
}
