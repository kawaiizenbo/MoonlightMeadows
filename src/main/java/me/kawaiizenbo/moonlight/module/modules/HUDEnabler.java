package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.IndexSetting;

public class HUDEnabler extends Module 
{
	public IndexSetting mode = new IndexSetting("Mode", 0, "Modular", "Legacy");
	
    public HUDEnabler()
    {
        super("HUD", "The Moonlight HUD.", Category.RENDER);
        this.enabled = true;
        this.showInModulesList.value = false;
        this.showEditButton = true;
        settings.add(mode);
    }    
}
