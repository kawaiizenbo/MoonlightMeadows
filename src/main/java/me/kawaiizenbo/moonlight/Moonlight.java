package me.kawaiizenbo.moonlight;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.module.settings.KeycodeSetting;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;
import me.kawaiizenbo.moonlight.ui.clickgui.CategoryPane;
import me.kawaiizenbo.moonlight.ui.clickgui.ClickGUIScreen;
import me.kawaiizenbo.moonlight.util.ColorUtils;

public class Moonlight implements ModInitializer 
{
	public static final Moonlight INSTANCE = new Moonlight();
	public static final Logger LOGGER = LoggerFactory.getLogger("Moonlight");
	public static final String clientTag = ColorUtils.aqua + "Moonlight Meadows";
	public static final String versionTag = ColorUtils.magenta + "v0.dev";
	public static Config CONFIG = new Config();
	public static int uiColorA = 0xFF55FFFF;
	public static int uiColor = 0x55FFFF;

	@Override
	public void onInitialize() 
	{
		LOGGER.info("Moonlight loading...");
		loadConfig();
	}

	public void loadConfig()
	{
		try
		{
			LOGGER.info("Loading config...");
			CONFIG.load();
			for (Module m : ModuleManager.INSTANCE.modules)
			{
				m.enabled = (boolean)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("enabled");
				if (m.enabled)
				{
					//m.onEnable();
					// this doesnt work, will probably need to mixin to client server connection or something
				}
				for (Setting s : m.settings)
				{
                	if (s instanceof BooleanSetting)
                	{
                    	((BooleanSetting)s).value = (boolean)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("settings")).get(s.name);
                	}
                	else if (s instanceof DoubleSetting)
                	{
                    	((DoubleSetting)s).value = (Double)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("settings")).get(s.name);
                	}
					else if (s instanceof StringSetting)
                	{
                    	((StringSetting)s).value = (String)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("settings")).get(s.name);
                	}
					else if (s instanceof KeycodeSetting)
                	{
                	    ((KeycodeSetting)s).value = ((Double)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("settings")).get(s.name)).intValue();
                	}
				}
			}
		}
		catch(Exception e)
		{
			LOGGER.warn("Config Error: " + e.getMessage());
			LOGGER.info("Loading default config...");
			CONFIG.loadDefaultConfig(); 
			CONFIG.save();
		}
	}

	public void saveConfig()
	{
		LOGGER.info("Saving config...");
		Map<String, Object> mi = new HashMap<>();
        for (Module m : ModuleManager.INSTANCE.modules)
		{
			Map<String, Object> mo = new HashMap<>();
            mo.put("enabled", m.enabled);
			Map<String, Object> ms = new HashMap<>();
			for (Setting s : m.settings)
			{
                if (s instanceof BooleanSetting)
                {
                    ms.put(s.name, ((BooleanSetting)s).value);
                }
                else if (s instanceof DoubleSetting)
                {
                    ms.put(s.name, ((DoubleSetting)s).value);
                }
				if (s instanceof StringSetting)
                {
                    ms.put(s.name, ((StringSetting)s).value);
                }
                else if (s instanceof KeycodeSetting)
                {
                    ms.put(s.name, ((KeycodeSetting)s).value);
                }
			}
            mo.put("settings", ms);
            mi.put(m.name, mo);
		}
        CONFIG.config.put("modules", mi);
        Map<String, Object> pi = new HashMap<>();
        for (CategoryPane c : ClickGUIScreen.INSTANCE.categoryPanes)
		{ 
            Map<String, Object> po = new HashMap<>();
			po.put("x", c.x);
            po.put("y", c.y);
			po.put("collapsed", c.collapsed);
            pi.put(c.category.name, po);
		}
        CONFIG.config.put("panes", pi);
		CONFIG.save();
	}
}
