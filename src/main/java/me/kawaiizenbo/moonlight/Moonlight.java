package me.kawaiizenbo.moonlight;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.kawaiizenbo.moonlight.util.ColorUtils;

public class Moonlight implements ModInitializer 
{
	public static final Moonlight INSTANCE = new Moonlight();
	public static final Logger LOGGER = LoggerFactory.getLogger("Moonlight");
	public static final String clientTag = ColorUtils.aqua + "Moonlight Meadows";
	public static final String versionTag = ColorUtils.magenta + "v0.dev";

	@Override
	public void onInitialize() 
	{
		LOGGER.info("Moonlight loading...");
	}
}
