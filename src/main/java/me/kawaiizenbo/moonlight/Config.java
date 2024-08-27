package me.kawaiizenbo.moonlight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.module.settings.KeycodeSetting;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;
import me.kawaiizenbo.moonlight.ui.clickgui.ClickGUIScreen;
import net.minecraft.client.MinecraftClient;

public class Config 
{
    MinecraftClient mc = MinecraftClient.getInstance();
    public File configDir = new File(mc.runDirectory.getPath() + "/moonlight");
    public File configFile = new File(configDir, "config.json");
    public Map<String, Object> config = new HashMap<>();
    protected static Gson gson = new Gson();
    
    public Config()
    {
        configDir.mkdirs();
    }

    public boolean doesConfigExist()
    {
        return !Files.exists(configFile.toPath());
    }

    public void loadDefaultConfig()
    {
        ModuleManager.INSTANCE = new ModuleManager();
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
        config.put("modules", mi);
        int xOffset = 4;
		int yOffset = 4;
        Map<String, Object> pi = new HashMap<>();
        for (Category category : Category.values())
		{ 
            Map<String, Object> po = new HashMap<>();
			if (xOffset > 400)
			{
				xOffset = 4;
				yOffset = 128;
			}
			po.put("x", xOffset);
            po.put("y", yOffset);
            po.put("collapsed", false);
            pi.put(category.name, po);
			xOffset += 100;
		}
        config.put("panes", pi);
        ClickGUIScreen.INSTANCE = new ClickGUIScreen();
    }

    public void load() throws IOException
    {
        try
        {
            String configText = new String(Files.readAllBytes(configFile.toPath()));
            config = (Map<String, Object>)gson.fromJson(configText, Map.class);
        }
        catch (Exception e)
        {
            throw new IOException("Failed to load config file.");
        }
    }

    public void save()
    {
        try
        { 
            if (!doesConfigExist()) configFile.createNewFile(); 
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
        try
        {
            String configText = gson.toJson(config);
            FileWriter writer = new FileWriter(configFile);
            writer.write(configText);
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
