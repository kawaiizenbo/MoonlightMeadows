package me.kawaiizenbo.moonlight.ui;

import java.util.ArrayList;
import java.util.Comparator;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.MinecraftClient;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class ModulesListOverlay
{
    public static ModulesListOverlay INSTANCE = new ModulesListOverlay();
    private MinecraftClient mc = MinecraftClient.getInstance();
	TextRenderer textRenderer = mc.textRenderer; 
    private ArrayList<Module_> enabledModules = ModuleManager.INSTANCE.getEnabledModules();

    public void render(DrawContext drawContext, int scaledWidth, int scaledHeight)
    {
        // do not draw if F3 enabled
        if (mc.options.debugEnabled) return;
        
        int yOffset = 0;
        for (Module_ m : enabledModules)
        {
            if (!m.showInModulesList.value) continue;
            int nameWidth = textRenderer.getWidth(m.name);
            drawContext.fill(scaledWidth - nameWidth - 8, yOffset, scaledWidth, yOffset+12, 0x55222222);
            drawContext.fill(scaledWidth - 2, yOffset, scaledWidth, yOffset+12, Moonlight.uiColorA);
            drawContext.drawText(textRenderer, m.name, scaledWidth - nameWidth - 4, yOffset + 2, 0xFFFFFFFF, false);
            yOffset += 12;
        }
    }

    public void update()
    {
        enabledModules = ModuleManager.INSTANCE.getEnabledModules();
    }
}
