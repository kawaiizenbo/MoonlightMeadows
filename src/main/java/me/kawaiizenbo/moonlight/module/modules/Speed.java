package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.util.MathUtils;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.Vec3d;

public class Speed extends Module 
{
    double old = 0.1;

    DoubleSetting speed = new DoubleSetting("Speed", 1.4, 0.1, 10, 1);
    public Speed() 
    {
        super("Speed", "Allows you to move faster.", Category.MOVEMENT);
        settings.add(speed);
    }
    
    @Override
    public void onEnable()
    {
    	super.onEnable();
    	old = mc.player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).getBaseValue();
    }

    @Override
    public void tick()
    {	
        mc.player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(speed.value/10d);
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        mc.player.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(old);
    }

}
