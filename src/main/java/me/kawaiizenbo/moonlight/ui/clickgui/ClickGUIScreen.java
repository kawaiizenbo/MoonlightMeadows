package me.kawaiizenbo.moonlight.ui.clickgui;

import java.util.ArrayList;
import java.util.Map;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.theme.Theme;
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
		drawContext.fill(width-80, height-16, width, height, Moonlight.THEME.border.getRGB());
		drawContext.fill(width-78, height-14, width-2, height-2, (mouseX > width-80 && mouseY > height-16) ? Moonlight.THEME.hover.getRGB() : Moonlight.THEME.background.getRGB());
		drawContext.drawText(textRenderer, "Change Theme", width-75, height-12, Moonlight.THEME.text.getRGB(), false);
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
		if (mouseX > width-80 && mouseY > height-16)
		{
			if (Moonlight.THEME_IDX >= Theme.THEME_LIST.length-1) Moonlight.THEME_IDX = 0;
			else Moonlight.THEME_IDX++;
			Moonlight.THEME = Theme.THEME_LIST[Moonlight.THEME_IDX];
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
