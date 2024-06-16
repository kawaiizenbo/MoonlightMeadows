package me.kawaiizenbo.moonlight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.entity.Entity;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin 
{
	
	@Inject(at = @At("HEAD"), method = "canWalkOnPowderSnow", cancellable = true)
	private static void canWalkOnPowderSnow(Entity entity, CallbackInfoReturnable<Boolean> cir) 
	{
        if (ModuleManager.INSTANCE.getModuleByName("Anti Powder Snow").enabled) cir.setReturnValue(true);
    }
}
