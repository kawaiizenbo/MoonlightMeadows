package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.util.ISimpleOption;

public class Fullbright extends Module 
{
    public Fullbright()
    {
        super("Fullbright", "Allows you to see in the dark.", Category.RENDER);
    }

    @Override
    public void onEnable()
    {
        super.onEnable();
        ((ISimpleOption<Double>)(Object)mc.options.getGamma()).setValueUnrestricted(100.0);
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        mc.options.getGamma().setValue(1.0);
    }
}
