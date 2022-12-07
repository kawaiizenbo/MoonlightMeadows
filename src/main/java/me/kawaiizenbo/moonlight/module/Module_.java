package me.kawaiizenbo.moonlight.module;

import net.minecraft.client.MinecraftClient;

public abstract class Module_ 
{
    protected static MinecraftClient mc = MinecraftClient.getInstance();
    public String name;
    public String description;
    public boolean enabled;

    public Module_(String name, String description)
    {
        this.name = name;
        this.description = description;
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
