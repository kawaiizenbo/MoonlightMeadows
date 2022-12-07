package me.kawaiizenbo.moonlight.ui.clickgui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ClickGUIScreen extends Screen
{
    public static ClickGUIScreen INSTANCE = new ClickGUIScreen(null);
    protected ClickGUIScreen(Text title) 
    {
        super(title);
    }
    
}
