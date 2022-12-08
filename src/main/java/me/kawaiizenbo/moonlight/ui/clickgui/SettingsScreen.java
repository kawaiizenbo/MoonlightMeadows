package me.kawaiizenbo.moonlight.ui.clickgui;

import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.Setting;
import me.kawaiizenbo.moonlight.ui.TextButton;
import me.kawaiizenbo.moonlight.util.ColorUtils;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class SettingsScreen extends Screen 
{
    private Module_ module;
    private TextButton backButton;

    protected SettingsScreen(Module_ module) 
    {
        super(Text.literal("Settings"));
        this.module = module;
        backButton = new TextButton(ColorUtils.underline + "< Back", 112, 32, 0xFFFFFF);
    }

    @Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) 
	{
        this.renderBackground(matrices);
        DrawableHelper.fill(matrices, (width/2)-112, (height/2)-96, (width/2)+112, (height/2)+96, 0xFF222222);
        DrawableHelper.drawCenteredText(matrices, textRenderer, module.name, width/2, 32, 0xFFFFFF);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(module.description), 112, 48, 0xFFFFFF);
        backButton.render(matrices, textRenderer, mouseX, mouseY);
		int yOffset = 64;
		for (Setting setting : module.settings)
		{
			setting.render(matrices, 117, yOffset, mouseX, mouseY);
			yOffset += 32;
		}
        // add keybind setting here eventually
	}
    
    @Override
    public boolean shouldPause() 
    {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button)
    {
        backButton.mouseClicked((int)mouseX, (int)mouseY);
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
