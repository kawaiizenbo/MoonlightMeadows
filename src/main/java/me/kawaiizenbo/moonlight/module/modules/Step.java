package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;

public class Step extends Module_
{
    DoubleSetting stepHeight = new DoubleSetting("Height", 1, 1, 10, 0);

    public Step()
    {
        super("Step", "Allows you to step up full blocks.", Category.MOVEMENT);
        settings.add(stepHeight);
    }

    @Override
    public void tick()
    {
        mc.player.setStepHeight((float)stepHeight.value);
    }

    @Override
    public void onDisable()
    {
        mc.player.setStepHeight(0.5f);
    }
}
