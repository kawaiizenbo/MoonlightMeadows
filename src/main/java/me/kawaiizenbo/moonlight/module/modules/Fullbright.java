package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.util.ISimpleOption;

public class Fullbright extends Module_ 
{
    public Fullbright()
    {
        super("Fullbright", "Allows you to see in the dark.", Category.RENDER);
    }

    @Override
    public void onEnable()
    {
        ((ISimpleOption<Double>)(Object)mc.options.getGamma()).setValueUnrestricted(100.0);
    }

    @Override
    public void onDisable()
    {
        mc.options.getGamma().setValue(1.0);
    }
}
