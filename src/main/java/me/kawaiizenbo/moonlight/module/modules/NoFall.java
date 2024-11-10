package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class NoFall extends Module
{
    public NoFall()
    {
        super("NoFall", "Prevents you from taking fall damage.", Category.PLAYER);
    }

    @Override
    public void tick()
    {
        if(mc.player.fallDistance >= 2.5) mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true, false));
    }
}
