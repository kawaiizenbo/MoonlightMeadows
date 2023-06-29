package me.kawaiizenbo.moonlight.ui.clickgui;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class ModuleButton 
{
    public Module_ module;
	public int x, y, width, height = 0;
	private MinecraftClient mc = MinecraftClient.getInstance();
	private TextRenderer textRenderer = mc.textRenderer;
	
	public ModuleButton(Module_ module, int initialX, int initialY) 
    {
		this.module = module;
		this.x = initialX;
		this.y = initialY;
		this.width = 92;
		this.height = 12;
	}

    public void render(DrawContext drawContext, int mouseX, int mouseY) 
    {
		drawContext.fill(x, y, x + width, y + height, hovered(mouseX, mouseY) ? 0xFF333333 : 0xFF222222);
		drawContext.drawText(textRenderer, module.name, x+2, y+2, module.enabled ? Moonlight.uiColor : 0xFFFFFF, false);
	}
	
	public boolean hovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
	}
	
	public boolean mouseClicked(int mouseX, int mouseY, int button) 
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
			return true;
		}
		return false;
	}
}
