package me.kawaiizenbo.moonlight.command.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.command.Command;
import net.minecraft.command.CommandSource;

public class Reset extends Command
{
    public Reset() 
    {
        super("reset", "Resets all config options.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) 
    {
        builder.executes(context -> 
        {
			Moonlight.CONFIG.loadDefaultConfig();
			return SINGLE_SUCCESS;
		});
    }    
}
