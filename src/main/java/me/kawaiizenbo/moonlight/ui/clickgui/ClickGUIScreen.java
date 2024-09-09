package me.kawaiizenbo.moonlight.ui.clickgui;

import java.util.ArrayList;
import java.util.Map;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.util.MathUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUIScreen extends Screen
{
    public static ClickGUIScreen INSTANCE = new ClickGUIScreen();
    public ArrayList<CategoryPane> categoryPanes;
	
	@SuppressWarnings("unchecked")
	public ClickGUIScreen() 
	{
		super(Text.literal("ClickGUI"));
		categoryPanes = new ArrayList<CategoryPane>();
		Map<String, Object> panePos = ((Map<String, Object>)Moonlight.CONFIG.config.get("panes"));
		for (Category category : Category.values())
		{ 
			if(category.name == "Special") continue;
			int xOffset = MathUtils.d2iSafe(((Map<String, Object>)panePos.get(category.name)).get("x"));
			int yOffset = MathUtils.d2iSafe(((Map<String, Object>)panePos.get(category.name)).get("y"));
			boolean collapsed = (boolean)((Map<String, Object>)panePos.get(category.name)).get("collapsed");
			categoryPanes.add(new CategoryPane(category, xOffset, yOffset, collapsed));
		}
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
		this.renderBackground(drawContext, mouseX, mouseY, delta);
		for (CategoryPane category : categoryPanes)
		{
			category.render(drawContext, mouseX, mouseY, delta, textRenderer);
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
	public boolean mouseReleased(double mouseX, double mouseY, int button) 
	{
		for (CategoryPane category : categoryPanes)
		{
			category.mouseReleased((int) mouseX, (int) mouseY, button);
		}
		return super.mouseReleased(mouseX, mouseY, button);
	}
	
	@Override
	public boolean shouldPause() 
	{
		return false;
	}
}
