package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;

public class AutoWalk extends Module
{

    public AutoWalk()
    {
        super("Auto Walk", "Automatically moves forward.", Category.MOVEMENT);
    }

    @Override
    public void tick()
    {
        mc.options.forwardKey.setPressed(true);
    }
    
    @Override
    public void onDisable() 
    {
    	super.onDisable();
    	mc.options.forwardKey.setPressed(false);
    }
}
