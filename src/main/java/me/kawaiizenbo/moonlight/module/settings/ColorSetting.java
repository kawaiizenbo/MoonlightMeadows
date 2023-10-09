package me.kawaiizenbo.moonlight.module.settings;

import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ColorSetting extends Setting
{
    // this is unfinished, please use 3 DoubleSettings instead
    public int value;
    public int r;
    public int g;
    public int b;
    

    public ColorSetting(String name, int value)
    {
        this.name = name;
        this.value = value;
        this.height = 64;
        this.r = (value >> 16) & 0xFF;
        this.g = (value >> 8) & 0xFF;
        this.b = value & 0xFF;
    }

    @Override
    public void render(DrawContext drawContext, int x, int y, int mouseX, int mouseY, TextRenderer textRenderer) 
    {
        super.render(drawContext, x, y, mouseX, mouseY, textRenderer);
        drawContext.drawTextWithShadow(textRenderer, Text.literal(name), x+2, y+2, 0xFFFFFF);
        int redDisplayStartColor = ColorUtils.rgbaToInt(0, g, b, 255);
        int redDisplayEndColor = ColorUtils.rgbaToInt(255, g, b, 255);
        int greenDisplayStartColor = ColorUtils.rgbaToInt(r, 0, b, 255);
        int greenDisplayEndColor = ColorUtils.rgbaToInt(r, 255, b, 255);
        int blueDisplayStartColor = ColorUtils.rgbaToInt(r, g, 0, 255);
        int blueDisplayEndColor = ColorUtils.rgbaToInt(r, g, 255, 255);
        drawContext.fillGradient(x+80, y+2, x+92, y+62, redDisplayEndColor, redDisplayStartColor, 0);
        drawContext.fillGradient(x+95, y+2, x+107, y+62, greenDisplayEndColor, greenDisplayStartColor, 0);
        drawContext.fillGradient(x+110, y+2, x+122, y+62, blueDisplayEndColor, blueDisplayStartColor, 0);
        drawContext.drawTextWithShadow(textRenderer, Text.literal("Red: " + r), x+130, y+10, 0xFFFFFFFF);
        drawContext.drawTextWithShadow(textRenderer, Text.literal("Green: " + g), x+130, y+26, 0xFFFFFFFF);
        drawContext.drawTextWithShadow(textRenderer, Text.literal("Blue: " + b), x+130, y+42, 0xFFFFFFFF);
    }
}
