package me.kawaiizenbo.moonlight.module;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.modules.*;

public class ModuleManager 
{
    public static ModuleManager INSTANCE = new ModuleManager();
    public ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager()
    {
        registerModules(
			new Fly(),
			new NoFall(),
			new HUDModule(),
			new Step(),
			new Fullbright(),
			new Speed(),
			new ModulesList(),
			new ChatSpammer(),
			new Rotation(),
			new AutoJump(),
			new Timer()
		);
    }
	
	private void registerModules(Module... modules) 
	{
		for (Module module : modules) {
			this.modules.add(module);
		}
	}

    public Module getModuleByName(String moduleName) 
	{
		for(Module module : modules) 
		{
			if ((module.name.trim().equalsIgnoreCase(moduleName)))
			{
				return module;
			}
		}
		return null;
	}

	public ArrayList<Module> getModulesByCategory(Category category)
	{
		ArrayList<Module> returnedModules = new ArrayList<>();
		for(Module module : modules) 
		{
			if (module.category == category) 
			{
				returnedModules.add(module);
			}
		}
		return returnedModules;
	}

	public ArrayList<Module> getEnabledModules() 
	{
		ArrayList<Module> enabledModules = new ArrayList<>();
		for (Module module : modules) 
		{
			if (!module.enabled)
				continue;
			enabledModules.add(module);
		}
		return enabledModules;
	}
}
