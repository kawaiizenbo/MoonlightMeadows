package me.kawaiizenbo.moonlight.ui.hud;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class HUDEditorScreen extends Screen
{
    public static HUDEditorScreen INSTANCE = new HUDEditorScreen();
	
	public HUDEditorScreen() 
	{
		super(Text.literal("HUD Editor"));
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
		this.renderBackground(drawContext, mouseX, mouseY, delta);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) 
	{
		return super.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public boolean mouseReleased(double mouseX, double mouseY, int button) 
	{
		return super.mouseReleased(mouseX, mouseY, button);
	}
	
	@Override
	public boolean shouldPause() 
	{
		return false;
	}
}
