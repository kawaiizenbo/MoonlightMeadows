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

            // you can break this really easily and i dont feel like fixing it :3 have fun
            if (setting instanceof BooleanSetting)
            {
                ((BooleanSetting)setting).value = Boolean.parseBoolean(v);
            }
            else if (setting instanceof DoubleSetting)
            {
                ((DoubleSetting)setting).value = Double.parseDouble(v);
            }
            if (setting instanceof StringSetting)
            {
                ((StringSetting)setting).value = v;
            }
            else if (setting instanceof KeycodeSetting)
            {
                ((KeycodeSetting)setting).value = Integer.parseInt(v);
            }

            return SINGLE_SUCCESS;
        }))));
    }
}
