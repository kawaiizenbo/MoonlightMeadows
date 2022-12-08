package me.kawaiizenbo.moonlight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.ui.HUD;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameHud.class)
public class InGameHudMixin {

	@Shadow private int scaledWidth;
    @Shadow private int scaledHeight;
    
	@Inject(at = @At("TAIL"), method = "render") 
	public void onRender (MatrixStack matrices, float tickDelta, CallbackInfo info) 
    {
		if (ModuleManager.INSTANCE.getModuleByName("HUD").enabled) HUD.INSTANCE.renderHUD(matrices, scaledWidth, scaledHeight);
	}

}
