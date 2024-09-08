package me.kawaiizenbo.moonlight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.modules.HUDEnabler;
import me.kawaiizenbo.moonlight.ui.LegacyHUD;
import me.kawaiizenbo.moonlight.ui.ModulesListOverlay;
import me.kawaiizenbo.moonlight.ui.hud.HUDRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    
	@Inject(at = @At("TAIL"), method = "render") 
	public void onRender (DrawContext drawContext, RenderTickCounter tickCounter, CallbackInfo info) 
    {
		HUDEnabler hudModule = (HUDEnabler)ModuleManager.INSTANCE.getModuleByName("HUD");
		if (hudModule.enabled) 
		{
			if (hudModule.legacyHud.value) LegacyHUD.INSTANCE.render(drawContext, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
			else HUDRenderer.INSTANCE.render(drawContext);
		}
		if (ModuleManager.INSTANCE.getModuleByName("ModulesList").enabled) ModulesListOverlay.INSTANCE.render(drawContext, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
	}

}
