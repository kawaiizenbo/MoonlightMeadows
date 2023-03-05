package me.kawaiizenbo.moonlight.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class MathUtils 
{
    public static double round(double value, int places) 
    {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double length2D(Vec3d vec3d) 
    {
        return MathHelper.sqrt((float)(vec3d.x * vec3d.x + vec3d.z * vec3d.z));
    }
}
