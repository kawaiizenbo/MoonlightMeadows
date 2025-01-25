package me.kawaiizenbo.moonlight.theme;

public class ThemeColor 
{
	public int r, g, b;
	
	public ThemeColor(int r, int g, int b) 
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public ThemeColor(int RGBcolor)
	{
		this.r = (RGBcolor&0x00FF0000)>>16;
		this.g = (RGBcolor&0x0000FF00)>>8;
		this.b = (RGBcolor&0x000000FF)>>0;
	}
	
	public int getRGB()
	{
		return ((255&0x0ff)<<24)|((r&0x0ff)<<16)|((g&0x0ff)<<8)|(b&0x0ff);
	}
	
	public void setRGB(int RGBcolor)
	{
		this.r = RGBcolor&0x00FF0000;
		this.g = RGBcolor&0x0000FF00;
		this.b = RGBcolor&0x000000FF;
	}
}
