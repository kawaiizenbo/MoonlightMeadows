package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.util.Timer;

public class AutoJump extends Module
{
    public DoubleSetting delay = new DoubleSetting("Delay (Seconds)", 1, 0.1, 10, 1);
    private Timer timer = new Timer();

    public AutoJump()
    {
        super("Auto Jump", "Automatically jumps on a timer.", Category.MOVEMENT);
        settings.add(delay);
    }

    @Override
    public void tick()
    {
        if (timer.hasTimeElapsed((long)delay.value * 1000, true) && mc.player.isOnGround() && mc.player.hasVehicle() == false) 
        {
        	mc.player.jump();
        }
    }
}
