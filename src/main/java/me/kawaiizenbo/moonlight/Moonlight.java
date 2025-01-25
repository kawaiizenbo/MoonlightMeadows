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
import me.kawaiizenbo.moonlight.module.settings.IndexSetting;
import me.kawaiizenbo.moonlight.module.settings.KeycodeSetting;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;
import me.kawaiizenbo.moonlight.theme.Theme;
import me.kawaiizenbo.moonlight.ui.clickgui.CategoryPane;
import me.kawaiizenbo.moonlight.ui.clickgui.ClickGUIScreen;
import me.kawaiizenbo.moonlight.ui.hud.HUDModule;
import me.kawaiizenbo.moonlight.ui.hud.HUDModuleManager;
import me.kawaiizenbo.moonlight.util.ColorUtils;

public class Moonlight implements ModInitializer 
{
	public static final Moonlight INSTANCE = new Moonlight();
	public static final Logger LOGGER = LoggerFactory.getLogger("Moonlight");
	public static final String clientTag = ColorUtils.aqua + "Moonlight Meadows";
	public static final String versionTag = ColorUtils.magenta + "v0.4.0";
	public static Theme THEME = Theme.DARK;
	public static int THEME_IDX = 2;
	public static Config CONFIG = new Config();

	@Override
	public void onInitialize() 
	{
		LOGGER.info("Moonlight loading...");
		loadConfig();
	}

	@SuppressWarnings("unchecked")
	public void loadConfig()
	{
		try
		{
			LOGGER.info("Loading config...");
			CONFIG.load();
			THEME_IDX = ((Double)CONFIG.config.get("theme")).intValue();
			THEME = Theme.THEME_LIST[THEME_IDX];
			for (Module m : ModuleManager.INSTANCE.modules)
			{
				m.enabled = (boolean)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("enabled");
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
					else if (s instanceof IndexSetting)
                	{
                	    ((IndexSetting)s).index = ((Double)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("modules")).get(m.name)).get("settings")).get(s.name)).intValue();
                	}
				}
			}
			for (HUDModule m : HUDModuleManager.INSTANCE.modules)
			{
				m.enabled = (boolean)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("enabled");
				m.x = ((Double)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("x")).intValue();
				m.y = ((Double)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("y")).intValue();
				for (Setting s : m.settings)
				{
                	if (s instanceof BooleanSetting)
                	{
                    	((BooleanSetting)s).value = (boolean)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("settings")).get(s.name);
                	}
                	else if (s instanceof DoubleSetting)
                	{
                    	((DoubleSetting)s).value = (Double)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("settings")).get(s.name);
                	}
					else if (s instanceof StringSetting)
                	{
                    	((StringSetting)s).value = (String)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("settings")).get(s.name);
                	}
					else if (s instanceof KeycodeSetting)
                	{
                	    ((KeycodeSetting)s).value = ((Double)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("settings")).get(s.name)).intValue();
                	}
					else if (s instanceof IndexSetting)
                	{
                	    ((IndexSetting)s).index = ((Double)((Map<String, Object>)((Map<String, Object>)((Map<String, Object>)CONFIG.config.get("hud")).get(m.name)).get("settings")).get(s.name)).intValue();
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
		CONFIG.config.put("theme", THEME_IDX);
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
                else if (s instanceof StringSetting)
                {
                    ms.put(s.name, ((StringSetting)s).value);
                }
                else if (s instanceof KeycodeSetting)
                {
                    ms.put(s.name, ((KeycodeSetting)s).value);
                }
                else if (s instanceof IndexSetting)
                {
                    ms.put(s.name, ((IndexSetting)s).index);
                }
			}
            mo.put("settings", ms);
            mi.put(m.name, mo);
		}
        CONFIG.config.put("modules", mi);
        
        Map<String, Object> hi = new HashMap<>();
        for (HUDModule h : HUDModuleManager.INSTANCE.modules)
		{
			Map<String, Object> ho = new HashMap<>();
            ho.put("enabled", h.enabled);
            Map<String, Object> hs = new HashMap<>();
			for (Setting s : h.settings)
			{
                if (s instanceof BooleanSetting)
                {
                    hs.put(s.name, ((BooleanSetting)s).value);
                }
                else if (s instanceof DoubleSetting)
                {
                    hs.put(s.name, ((DoubleSetting)s).value);
                }
                else if (s instanceof StringSetting)
                {
                    hs.put(s.name, ((StringSetting)s).value);
                }
                else if (s instanceof KeycodeSetting)
                {
                    hs.put(s.name, ((KeycodeSetting)s).value);
                }
                else if (s instanceof IndexSetting)
                {
                    hs.put(s.name, ((IndexSetting)s).index);
                }
			}
            ho.put("settings", hs);
            ho.put("x", h.x);
            ho.put("y", h.y);
            hi.put(h.name, ho);
		}
        CONFIG.config.put("hud", hi);
        
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
