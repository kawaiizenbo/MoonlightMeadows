package me.kawaiizenbo.moonlight.module.settings;

import me.kawaiizenbo.moonlight.util.MathUtils;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class DoubleSetting extends Setting
{
    public double value;
    private double min, max;
    private int roundingPlace;

    boolean sliding = false;

    public DoubleSetting(String name, double value, double min, double max, int roundingPlace)
    {
        this.name = name;
        this.value = value;
        this.min = min;
        this.max = max;
        this.roundingPlace = roundingPlace;
    }

    @Override
    public void render(MatrixStack matrices, int x, int y, int mouseX, int mouseY) 
    {
        super.render(matrices, x, y, mouseX, mouseY);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(name), x+2, y+2, 0xFFFFFF);
        double diff = Math.min(100, Math.max(0, (mouseX - x)/1.9));

        if (sliding) 
        {
			if (diff == 0) 
            {
				value = min;
			}
			else 
            {
				double newValue = MathUtils.round(((diff / 100) * (max - min) + min), roundingPlace);
				value = newValue;
			}
		}

        String valueString = ""+MathUtils.round(value, roundingPlace);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(valueString), (x+190)-textRenderer.getWidth(valueString), y+2, 0xFFFFFF);
        DrawableHelper.fill(matrices, x+2, y+16, x+190, y+18, 0xFF666666);
        int scaledValue = (int)((value/max)*190);
        DrawableHelper.fill(matrices, x+2, y+16, (x+2)+scaledValue, y+18, 0xFF55FFFF);
        DrawableHelper.fill(matrices, x+2+(scaledValue-1), y+14, x+2+(scaledValue+1), y+20, 0xFFFFFFFF);
    }

    @Override
	public void mouseClicked(double mouseX, double mouseY, int button) 
    {
		if (hovered((int)mouseX, (int)mouseY) && button == 0) 
        {
			this.sliding = true;
		}
	}
	
	@Override
	public void mouseReleased(double mouseX, double mouseY, int button) 
    {
		sliding = false;
	}
    
}
