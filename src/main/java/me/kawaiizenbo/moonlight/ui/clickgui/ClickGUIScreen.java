package me.kawaiizenbo.moonlight.ui.clickgui;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUIScreen extends Screen 
{
	public static ClickGUIScreen INSTANCE = new ClickGUIScreen();
	public static ArrayList<ModuleButton> moduleButtons;
	
	public ClickGUIScreen() 
	{
		super(Text.literal("ClickGUI"));
		moduleButtons = new ArrayList<>();
		int yOffset;
		for (Category category : Category.values())
		{ 
			yOffset = 25;
			for (Module_ module : ModuleManager.INSTANCE.getModulesByCategory(category))
			{
				moduleButtons.add(new ModuleButton(module, 9+(module.category.ordinal()*70), yOffset));
				yOffset += 14;
			}
		}
		
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
		this.renderBackground(drawContext);
		int categoryLabelXOffset = 10;
		for (Category category : Category.values())
		{
			drawContext.drawText(textRenderer, category.name, categoryLabelXOffset, 10, 0xFFFFFF, false);
			categoryLabelXOffset += 70;
		}
		for (ModuleButton moduleButton : moduleButtons)
		{
			moduleButton.render(drawContext, mouseX, mouseY);
		}
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) 
	{
		for (ModuleButton modButton : moduleButtons) 
		{
			modButton.mouseClicked((int) mouseX, (int) mouseY, button);
		}
		return super.mouseClicked(mouseX, mouseY, button);
	}
	
	@Override
	public boolean shouldPause() 
	{
		return false;
	}
}
