package me.kawaiizenbo.moonlight.module;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.settings.Setting;
import net.minecraft.client.MinecraftClient;

public abstract class Module_ 
{
    protected static MinecraftClient mc = MinecraftClient.getInstance();
    public String name;
    public String description;
    public Category category;
    public boolean enabled;
    public ArrayList<Setting> settings;
    public int keyBind;

    public Module_(String name, String description, Category category)
    {
        this.name = name;
        this.description = description;
        this.category = category;
        settings = new ArrayList<>();
    }

    public void onEnable() {}
    public void onDisable() {}
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
}
