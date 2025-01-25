package me.kawaiizenbo.moonlight.util;

import me.kawaiizenbo.moonlight.Moonlight;
import me.kawaiizenbo.moonlight.theme.ThemeColor;
import net.minecraft.util.Identifier;

public class DrawUtils 
{
	public static Identifier getThemedGUIIcon(String textureName, ThemeColor invert)
	{
		boolean mode = ((invert.r + invert.g + invert.b) / 3) > 77;
		String addition = mode ? "_light" : "";
		return Identifier.of("moonlight", textureName+addition);
	}
	
	public static Identifier getThemedGUIIcon(String textureName)
	{
		String addition = Moonlight.THEME.useDarkIcons ? "_light" : "";
		return Identifier.of("moonlight", textureName+addition);
	}
}
