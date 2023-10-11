package me.kawaiizenbo.moonlight.command.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import me.kawaiizenbo.moonlight.command.Command;
import me.kawaiizenbo.moonlight.module.ModuleManager;
import me.kawaiizenbo.moonlight.module.Module;
import net.minecraft.command.CommandSource;

public class Toggle extends Command
{

    public Toggle() 
    {
        super("toggle", "Toggle a module.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) 
    {
        builder.then(argument("module", StringArgumentType.string())
        .executes(context -> 
        {
            String m = context.getArgument("module", String.class);
            Module module = ModuleManager.INSTANCE.getModuleByName(m);
            module.toggle();

            return SINGLE_SUCCESS;
        }));
    }
    
}
