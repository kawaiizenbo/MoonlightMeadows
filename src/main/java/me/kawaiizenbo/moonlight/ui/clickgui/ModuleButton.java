package me.kawaiizenbo.moonlight.ui.clickgui;

import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class ModuleButton 
{
    public Module_ module;
	public int x, y, width, height = 0;
	private MinecraftClient mc = MinecraftClient.getInstance();
	
	public ModuleButton(Module_ module, int x, int y) 
    {
		this.module = module;
		this.x = x;
		this.y = y;
		this.width = 70;
		this.height = 14;
	}

    public void render(DrawContext drawContext, int mouseX, int mouseY) 
    {
		TextRenderer textRenderer = mc.textRenderer;
		drawContext.fill(x, y, x + width, y + height, hovered(mouseX, mouseY) ? 0xFF333333 : 0xFF222222);
		drawContext.drawText(textRenderer, module.name, x+3, y+3, module.enabled ? 0x55FFFF : 0xFFFFFF, false);
	}
	
	public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}
	
	public void mouseClicked(int mouseX, int mouseY, int button) 
    {
		if (hovered(mouseX, mouseY)) 
        {
            if (button == 0)
            {
                module.toggle();
            }
		    else if (button == 1)
            {
                MinecraftClient.getInstance().setScreen(new SettingsScreen(module));
            }
		}
	}
}
