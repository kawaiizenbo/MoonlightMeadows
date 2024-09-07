package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;

public class HUDEnabler extends Module 
{
	public BooleanSetting legacyHud = new BooleanSetting("Legacy HUD", true);
	
    public HUDEnabler()
    {
        super("HUD", "The Moonlight HUD.", Category.RENDER);
        this.enabled = true;
        this.showInModulesList.value = false;
        this.showEditButton = true;
        settings.add(legacyHud);
    }    
}
