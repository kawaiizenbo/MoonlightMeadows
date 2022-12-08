package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;

public class HUDModule extends Module_
{
    public HUDModule()
    {
        super("HUD", "Enables or disables the Moonlight HUD.", Category.RENDER);
        this.enabled = true;
    }    
}
