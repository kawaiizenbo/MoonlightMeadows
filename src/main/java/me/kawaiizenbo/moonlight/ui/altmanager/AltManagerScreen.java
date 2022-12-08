package me.kawaiizenbo.moonlight.ui.altmanager;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class AltManagerScreen extends Screen 
{
    public static AltManagerScreen INSTANCE = new AltManagerScreen();

    protected AltManagerScreen() 
    {
        super(Text.literal("Alt Manager"));
    }
    
}
