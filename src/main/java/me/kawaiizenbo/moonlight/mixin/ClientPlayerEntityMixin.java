package me.kawaiizenbo.moonlight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin 
{
    @Inject(method = "move", at = @At(value = "TAIL"), cancellable = true)
    public void onMove(MovementType type, Vec3d movement, CallbackInfo ci) 
    {
        for (Module_ m : ModuleManager.INSTANCE.getEnabledModules())
        {
            m.onMotion(type, movement);
        }
    }

    @Inject(method = "tick", at = @At(value = "HEAD"), cancellable = true)
    public void onTick(CallbackInfo ci) 
    {
        for (Module_ m : ModuleManager.INSTANCE.getEnabledModules()) 
        {
			if (MinecraftClient.getInstance().player != null) m.tick();
		}
    }

    @Inject(method = "init", at = @At(value = "TAIL"), cancellable = true)
    public void onInit(CallbackInfo ci) 
    {
        for (Module_ m : ModuleManager.INSTANCE.getEnabledModules()) 
        {
			m.onEnable();
		}
    }
}
