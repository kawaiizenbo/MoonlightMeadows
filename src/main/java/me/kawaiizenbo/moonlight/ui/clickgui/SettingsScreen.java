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
    }

    @Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) 
	{
        this.renderBackground(matrices);
        DrawableHelper.fill(matrices, (width/2)-112, (height/2)-96, (width/2)+112, (height/2)+96, 0xFF222222);
        DrawableHelper.drawCenteredText(matrices, textRenderer, module.name, width/2, (height/2)-88, 0xFFFFFF);
        DrawableHelper.drawTextWithShadow(matrices, textRenderer, Text.literal(module.description), (width/2)-104, (height/2)-72, 0xFFFFFF);
        backButton = new TextButton(ColorUtils.underline + "< Back", (width/2)-104, (height/2)-88, 0xFFFFFF);
        backButton.render(matrices, textRenderer, mouseX, mouseY);
		int yOffset = (height/2)-56;
		for (Setting setting : module.settings)
		{
			setting.render(matrices, (width/2)-96, yOffset, mouseX, mouseY);
			yOffset += setting.height + 1;
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
        for (Setting setting : module.settings)
        {
            setting.mouseClicked(mouseX, mouseY, button);
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button)
    {
        for (Setting setting : module.settings)
        {
            setting.mouseReleased(mouseX, mouseY, button);
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers)
    {
        for (Setting setting : module.settings)
        {
            setting.keyPressed(keyCode, scanCode, modifiers);
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
