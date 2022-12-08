package me.kawaiizenbo.moonlight.ui;

import me.kawaiizenbo.moonlight.ui.clickgui.ClickGUIScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class TextButton 
{
    String text;
    int x, y, color, width;

    public TextButton(String text, int x, int y, int color)
    {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void render(MatrixStack matrices, TextRenderer textRenderer, int mouseX, int mouseY)
    {
        width = textRenderer.getWidth(text);
        DrawableHelper.fill(matrices, x-1, y-1, x + width + 1, y + 10, hovered(mouseX, mouseY) ? 0xFF444444 : 0xFF222222);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(text), x, y, color);
    }

    public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 10;
	}

    public void mouseClicked(int mouseX, int mouseY) 
    {
		if (hovered(mouseX, mouseY)) 
        {
            // i have no clue how to pass a method so this is kind of stupid
            MinecraftClient.getInstance().setScreen(ClickGUIScreen.INSTANCE);
		}
	}
}
