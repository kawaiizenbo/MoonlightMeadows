package me.kawaiizenbo.moonlight.ui.clickgui;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class KeybindScreen extends Screen
{
    public int returnedKeycode = 0;

    public KeybindScreen()
    {
        super(Text.literal("Keybind Selector"));
    }

    @Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
		this.renderBackground(drawContext, mouseX, mouseY, delta);
        drawContext.drawCenteredTextWithShadow(textRenderer, "Press any key (may not work, use .setting instead)", width/2, height/2, 0xFFFFFFFF);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        returnedKeycode = keyCode;
        this.close();
        return true;
    }

    @Override
	public boolean shouldPause() 
	{
		return false;
	}
}
