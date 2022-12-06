package me.kawaiizenbo.moonlight.mixin;

import me.kawaiizenbo.moonlight.ui.AltManagerScreen;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin extends Screen 
{
    protected MultiplayerScreenMixin(Text title) 
    {
        super(title);
    }
    
    @Inject(at = @At("TAIL"), method = "init")
	private void altManagerButton(int y, int spacingY, CallbackInfo callbackInfo) 
    {
        this.addDrawableChild(new ButtonWidget(this.width - 102, 2, 100, 20, Text.literal("Alt Manager"), (button) -> {
            MinecraftClient.getInstance().setScreen(AltManagerScreen.INSTANCE);
       })).active = true;
	}
}
