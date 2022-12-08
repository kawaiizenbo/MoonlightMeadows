package me.kawaiizenbo.moonlight.module.settings;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;

public class Setting 
{
    public String name;
    protected TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

    public void render(MatrixStack matrices, int x, int y, int mouseX, int mouseY) { }
}
