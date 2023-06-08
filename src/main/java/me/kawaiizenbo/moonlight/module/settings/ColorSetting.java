package me.kawaiizenbo.moonlight.module.settings;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class ColorSetting extends Setting
{
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
    public void render(MatrixStack matrices, int x, int y, int mouseX, int mouseY) 
    {
        super.render(matrices, x, y, mouseX, mouseY);
        DrawContext.drawTextWithShadow(matrices, textRenderer, Text.literal(name), x+2, y+2, 0xFFFFFF);
        int redDisplayStartColor = ((255&0x0ff)<<24)|((0&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
        int redDisplayEndColor = ((255&0x0ff)<<24)|((255&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
        int greenDisplayStartColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((0&0x0ff)<<8)|(b&0x0ff);
        int greenDisplayEndColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((255&0x0ff)<<8)|(b&0x0ff);
        int blueDisplayStartColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(0&0x0ff);
        int blueDisplayEndColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(255&0x0ff);
        DrawContext.fillGradient(matrices, x+80, y+2, x+92, y+62, redDisplayEndColor, redDisplayStartColor, 0);
        DrawContext.fillGradient(matrices, x+95, y+2, x+107, y+62, greenDisplayEndColor, greenDisplayStartColor, 0);
        DrawContext.fillGradient(matrices, x+110, y+2, x+122, y+62, blueDisplayEndColor, blueDisplayStartColor, 0);
        textRenderer.drawWithShadow(matrices, Text.literal("Red: " + r), x+130, y+10, 0xFFFFFFFF);
        textRenderer.drawWithShadow(matrices, Text.literal("Green: " + g), x+130, y+26, 0xFFFFFFFF);
        textRenderer.drawWithShadow(matrices, Text.literal("Blue: " + b), x+130, y+42, 0xFFFFFFFF);
    }
}
