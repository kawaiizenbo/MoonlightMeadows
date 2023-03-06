package me.kawaiizenbo.moonlight.ui;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.modules.HUDModule;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import me.kawaiizenbo.moonlight.util.MathUtils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;

public class HUD 
{
    public static HUD INSTANCE = new HUD();
	private MinecraftClient mc = MinecraftClient.getInstance();
	TextRenderer textRenderer = mc.textRenderer;
    HUDModule hm = (HUDModule)ModuleManager.INSTANCE.getModuleByName("HUD");

    public void renderHUD(MatrixStack matrix, int scaledWidth, int scaledHeight)
    {
        // do not draw if F3 enabled
        if (mc.options.debugEnabled) return;

        // draw stats
        if (hm.enableLogo.value) 
            textRenderer.drawWithShadow(matrix, Moonlight.clientTag + " " + Moonlight.versionTag, 2, 2, 16777215);
        if (hm.enableFPS.value)
		    textRenderer.drawWithShadow(matrix, "FPS: " + ColorUtils.gray + mc.fpsDebugString.split(" ")[0], 2, 12, 0x55FFFF);
        if (hm.enablePing.value)
		    textRenderer.drawWithShadow(matrix, "Ping: " + ColorUtils.gray + (mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()) == null ? 0 : mc.getNetworkHandler().getPlayerListEntry(mc.player.getUuid()).getLatency()), 2, 22, 0x55FFFF);
        
        if (hm.enableSpeed.value)
		    textRenderer.drawWithShadow(matrix, "Meters/s: " + ColorUtils.gray + MathUtils.round(moveSpeed(), 2), 2, scaledHeight - 20, 0x55FFFF);

        if (hm.enableCoordinates.value)
            textRenderer.drawWithShadow(matrix, "X: " + ColorUtils.gray + MathUtils.round(mc.player.getX(), 1) + 
            ColorUtils.reset + " Y: " + ColorUtils.gray + MathUtils.round(mc.player.getY(), 1) + 
            ColorUtils.reset + " Z: " + ColorUtils.gray + MathUtils.round(mc.player.getZ(), 1), 2, scaledHeight - 10, 0x55FFFF);
    }

    private double moveSpeed() 
    {
        Vec3d move = new Vec3d(mc.player.getX() - mc.player.prevX, 0, mc.player.getZ() - mc.player.prevZ).multiply(20);

        return Math.abs(MathUtils.length2D(move)) ;
    }
}
