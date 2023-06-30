package me.kawaiizenbo.moonlight;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;

import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.Setting;
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
		LOGGER.info("Loading config...");
		if (CONFIG.doesConfigExist())
		{
			CONFIG.loadDefaultConfig(); 
			CONFIG.save();
		}
		CONFIG.load();
		for (Module_ m : ModuleManager.INSTANCE.modules)
		{
			m.enabled = (boolean)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("enabled");
			for (Setting s : m.settings)
			{
				s.value = ((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get(s.name);
			}
		}
	}

	public void saveConfig()
	{
		LOGGER.info("Saving config...");
		Map<String, Object> mi = new HashMap<>();
        for (Module_ m : ModuleManager.INSTANCE.modules)
		{
			Map<String, Object> mo = new HashMap<>();
            mo.put("enabled", m.enabled);
			for (Setting s : m.settings)
			{
                mo.put(s.name, s.value);
			}
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
