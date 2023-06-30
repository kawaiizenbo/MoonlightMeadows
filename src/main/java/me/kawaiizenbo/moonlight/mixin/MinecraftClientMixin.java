package me.kawaiizenbo.moonlight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import me.kawaiizenbo.moonlight.Moonlight;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin 
{
    @Inject(at = @At("TAIL"), method = "scheduleStop")
	public void onShutdown(CallbackInfo ci) {
		Moonlight.INSTANCE.saveConfig();
	}
}
