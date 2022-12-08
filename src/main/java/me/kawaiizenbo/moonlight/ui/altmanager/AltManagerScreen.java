package me.kawaiizenbo.moonlight.ui.altmanager;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class AltManagerScreen extends Screen 
{
    public static AltManagerScreen INSTANCE = new AltManagerScreen();

    protected AltManagerScreen() 
    {
        super(Text.literal("Alt Manager"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        renderBackgroundTexture(0);
    }
    
}
