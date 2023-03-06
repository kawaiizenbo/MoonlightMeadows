package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;

public class HUDModule extends Module_
{
    public BooleanSetting enableLogo = new BooleanSetting("Logo", true);
    public BooleanSetting enableFPS = new BooleanSetting("FPS", true);
    public BooleanSetting enablePing = new BooleanSetting("Ping", true);
    public BooleanSetting enableSpeed = new BooleanSetting("Speed", true);
    public BooleanSetting enableCoordinates = new BooleanSetting("Coordinates", true);

    public HUDModule()
    {
        super("HUD", "Enables or disables the Moonlight HUD.", Category.RENDER);
        this.enabled = true;
        settings.add(enableLogo);
        settings.add(enableFPS);
        settings.add(enablePing);
        settings.add(enableSpeed);
        settings.add(enableCoordinates);
    }    
}
