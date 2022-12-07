package me.kawaiizenbo.moonlight.util;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ChatUtils 
{
    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void sendMsg(String message) 
    {
        sendMsg(null, null, Text.literal(message));
    }

    public static void sendMsg(@Nullable String prefixTitle, @Nullable Formatting prefixColor, Text msg) 
    {
        if (mc.world == null) return;

        //Text message = Text.literal("");
        //message.append(CommandManager.get().getPrefix());
        //if (prefixTitle != null) message.append(CommandManager.get().getPrefix());
        //message.append(msg);

        mc.inGameHud.getChatHud().addMessage(msg);
    }
}
