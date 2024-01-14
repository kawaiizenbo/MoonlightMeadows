package me.kawaiizenbo.moonlight.command.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import me.kawaiizenbo.moonlight.command.Command;
import me.kawaiizenbo.moonlight.command.CommandManager;
import me.kawaiizenbo.moonlight.util.ChatUtils;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.command.CommandSource;

public class Help extends Command
{
    public Help() 
    {
		super("help", "Gives you a list of all of the commands");
	}
    
    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) 
    {
        builder.executes(context -> 
        {
			for (Command cmd : CommandManager.get().getAll()) 
            {
				ChatUtils.sendMsg(ColorUtils.aqua + "Command: " + ColorUtils.gray + cmd.getName());
				ChatUtils.sendMsg(ColorUtils.gray + cmd.getDescription());
                ChatUtils.sendMsg(ColorUtils.gray + "");
			}
			return SINGLE_SUCCESS;
		}); 
    }
}
