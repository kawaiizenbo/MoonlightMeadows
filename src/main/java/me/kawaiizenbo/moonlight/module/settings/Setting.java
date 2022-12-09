package me.kawaiizenbo.moonlight.module.settings;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class Setting 
{
    public String name;
    protected TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

    int x = 0, y = 0;
    public void render(MatrixStack matrices, int x, int y, int mouseX, int mouseY)
    { 
        this.x = x;
        this.y = y;
        DrawableHelper.fill(matrices, x, y, x+192, y+24, hovered(mouseX, mouseY) ? 0xFF444444: 0xFF222222);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(name), x+2, y+2, 0xFFFFFF);
    }

	public void mouseClicked(double mouseX, double mouseY, int button) { }
	
	public void mouseReleased(double mouseX, double mouseY, int button) { }

    public void keyPressed(int keyCode, int scanCode, int modifiers) { }

    protected boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + 192 && mouseY >= y && mouseY <= y + 24;
	}
}
