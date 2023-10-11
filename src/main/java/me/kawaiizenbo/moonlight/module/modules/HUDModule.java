package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.ui.HUDOverlay;
import me.kawaiizenbo.moonlight.util.ColorUtils;

public class HUDModule extends Module 
{
    public BooleanSetting clientTag = new BooleanSetting("Client Tag", true);
    public DoubleSetting r = new DoubleSetting("Red", 0x55, 0, 255, 0);
    public DoubleSetting g = new DoubleSetting("Green", 255, 0, 255, 0);
    public DoubleSetting b = new DoubleSetting("Blue", 255, 0, 255, 0);
    //public ColorSetting color = new ColorSetting("Color", 0x55FFFF, ReflectionUtils.tryGetMethod("updateHUD", getClass()));

    public HUDModule()
    {
        super("HUD", "The Moonlight HUD. Toggle to update.", Category.RENDER);
        this.enabled = true;
        this.showInModulesList.value = false;
        
        settings.add(clientTag);
        settings.add(r);
        settings.add(g);
        settings.add(b);
        //settings.add(color);
    }    

    @Override
    public void onEnable()
    {
        super.onEnable();
        HUDOverlay.INSTANCE.showClientTag = clientTag.value;
        Moonlight.uiColorA = 
        ColorUtils.rgbaToInt(
            (int)r.value,
            (int)g.value,
            (int)b.value,
            255 
        );
        Moonlight.uiColor = 
        ColorUtils.rgbToInt(
            (int)r.value,
            (int)g.value,
            (int)b.value
        );
    }
}
