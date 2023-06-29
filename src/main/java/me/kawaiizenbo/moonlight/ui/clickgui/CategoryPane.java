package me.kawaiizenbo.moonlight.ui.clickgui;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class CategoryPane 
{
    private MinecraftClient mc = MinecraftClient.getInstance();
	private TextRenderer textRenderer = mc.textRenderer;
    
    public Category category;
    public int x;
    public int y;
    private int height;
    private int width = 96;
    private boolean collapsed = false;
    private ArrayList<ModuleButton> moduleButtons;

    public CategoryPane(Category category, int initialX, int initialY)
    {
        this.category = category;
        this.x = initialX;
        this.y = initialY;
        int buttonYOffset = y+16;
        moduleButtons = new ArrayList<ModuleButton>();
        for (Module_ m : ModuleManager.INSTANCE.getModulesByCategory(category))
        {
            moduleButtons.add(new ModuleButton(m, x+2, buttonYOffset));
            buttonYOffset += 12;
        }
        if (moduleButtons.size() == 0) collapsed = true;
        height = (moduleButtons.size()*12) + 18;
    }

    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
    {
        drawContext.fill(x, y, x+width, collapsed ? y+16 : y+height, category.color);
        drawContext.fill(x+2, y+2, x+(width-2), y+14, hovered(mouseX, mouseY) ? 0xFF333333 : 0xFF222222);
        drawContext.drawText(textRenderer, category.name, x+4, y+4, 0xFFFFFFFF, false);
        if (!collapsed)
        {
            for (ModuleButton m : moduleButtons)
            {
                m.render(drawContext, mouseX, mouseY);
            }
        }
    }

    public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}

    public void mouseClicked(int mouseX, int mouseY, int button) 
	{
		for (ModuleButton moduleButton : moduleButtons)
		{
			if (moduleButton.mouseClicked(mouseX, mouseY, button)) return;
		}
        if (hovered(mouseX, mouseY)) collapsed = !collapsed;
	}
}
