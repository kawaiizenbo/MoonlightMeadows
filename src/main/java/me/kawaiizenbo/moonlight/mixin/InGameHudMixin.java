package me.kawaiizenbo.moonlight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.ui.HUDOverlay;
import me.kawaiizenbo.moonlight.ui.ModulesListOverlay;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    
	@Inject(at = @At("TAIL"), method = "render") 
	public void onRender (DrawContext drawContext, RenderTickCounter tickCounter, CallbackInfo info) 
    {
		if (ModuleManager.INSTANCE.getModuleByName("HUD").enabled) HUDOverlay.INSTANCE.render(drawContext, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
		if (ModuleManager.INSTANCE.getModuleByName("ModulesList").enabled) ModulesListOverlay.INSTANCE.render(drawContext, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
	}

}
