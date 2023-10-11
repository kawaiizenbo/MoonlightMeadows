package me.kawaiizenbo.moonlight.command.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import me.kawaiizenbo.moonlight.command.Command;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.module.settings.KeycodeSetting;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;
import me.kawaiizenbo.moonlight.util.ChatUtils;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import me.kawaiizenbo.moonlight.module.Module;
import net.minecraft.command.CommandSource;

public class SettingCommand extends Command
{
    public SettingCommand() 
    {
        super("setting", "Change a setting of a module.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) 
    {
        builder
        .then(argument("module", StringArgumentType.string())
        .then(argument("setting", StringArgumentType.string())
        .then(argument("value", StringArgumentType.string())
        .executes(context -> 
        {
            String m = context.getArgument("module", String.class);
            String s = context.getArgument("setting", String.class);
            String v = context.getArgument("value", String.class);

            Module module = ModuleManager.INSTANCE.getModuleByName(m);
            if (module == null)
            {
                ChatUtils.sendMsg(ColorUtils.red + "Invalid Module Name");
                return 0;
            }
            Setting setting = module.getSettingByName(s);
            if (setting == null)
            {
                ChatUtils.sendMsg(ColorUtils.red + "Invalid Setting Name");
                return 0;
            }

            if (setting instanceof BooleanSetting)
            {
                try 
                {
                    ((BooleanSetting)setting).value = Boolean.parseBoolean(v);
                } 
                catch (Exception e) 
                {
                    ChatUtils.sendMsg(ColorUtils.red + "Invalid Value, expected boolean");
                    return 0;
                }
                
            }
            else if (setting instanceof DoubleSetting)
            {   
                try
                {
                    ((DoubleSetting)setting).value = Double.parseDouble(v);
                } 
                catch (Exception e) 
                {
                    ChatUtils.sendMsg(ColorUtils.red + "Invalid Value, expected Double");
                    return 0;
                }
            }
            else if (setting instanceof StringSetting)
            {
                try
                {
                    ((StringSetting)setting).value = v;
                } 
                catch (Exception e) 
                {
                    ChatUtils.sendMsg(ColorUtils.red + "Invalid Value, expected String");
                    return 0;
                }
            }
            else if (setting instanceof KeycodeSetting)
            {   
                try
                {
                    int kv = Integer.parseInt(v);
                    if (kv > 348)
                    {
                        ChatUtils.sendMsg(ColorUtils.red + "Keycode Value is too high, maximum is 348 (Menu)");
                        return 0;
                    }
                    if (kv < 0)
                    {
                        ChatUtils.sendMsg(ColorUtils.red + "Keycode Value must be positive");
                        return 0;
                    }
                    ((KeycodeSetting)setting).value = kv;
                } 
                catch (Exception e) 
                {
                    ChatUtils.sendMsg(ColorUtils.red + "Invalid Value, expected Keycode (integer)");
                    return 0;
                }
            }

            return SINGLE_SUCCESS;
        }))));
    }
}
