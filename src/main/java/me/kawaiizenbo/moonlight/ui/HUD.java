package me.kawaiizenbo.moonlight.ui;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.modules.HUDModule;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import me.kawaiizenbo.moonlight.util.MathUtils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.Vec3d;

public class HUD 
{
    public static HUD INSTANCE = new HUD();
	private MinecraftClient mc = MinecraftClient.getInstance();
	TextRenderer textRenderer = mc.textRenderer;
    public int hudColor = ColorUtils.rgbaToInt(
        (int)((HUDModule)ModuleManager.INSTANCE.getModuleByName("HUD")).r.value,
        (int)((HUDModule)ModuleManager.INSTANCE.getModuleByName("HUD")).g.value,
        (int)((HUDModule)ModuleManager.INSTANCE.getModuleByName("HUD")).b.value,
        255 );

    public void renderHUD(DrawContext drawContext, int scaledWidth, int scaledHeight)
    {
        // do not draw if F3 enabled
        if (mc.options.debugEnabled) return;

        // draw stats
        drawContext.drawTextWithShadow(textRenderer, Moonlight.clientTag + " " + Moonlight.versionTag, 2, 2, 16777215);
		drawContext.drawTextWithShadow(textRenderer, "FPS: " + ColorUtils.gray + mc.fpsDebugString.split(" ")[0], 2, 12, hudColor);
		drawContext.drawTextWithShadow(textRenderer, "Ping: " + ColorUtils.gray + (mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()) == null ? 0 : mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()).getLatency()), 2, 22, hudColor);
		drawContext.drawTextWithShadow(textRenderer, "Meters/s: " + ColorUtils.gray + MathUtils.round(moveSpeed(), 2), 2, scaledHeight - 20, hudColor);

        // draw coordinates
        drawContext.drawTextWithShadow(textRenderer, "X: " + ColorUtils.gray + MathUtils.round(mc.player.getX(), 1) + 
            ColorUtils.reset + " Y: " + ColorUtils.gray + MathUtils.round(mc.player.getY(), 1) + 
            ColorUtils.reset + " Z: " + ColorUtils.gray + MathUtils.round(mc.player.getZ(), 1), 2, scaledHeight - 10, hudColor);
    }

    private double moveSpeed() 
    {
        Vec3d move = new Vec3d(mc.player.getX() - mc.player.prevX, 0, mc.player.getZ() - mc.player.prevZ).multiply(20);

        return Math.abs(MathUtils.length2D(move)) ;
    }
}
