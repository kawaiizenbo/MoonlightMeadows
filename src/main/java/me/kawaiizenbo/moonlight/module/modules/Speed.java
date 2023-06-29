package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module_ 
{
    DoubleSetting speed = new DoubleSetting("Speed", 2, 0.1, 10, 1);
    public Speed() 
    {
        super("Speed", "Allows you to move faster.", Category.MOVEMENT);
    }
    
    @Override
    public void onMotion(MovementType type, Vec3d movement)
    {
        mc.player.addVelocity(movement);
    }

}
