package me.kawaiizenbo.moonlight.mixin;

import me.kawaiizenbo.moonlight.Moonlight;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen 
{ 
    @Shadow
    @Final
    private boolean doBackgroundFade;

    @Shadow
    @Final
    private long backgroundFadeStart;

    public TitleScreenMixin() 
    {
        super(null);
    }

    @Inject(at = @At("TAIL"), method = "render")
    private void clientTag(DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo info) 
    {
        float f = this.doBackgroundFade ? (Util.getMeasuringTimeMs() - this.backgroundFadeStart) / 1000.0F : 1.0F;
        float g = this.doBackgroundFade ? MathHelper.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = MathHelper.ceil(g * 255.0F) << 24;

        drawContext.drawTextWithShadow(this.textRenderer, Moonlight.clientTag + " " + Moonlight.versionTag, 2, 2, 16777215 | l);
    }
}
