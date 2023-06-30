package me.kawaiizenbo.moonlight.ui.clickgui;

import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.ui.TextButton;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class SettingsScreen extends Screen 
{
    private Module_ module;
    private TextButton backButton;

    boolean dragging = false;
    int startX, startY, x = 4, y = 4, windowWidth = 224, windowHeight = 192;

    public SettingsScreen(Module_ module) 
    {
        super(Text.literal("Settings"));
        this.module = module;
    }

    @Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, float delta) 
	{
        this.renderBackground(drawContext);

        // move window if dragging
        if (dragging)
        {
            x = mouseX - startX;
            y = mouseY - startY;
        }
        drawContext.fill(x, y, x+windowWidth, y+windowHeight, 0xFF222222);
        drawContext.fill(x, y, x+windowWidth, y+16, module.category.color);
        drawContext.fill(x+2, y+2, x+(windowWidth-2), y+14, 0xFF222222);
        drawContext.drawCenteredTextWithShadow(textRenderer, "Module Settings: "+module.name, x+(windowWidth/2), y+4, 0xFFFFFF);
        drawContext.drawText(textRenderer, module.description, x+8, y+24, 0xFFFFFF, true);
        backButton = new TextButton(ColorUtils.underline + "< Back", x+4, y+4, 0xFFFFFF);
        backButton.render(drawContext, textRenderer, mouseX, mouseY);
		int yOffset = y+40;
		for (Setting setting : module.settings)
		{
			setting.render(drawContext, x+16, yOffset, mouseX, mouseY, textRenderer);
			yOffset += setting.height + 1;
		}
	}

    public boolean barHovered(int mouseX, int mouseY) 
    {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 16;
	}
    
    @Override
    public boolean shouldPause() 
    {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        if (barHovered((int)mouseX, (int)mouseY))
        {
            startX = (int)mouseX-x;
            startY = (int)mouseY-y;
            dragging = true;
        }
        backButton.mouseClicked((int)mouseX, (int)mouseY);
        for (Setting setting : module.settings)
        {
            setting.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button)
    {
        dragging = false;
        for (Setting setting : module.settings)
        {
            setting.mouseReleased(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        for (Setting setting : module.settings)
        {
            setting.keyPressed(keyCode, scanCode, modifiers);
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
