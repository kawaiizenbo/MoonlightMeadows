package me.kawaiizenbo.moonlight.mixin;

import java.util.concurrent.CompletableFuture;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.suggestion.Suggestions;

import me.kawaiizenbo.moonlight.command.CommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatInputSuggestor;
import net.minecraft.client.gui.screen.ChatInputSuggestor.SuggestionWindow;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.command.CommandSource;

@Mixin(ChatInputSuggestor.class)
public abstract class ChatInputSuggestorMixin
{

    @Shadow private ParseResults<CommandSource> parse;

    @Shadow @Final private TextFieldWidget textField;

    @Shadow @Final private MinecraftClient client;

    @Shadow private boolean completingSuggestions;

    @Shadow private CompletableFuture<Suggestions> pendingSuggestions;

    @Shadow private SuggestionWindow window;

    @Shadow abstract void showCommandSuggestions();

    @Inject(method = "refresh",
            at = @At(value = "INVOKE", target = "Lcom/mojang/brigadier/StringReader;canRead()Z", remap = false),
            cancellable = true,
            locals = LocalCapture.CAPTURE_FAILHARD)
    public void onRefresh(CallbackInfo ci, String string, StringReader reader) {
        String prefix = CommandManager.get().getPrefix();
        int length = prefix.length();
        if (reader.canRead(length) && reader.getString().startsWith(prefix, reader.getCursor())) {
            reader.setCursor(reader.getCursor() + length);
            assert this.client.player != null;
            CommandDispatcher<CommandSource> commandDispatcher = CommandManager.get().getDispatcher();
            if (this.parse == null) {
                this.parse = commandDispatcher.parse(reader, CommandManager.get().getCommandSource());
            }

            int cursor = textField.getCursor();
            if (cursor >= 1 && (this.window == null || !this.completingSuggestions)) {
                this.pendingSuggestions = commandDispatcher.getCompletionSuggestions(this.parse, cursor);
                this.pendingSuggestions.thenRun(() -> {
                    if (this.pendingSuggestions.isDone()) {
                        showCommandSuggestions();
                    }
                });
            }
            ci.cancel();
        }
    }

}
