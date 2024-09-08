package me.kawaiizenbo.moonlight.ui.hud;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.settings.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class HUDModule 
{
    public int x, y, height, width;
    public String name;
    int startX, startY;
    boolean dragging = false;
    public boolean enabled = false;
    public ArrayList<Setting> settings;
    
    protected static MinecraftClient mc = MinecraftClient.getInstance();

    public HUDModule(String name, int x, int y)
    {
    	this.name = name;
        this.x = x;
        this.y = y;
        settings = new ArrayList<>();
    }

    public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
    {
    	if (editMode)
    	{
    		if (dragging)
            {
                x = mouseX - startX;
                y = mouseY - startY;
            }
    		drawContext.fill(x-1, y-1, x+width+1, y+height+1, enabled ? 0xFF55FFFF : 0xFF555555);
    		drawContext.fill(x, y, x+width, y+height, 0xFF222222);
    	}
    }

    public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x+width && mouseY >= y && mouseY <= y+height;
	}

    public void mouseClicked(int mouseX, int mouseY, int button) 
	{
        if (hovered(mouseX, mouseY) && button == 0)
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

    public void toggle() 
    {
		enabled = !enabled;
	}
}
