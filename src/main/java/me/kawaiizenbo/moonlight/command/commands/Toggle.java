package me.kawaiizenbo.moonlight.command.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import me.kawaiizenbo.moonlight.command.Command;
import me.kawaiizenbo.moonlight.command.ModuleArgumentType;
import me.kawaiizenbo.moonlight.module.Module_;
import net.minecraft.client.network.ClientPlayerEntity;
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
        builder.then(argument("module", new ModuleArgumentType()).executes(context -> 
        {
            ClientPlayerEntity player = mc.player;
            assert player != null;

            Module_ m = context.getArgument("module", Module_.class);
            m.toggle();

            return SINGLE_SUCCESS;
        }));
    }
    
}
