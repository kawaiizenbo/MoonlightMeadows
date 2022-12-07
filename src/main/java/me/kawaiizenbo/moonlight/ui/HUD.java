package me.kawaiizenbo.moonlight.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class HUD 
{
    public static HUD INSTANCE = new HUD();
	private MinecraftClient mc = MinecraftClient.getInstance();
	TextRenderer textRenderer = mc.textRenderer;

    public void renderHUD(MatrixStack matrix, int scaledWidth, int scaledHeight)
    {
        // do not draw if F3 enabled
        if (mc.options.debugEnabled) return;

        // draw stats
        textRenderer.drawWithShadow(matrix, Moonlight.clientTag + " " + Moonlight.versionTag, 2, 2, 16777215);
		textRenderer.drawWithShadow(matrix, "FPS: " + ColorUtils.gray + mc.fpsDebugString.split(" ")[0], 2, 12, 0x55FFFF);
		textRenderer.drawWithShadow(matrix, "Ping: " + ColorUtils.gray + (mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()) == null ? 0 : mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()).getLatency()), 2, 22, 0x55FFFF);

		textRenderer.drawWithShadow(matrix, "Meters/s: " + ColorUtils.gray + round(moveSpeed(), 2), 2, scaledHeight - 20, 0x55FFFF);
        // Coords
        textRenderer.drawWithShadow(matrix, "X: " + ColorUtils.gray + round(mc.player.getX(), 1) + 
            ColorUtils.reset + " Y: " + ColorUtils.gray + round(mc.player.getY(), 1) + 
            ColorUtils.reset + " Z: " + ColorUtils.gray + round(mc.player.getZ(), 1), 2, scaledHeight - 10, 0x55FFFF);
    }

    private static double round(double value, int places) 
    {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private double moveSpeed() 
    {
        Vec3d move = new Vec3d(mc.player.getX() - mc.player.prevX, 0, mc.player.getZ() - mc.player.prevZ).multiply(20);

        return Math.abs(length2D(move)) ;
    }

    public double length2D(Vec3d vec3d) 
    {
        return MathHelper.sqrt((float)(vec3d.x * vec3d.x + vec3d.z * vec3d.z));
    }
}
