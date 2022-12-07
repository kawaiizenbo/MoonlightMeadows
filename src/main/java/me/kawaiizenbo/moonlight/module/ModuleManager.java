package me.kawaiizenbo.moonlight.module;

import java.util.ArrayList;

import me.kawaiizenbo.moonlight.module.modules.*;

public class ModuleManager 
{
    public static ModuleManager INSTANCE = new ModuleManager();
    public ArrayList<Module_> modules = new ArrayList<>();

    public ModuleManager()
    {
        registerModules(new Fly());
    }

    public void registerModule(Module_ module) {
		modules.add(module);
	}
	
	public void registerModules(Module_... modules) {
		for (Module_ module : modules) {
			this.modules.add(module);
		}
	}

    public Module_ getModuleByName(String moduleName) {
		for(Module_ mod : modules) {
			if ((mod.name.trim().equalsIgnoreCase(moduleName)) || (mod.toString().trim().equalsIgnoreCase(moduleName.trim()))) {
				return mod;
			}
		}
		return null;
	}

	public ArrayList<Module_> getEnabledModules() 
	{
		ArrayList<Module_> enabledModules = new ArrayList<>();
		for (Module_ module : modules) 
		{
			if (!module.enabled)
				continue;
			enabledModules.add(module);
		}
		return enabledModules;
	}
}
