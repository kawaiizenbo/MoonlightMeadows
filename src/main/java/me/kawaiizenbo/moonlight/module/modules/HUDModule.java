package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.ui.HUD;
import me.kawaiizenbo.moonlight.util.ReflectionUtils;

public class HUDModule extends Module_ 
{
    public DoubleSetting r = new DoubleSetting("Red", 0x55, 0, 255, 0, ReflectionUtils.tryGetMethod("updateHUD", getClass()));
    public DoubleSetting g = new DoubleSetting("Green", 255, 0, 255, 0, ReflectionUtils.tryGetMethod("updateHUD", getClass()));
    public DoubleSetting b = new DoubleSetting("Blue", 255, 0, 255, 0, ReflectionUtils.tryGetMethod("updateHUD", getClass()));
    //public ColorSetting color = new ColorSetting("Color", 0x55FFFF, ReflectionUtils.tryGetMethod("updateHUD", getClass()));
    public HUDModule()
    {
        super("HUD", "Enables or disables the Moonlight HUD.", Category.RENDER);
        this.enabled = true;
        settings.add(r);
        settings.add(g);
        settings.add(b);
        //settings.add(color);
    }    

    public static void updateHUD()
    {
        HUD.INSTANCE = new HUD();
    }
}
