package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.ColorSetting;

public class HUDModule extends Module_
{
    public ColorSetting color = new ColorSetting("Color", 0x55FFFF);
    public HUDModule()
    {
        super("HUD", "Enables or disables the Moonlight HUD.", Category.RENDER);
        this.enabled = true;
        settings.add(color);
    }    
}
