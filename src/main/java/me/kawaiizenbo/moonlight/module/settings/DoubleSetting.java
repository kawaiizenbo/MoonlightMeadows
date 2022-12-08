package me.kawaiizenbo.moonlight.module.settings;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class DoubleSetting extends Setting
{
    public double value;
    private double min, max, increment;

    public DoubleSetting(String name, double value, double min, double max, double increment)
    {
        this.name = name;
        this.value = value;
        this.min = min;
        this.max = max;
        this.increment = increment;
    }

    @Override
    public void render(MatrixStack matrices, int x, int y, int mouseX, int mouseY) 
    { 
        DrawableHelper.fill(matrices, x, y, x+192, y+24, hovered(mouseX, mouseY, x, y) ? 0xFF444444: 0xFF222222);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(name), x+2, y+2, 0xFFFFFF);
        String valueString = ""+round(value, 1);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(valueString), (x+190)-textRenderer.getWidth(valueString), y+2, 0xFFFFFF);
        DrawableHelper.fill(matrices, x+2, y+16, x+190, y+18, 0xFF666666);
        int scaledValue = (int)((value/max)*190);
        DrawableHelper.fill(matrices, x+2, y+16, (x+2)+scaledValue, y+18, 0xFF55FFFF);
        DrawableHelper.fill(matrices, x+2+(scaledValue-1), y+14, x+2+(scaledValue+1), y+20, 0xFFFFFFFF);
    }

    public boolean hovered(int mouseX, int mouseY, int x, int y) 
    {
		return mouseX >= x && mouseX <= x + 192 && mouseY >= y && mouseY <= y + 24;
	}

    private static double round(double value, int places) 
    {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
