package me.kawaiizenbo.moonlight.ui.hud;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.ui.hud.modules.TestModuleHUD;

public class HUDModuleManager 
{
	public static HUDModuleManager INSTANCE = new HUDModuleManager();
    public ArrayList<HUDModule> modules = new ArrayList<>();

	public HUDModuleManager() 
	{
		registerModules(
			new TestModuleHUD(0, 0)
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
}
