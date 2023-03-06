package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;

public class Fullbright extends Module_ 
{
    public Fullbright()
    {
        super("Fullbright", "Allows you to see in the dark.", Category.RENDER);
    }

    @Override
    public void onEnable()
    {
        // i dont know why but this makes it darker than 1.0
        mc.options.getGamma().setValue(100.0);
    }

    @Override
    public void onDisable()
    {
        mc.options.getGamma().setValue(1.0);
    }
}
