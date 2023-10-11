package me.kawaiizenbo.moonlight.module.settings;

import org.lwjgl.glfw.GLFW;

import me.kawaiizenbo.moonlight.util.KeycodeUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class KeycodeSetting extends Setting 
{
    public int value;
    private boolean isWaiting = false;

    public KeycodeSetting(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
        if (isWaiting)
        {
            isWaiting = false;
            return;
        }
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			isWaiting = true;
		}
	}

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+8, 0xFFFFFF);
        if (isWaiting)
        {
            String waiting = "Press any key.";
            int twwidth = textRenderer.getWidth(waiting);
            drawContext.drawTextWithShadow(textRenderer, waiting, x+190-twwidth, y+8, 0xFFFFFF);
        }
        else 
        {
            String key = KeycodeUtils.keyTable[value];
            if (value == GLFW.GLFW_KEY_UNKNOWN) key = "";
            int twidth = textRenderer.getWidth(key);
            drawContext.drawTextWithShadow(textRenderer, key, x+190-twidth, y+8, 0xFFFFFF);
        }
    }

    @Override
    public void keyPressed(int keyCode, int scanCode, int modifiers)
    {
        if (isWaiting)
        {
            if (keyCode == 256)
            {
                // escape was pressed, exit safely
                isWaiting = false;
                return;
            }
            value = keyCode;
            isWaiting = false;
        }
    }
}
