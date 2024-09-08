package me.kawaiizenbo.moonlight.ui.hud;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.ui.hud.modules.*;

public class HUDModuleManager 
{
	public static HUDModuleManager INSTANCE = new HUDModuleManager();
    public ArrayList<HUDModule> modules = new ArrayList<>();

	public HUDModuleManager() 
	{
		registerModules(
			new ClientTag(2, 2),
			new FPS(2, 12),
			new Ping(2, 22),
			new MovementSpeed(2, 32),
			new Coordinates(2, 42)
		);
	}
	
	private void registerModules(HUDModule... modules) 
	{
		for (HUDModule module : modules) {
			this.modules.add(module);
		}
	}

    public HUDModule getModuleByName(String moduleName) 
	{
		for(HUDModule module : modules) 
		{
			if ((module.name.trim().equalsIgnoreCase(moduleName)))
			{
				return module;
			}
		}
		return null;
	}
    
    public ArrayList<HUDModule> getEnabledModules() 
	{
		ArrayList<HUDModule> enabledModules = new ArrayList<>();
		for (HUDModule module : modules) 
		{
			if (!module.enabled)
				continue;
			enabledModules.add(module);
		}
		return enabledModules;
	}
}
