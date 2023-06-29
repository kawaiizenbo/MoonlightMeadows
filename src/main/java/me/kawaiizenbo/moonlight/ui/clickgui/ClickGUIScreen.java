package me.kawaiizenbo.moonlight.ui.clickgui;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.Category;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUIScreen extends Screen
{
    public static ClickGUIScreen INSTANCE = new ClickGUIScreen();
    public static ArrayList<CategoryPane> categoryPanes;
	
	public ClickGUIScreen() 
	{
		super(Text.literal("ClickGUI"));
		int xOffset = 4;
		int yOffset = 4;
		categoryPanes = new ArrayList<CategoryPane>();
		for (Category category : Category.values())
		{ 
			if (xOffset > 400)
			{
				xOffset = 4;
				yOffset = 128;
			}
			categoryPanes.add(new CategoryPane(category, xOffset, yOffset));
			xOffset += 100;
		}
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
		this.renderBackground(drawContext);
		for (CategoryPane category : categoryPanes)
		{
			category.render(drawContext, mouseX, mouseY, delta);
		}
	}

	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) 
	{
		for (CategoryPane category : categoryPanes)
		{
			category.mouseClicked((int) mouseX, (int) mouseY, button);
		}
		return super.mouseClicked(mouseX, mouseY, button);
	}
	
	@Override
	public boolean shouldPause() 
	{
		return false;
	}
}
