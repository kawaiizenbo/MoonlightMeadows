package me.kawaiizenbo.moonlight.command.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import me.kawaiizenbo.moonlight.command.Command;
import me.kawaiizenbo.moonlight.command.CommandManager;
import me.kawaiizenbo.moonlight.util.ChatUtils;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.util.math.GlobalPos;

public class DeathPos extends Command
{
    public DeathPos() 
    {
		super("deathpos", "Shows your last death position.");
	}
    
    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) 
    {
        builder.executes(context -> 
        {
            GlobalPos pos = null;
            try 
            {
                pos = mc.player.getLastDeathPos().get();
                if (pos == null) throw new Exception();
            } 
            catch (Exception e) 
            {
                ChatUtils.sendMsg(ColorUtils.reset + "You have not died in this world.");
                return SINGLE_SUCCESS;
            }
            
			ChatUtils.sendMsg(ColorUtils.reset + "You last died at: " + 
            ColorUtils.aqua + " X: " + ColorUtils.gray + pos.getPos().getX() + 
            ColorUtils.aqua + " Y: " + ColorUtils.gray + pos.getPos().getY() +
            ColorUtils.aqua + " Z: " + ColorUtils.gray + pos.getPos().getZ()
            );
			return SINGLE_SUCCESS;
		}); 
    }
}
