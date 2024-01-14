package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;

public class Reach extends Module
{
    public Reach()
    {
        super("Reach", "Extends player reach.", Category.PLAYER);
    }

    @Override
    public void onEnable()
    {
        super.onEnable();
        // this will be completed in 1.20.5, as a new attribute will be added to make this trivial.
        // mc.player.getAbilities().
    }
}
