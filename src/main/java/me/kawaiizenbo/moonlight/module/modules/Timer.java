package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import net.minecraft.client.render.RenderTickCounter;
import me.kawaiizenbo.moonlight.module.Category;

public class Timer extends Module 
{
    public DoubleSetting speed = new DoubleSetting("Speed", 1.5, 0.1, 10, 1);
    double current = speed.value;
    public Timer()
    {
        super("Timer", "Changes the number of ticks per second", Category.WORLD);
        settings.add(speed);
    }

    @Override 
    public void onEnable()
    {
        super.onEnable();
        mc.renderTickCounter = new RenderTickCounter((float)(20.0*speed.value), 0L);
        current = speed.value;
    }

    @Override
    public void tick()
    {
        if (current != speed.value) onEnable();
    }

    @Override 
    public void onDisable()
    {
        super.onDisable();
        mc.renderTickCounter = new RenderTickCounter(20.0f, 0L);
    }
}
