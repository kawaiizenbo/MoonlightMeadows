package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;
import me.kawaiizenbo.moonlight.util.Timer;

public class ChatSpammer extends Module 
{
    public StringSetting message = new StringSetting("Message", "E4PE4J");
    public DoubleSetting delay = new DoubleSetting("Delay (Seconds)", 1, 0.1, 10, 1);
    private Timer timer = new Timer();

    public ChatSpammer()
    {
        super("Chat Spammer", "Spams a selected message in chat.", Category.CHAT);
        settings.add(message);
        settings.add(delay);
    }

    @Override
    public void tick()
    {
        if (timer.hasTimeElapsed((long)delay.value * 1000, true)) 
        {
        	mc.player.networkHandler.sendChatMessage(message.value);
        }
    }
}
