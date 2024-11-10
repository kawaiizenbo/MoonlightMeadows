package me.kawaiizenbo.moonlight.ui.hud.modules;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import me.kawaiizenbo.moonlight.util.MathUtils;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.Vec3d;

public class MovementSpeed extends HUDModule
{
	public MovementSpeed(int x, int y) 
	{
		super("Movement Speed", x, y);
		this.width = 72;
		this.height = 8;
		this.enabled = true;
	}

	@Override
	public void render(DrawContext drawContext, int mouseX, int mouseY, TextRenderer textRenderer, boolean editMode, boolean enabled) 
	{
		super.render(drawContext, mouseX, mouseY, textRenderer, editMode, enabled);
		drawContext.drawTextWithShadow(mc.textRenderer, "Meters/s: " + ColorUtils.gray + MathUtils.round(moveSpeed(), 2), x, y, Moonlight.THEME.hudAccent.getRGB());
	}
	
	private double moveSpeed() 
    {
        Vec3d move = new Vec3d(mc.player.getX() - mc.player.prevX, 0, mc.player.getZ() - mc.player.prevZ).multiply(20);
        return Math.abs(MathUtils.length2D(move)) ;
    }
}
