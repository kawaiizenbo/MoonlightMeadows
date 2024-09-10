package me.kawaiizenbo.moonlight.util;

import me.kawaiizenbo.moonlight.Moonlight;
import net.minecraft.util.Identifier;

public class DrawUtils 
{
	public static Identifier getThemedGUIIcon(String textureName)
	{
		String addition = Moonlight.THEME.useDarkIcons ? "_light" : "";
		return Identifier.of("moonlight", textureName+addition);
	}
}
