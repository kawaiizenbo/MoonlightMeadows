package me.kawaiizenbo.moonlight.module.settings;

import java.lang.reflect.Method;

import me.kawaiizenbo.moonlight.util.ReflectionUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class BooleanSetting extends Setting
{
    public boolean value;

    public BooleanSetting(String name, boolean value, Method onValueChanged)
    {
        this.name = name;
        this.value = value;
        this.onValueChanged = onValueChanged;
    }

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY) 
    {
        super.render(drawContext, x, y, mouseX, mouseY);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+8, 0xFFFFFF);
        drawContext.fill(x+175, y+7, x+185, y+17, 0xFFFFFFFF);
        drawContext.fill(x+176, y+8, x+184, y+16, 0xFF222222);
        drawContext.fill(x+177, y+9, x+183, y+15, value ? 0xFF55FFFF : 0xFF222222);
    }
    
    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			this.value = !value;
            ReflectionUtils.tryCallMethod(onValueChanged, new Object[0]);
		}
	}
}
