package me.kawaiizenbo.moonlight.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;

import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.ModuleManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin 
{
    @Inject(at = @At("HEAD"), method = "tick()V")
	private void init(CallbackInfo info) 
    {
		for (Module_ mod : ModuleManager.INSTANCE.getEnabledModules()) 
        {
			if (MinecraftClient.getInstance().player != null) mod.tick();
		}
	}
}
