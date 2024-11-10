package me.kawaiizenbo.moonlight.ui.clickgui;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class CategoryPane 
{
    public Category category;
    public int x, y, height, width = 96;
    int startX, startY;
    boolean dragging = false;
    public boolean collapsed = false;
    ArrayList<ModuleButton> moduleButtons;
    Identifier icon;

    public CategoryPane(Category category, int initialX, int initialY, boolean collapsed)
    {
        this.category = category;
        this.x = initialX;
        this.y = initialY;
        this.collapsed = collapsed;
        moduleButtons = new ArrayList<ModuleButton>();
        icon = Identifier.of("moonlight", category.name.toLowerCase());
        for (Module m : ModuleManager.INSTANCE.getModulesByCategory(category))
        {
            moduleButtons.add(new ModuleButton(m));
        }
        if (moduleButtons.size() == 0) collapsed = true;
        height = (moduleButtons.size()*12) + 18;
    }

    public void render(DrawContext drawContext, int mouseX, int mouseY, float delta, TextRenderer textRenderer) 
    {
        if (dragging)
        {
            x = mouseX - startX;
            y = mouseY - startY;
        }
        drawContext.fill(x, y, x+width, collapsed ? y+16 : y+height, category.color);
        drawContext.fill(x+2, y+2, x+(width-2), y+14, hovered(mouseX, mouseY) ? 0xFF333333 : 0xFF222222);
        drawContext.drawGuiTexture(RenderLayer::getGuiTextured, icon, x+2, y+2, 12, 12);
        drawContext.drawText(textRenderer, category.name, x+16, y+4, 0xFFFFFFFF, false);
        if (!collapsed)
        {
            int buttonYOffset = y+16;
            for (ModuleButton m : moduleButtons)
            {
                m.render(drawContext, mouseX, mouseY, x+2, buttonYOffset, textRenderer);
                buttonYOffset += 12;
            }
        }
    }

    public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x+2 && mouseX <= x+(width-2) && mouseY >= y+2 && mouseY <= y+14;
	}

    public void mouseClicked(int mouseX, int mouseY, int button) 
	{
		for (ModuleButton moduleButton : moduleButtons)
		{
			if (moduleButton.mouseClicked(mouseX, mouseY, button)) return;
		}
        if (hovered(mouseX, mouseY) && button == 1) collapsed = !collapsed;
        else if (hovered(mouseX, mouseY) && button == 0)
        {
            startX = (int)mouseX-x;
            startY = (int)mouseY-y;
            dragging = true;
        }
	}

    public void mouseReleased(int mouseX, int mouseY, int button) 
	{
		dragging = false;
	}
}
