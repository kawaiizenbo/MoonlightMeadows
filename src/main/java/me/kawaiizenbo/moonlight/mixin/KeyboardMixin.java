package me.kawaiizenbo.moonlight.mixin;

import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.ui.clickgui.ClickGUIScreen;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;

@Mixin(Keyboard.class)
public abstract class KeyboardMixin 
{
    @Shadow @Final private MinecraftClient client;

	@Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo info) 
    {
        if (key == GLFW.GLFW_KEY_RIGHT_ALT) MinecraftClient.getInstance().setScreen(ClickGUIScreen.INSTANCE);
        for (Module m : ModuleManager.INSTANCE.modules)
        {
            if (key == m.keybind.value && action == GLFW.GLFW_PRESS && MinecraftClient.getInstance().currentScreen == null)
            {
                m.toggle();
            }
        }
    }
}
