package me.kawaiizenbo.moonlight.module.settings;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.widget.TextFieldWidget;
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
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(name), x+2, y+2, 0xFFFFFF);
        int redDisplayStartColor = ((255&0x0ff)<<24)|((0&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
        int redDisplayEndColor = ((255&0x0ff)<<24)|((255&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
        int greenDisplayStartColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((0&0x0ff)<<8)|(b&0x0ff);
        int greenDisplayEndColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((255&0x0ff)<<8)|(b&0x0ff);
        int blueDisplayStartColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(0&0x0ff);
        int blueDisplayEndColor = ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(255&0x0ff);
        DrawableHelper.fillGradient(matrices, x+100, y+2, x+112, y+62, redDisplayEndColor, redDisplayStartColor, 0);
        DrawableHelper.fillGradient(matrices, x+115, y+2, x+127, y+62, greenDisplayEndColor, greenDisplayStartColor, 0);
        DrawableHelper.fillGradient(matrices, x+130, y+2, x+142, y+62, blueDisplayEndColor, blueDisplayStartColor, 0);
    }
}
