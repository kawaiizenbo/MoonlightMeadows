package me.kawaiizenbo.moonlight.ui.hud.editor;

import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import me.kawaiizenbo.moonlight.ui.hud.HUDModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class HUDEditorScreen extends Screen
{
    public static HUDEditorScreen INSTANCE = new HUDEditorScreen();
    HUDModuleList moduleList;
	
	public HUDEditorScreen() 
	{
		super(Text.literal("HUD Editor"));
		moduleList = new HUDModuleList(256, 2, false);
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
		this.renderBackground(drawContext, mouseX, mouseY, delta);
		for (HUDModule h : HUDModuleManager.INSTANCE.modules)
		{
			h.render(drawContext, mouseX, mouseY, textRenderer, true, h.enabled);
		}
		moduleList.render(drawContext, mouseX, mouseY, delta, textRenderer);
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) 
	{
		for (HUDModule h : HUDModuleManager.INSTANCE.modules)
		{
			h.mouseClicked((int)mouseX, (int)mouseY, button);
		}
		moduleList.mouseClicked((int)mouseX, (int)mouseY, button);
		return super.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public boolean mouseReleased(double mouseX, double mouseY, int button) 
	{
		for (HUDModule h : HUDModuleManager.INSTANCE.modules)
		{
			h.mouseReleased((int)mouseX, (int)mouseY, button);
		}
		moduleList.mouseReleased((int)mouseX, (int)mouseY, button);
		return super.mouseReleased(mouseX, mouseY, button);
	}
	
	@Override
	public boolean shouldPause() 
	{
		return false;
	}
}
