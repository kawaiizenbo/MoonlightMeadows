package me.kawaiizenbo.moonlight.ui;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module;
import net.minecraft.client.MinecraftClient;

import net.minecraft.client.gui.DrawContext;

public class ModulesListOverlay
{
    public static ModulesListOverlay INSTANCE = new ModulesListOverlay();
    private MinecraftClient mc = MinecraftClient.getInstance();
    private ArrayList<Module> enabledModules = ModuleManager.INSTANCE.getEnabledModules();

    public void render(DrawContext drawContext, int scaledWidth, int scaledHeight)
    {
        // do not draw if F3 enabled
        if (mc.getDebugHud().shouldShowDebugHud()) return;
        
        int yOffset = 0;
        for (Module m : enabledModules)
        {
            if (!m.showInModulesList.value) continue;
            int nameWidth = mc.textRenderer.getWidth(m.name);
            drawContext.fill(scaledWidth - nameWidth - 8, yOffset, scaledWidth, yOffset+12, 0x55222222);
            drawContext.fill(scaledWidth - 2, yOffset, scaledWidth, yOffset+12, Moonlight.uiColorA);
            drawContext.drawText(mc.textRenderer, m.name, scaledWidth - nameWidth - 4, yOffset + 2, 0xFFFFFFFF, false);
            yOffset += 12;
        }
    }

    public void update()
    {
        enabledModules = ModuleManager.INSTANCE.getEnabledModules();
    }
}
