package me.kawaiizenbo.moonlight.ui.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class HUDRenderer 
{
    public static HUDRenderer INSTANCE = new HUDRenderer();
	private MinecraftClient mc = MinecraftClient.getInstance();

    public void render(DrawContext drawContext)
    {
        // do not draw if F3 enabled
    	if (mc.getDebugHud().shouldShowDebugHud()) return;

        for (HUDModule h : HUDModuleManager.INSTANCE.modules)
        {
        	// mouse coords are not needed when not in edit mode
        	h.render(drawContext, 0, 0, mc.textRenderer, false);
        }
    }
}
