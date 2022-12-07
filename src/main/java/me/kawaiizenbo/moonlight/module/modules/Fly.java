package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;

public class Fly extends Module_ 
{

    public Fly() 
    {
        super("Fly", "Allows you to fly in survival mode.", Category.MOVEMENT);
    }
    
    @Override
    public void tick()
    {
        mc.player.getAbilities().flying = true;
    }

    @Override
    public void onDisable()
    {
        mc.player.getAbilities().flying = false;
    }
}
