package me.kawaiizenbo.moonlight.ui.clickgui;

import me.kawaiizenbo.moonlight.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class ModuleButton 
{
    public Module module;
	public int x, y, width, height = 0;
	
	public ModuleButton(Module module) 
    {
		this.module = module;
		this.width = 92;
		this.height = 12;
	}

    public void render(DrawContext drawContext, int mouseX, int mouseY, int x, int y, TextRenderer textRenderer) 
    {
		this.x = x;
		this.y = y;
		drawContext.fill(x, y, x + width, y + height, hovered(mouseX, mouseY) ? 0xFF333333 : 0xFF222222);
		drawContext.drawText(textRenderer, module.name, x+2, y+2, module.enabled ? 0x55FFFF : 0xFFFFFF, false);
		if (!module.settings.isEmpty()) drawContext.drawGuiTexture(Identifier.of("moonlight", "settings"), x+width-12, y, 12, 12);
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
