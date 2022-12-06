package me.kawaiizenbo.moonlight.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class AltManagerScreen extends Screen 
{

    public static AltManagerScreen INSTANCE = new AltManagerScreen(null);
    protected AltManagerScreen(Text title) 
    {
        super(title);
    }
    
}
