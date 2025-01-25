package me.kawaiizenbo.moonlight.theme;

public class Theme 
{
	public static final Theme LIGHT = new Theme(
			"Light",
			new ThemeColor(0x222222), 
			new ThemeColor(0xFFFFFF),
			new ThemeColor(0xFFFFFF), 
			new ThemeColor(0xDDDDDD), 
			new ThemeColor(0x00AAAA), 
			new ThemeColor(0x55FFFF),
			new ThemeColor(0x222222), 
			false,
			false
		);
	public static final Theme HIGHCONTRAST = new Theme(
			"High Contrast",
			new ThemeColor(0x000000), 
			new ThemeColor(0xFFFFFF),
			new ThemeColor(0xFFFFFF), 
			new ThemeColor(0x777777), 
			new ThemeColor(0x00AAAA), 
			new ThemeColor(0xFFFFFF),
			new ThemeColor(0x000000), 
			false,
			true
		);
	public static final Theme DARK = new Theme(
			"Dark",
			new ThemeColor(0xFFFFFF), 
			new ThemeColor(0xFFFFFF),
			new ThemeColor(0x222222), 
			new ThemeColor(0x333333), 
			new ThemeColor(0x55FFFF), 
			new ThemeColor(0x55FFFF),
			new ThemeColor(0xFFFFFF), 
			false,
			false
		);
	public static final Theme[] THEME_LIST = 
		{
				LIGHT, HIGHCONTRAST, DARK
		};
	
	public String name;
	public ThemeColor text;
	public ThemeColor headerText;
	public ThemeColor background;
	public ThemeColor hover;
	public ThemeColor accent;
	public ThemeColor hudAccent;
	public ThemeColor border;
	public boolean useDarkIcons;
	public boolean themedWindowBorders;
	
	public Theme(
			String name,
			ThemeColor text,
			ThemeColor headerText,
			ThemeColor background,
			ThemeColor hover,
			ThemeColor accent,
			ThemeColor hudAccent,
			ThemeColor border,
			boolean useDarkIcons,
			boolean themedWindowBorders
			) 
	{
		this.name = name;
		this.text = text;
		this.headerText = headerText;
		this.background = background;
		this.hover = hover;
		this.accent = accent;
		this.hudAccent = hudAccent;
		this.border = border;
		this.useDarkIcons = useDarkIcons;
		this.themedWindowBorders = themedWindowBorders;
	}
}
