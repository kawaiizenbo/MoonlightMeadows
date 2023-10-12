package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.util.MathUtils;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module 
{
    DoubleSetting speed = new DoubleSetting("Speed", 2, 0.1, 10, 1);
    public Speed() 
    {
        super("Speed", "Allows you to move faster.", Category.MOVEMENT);
        settings.add(speed);
    }
    
    @Override
    public void onMotion(MovementType type, Vec3d movement)
    {
        // this is a little janky but it works, will find a better solution later
        if (mc.player.forwardSpeed == 0 && mc.player.sidewaysSpeed == 0 && mc.player.isOnGround())
        {
            mc.player.setVelocity(0, 0, 0);
        }
        Vec3d move = new Vec3d(mc.player.getX() - mc.player.prevX, 0, mc.player.getZ() - mc.player.prevZ).multiply(20);
        double mps = Math.abs(MathUtils.length2D(move));
        double normal = mc.player.isSprinting() ? 5.61 : 4.31;
        if (mps > normal * speed.value)
        {
            return;
        }
        if (mc.player.isOnGround())
        {
            mc.player.setVelocity(mc.player.getVelocity().x * speed.value, 0, mc.player.getVelocity().z * speed.value);
        }
    }

}
