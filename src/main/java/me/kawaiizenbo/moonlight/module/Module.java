package me.kawaiizenbo.moonlight.module;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import me.kawaiizenbo.moonlight.module.settings.KeycodeSetting;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.ui.ModulesListOverlay;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;

public abstract class Module 
{
    protected static MinecraftClient mc = MinecraftClient.getInstance();
    public String name;
    public String description;
    public Category category;
    public boolean enabled;
    public ArrayList<Setting> settings;
    
    public BooleanSetting showInModulesList = new BooleanSetting("Show in Modules List", true);
    public KeycodeSetting keybind = new KeycodeSetting("Keybind", 0);

    public Module(String name, String description, Category category)
    {
        this.name = name;
        this.description = description;
        this.category = category;
        settings = new ArrayList<>();
        settings.add(showInModulesList);
        settings.add(keybind);
    }

    public void onEnable() { ModulesListOverlay.INSTANCE.update(); }
    public void onDisable() { ModulesListOverlay.INSTANCE.update(); }
    public void onMotion(MovementType type, Vec3d movement) {}
    public void tick() {}

    public void toggle() 
    {
		enabled = !enabled;
		if(enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}

    public Setting getSettingByName(String settingName)
    {
        for(Setting setting : settings) 
		{
			if ((setting.name.trim().equalsIgnoreCase(settingName)))
			{
				return setting;
			}
		}
		return null;
    }

    protected void addSettings(Setting... settings)
    {
        for(Setting setting : settings)
        {
            this.settings.add(setting);
        }
    }
}
