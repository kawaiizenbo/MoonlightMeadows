package me.kawaiizenbo.moonlight.module;

public enum Category 
{
	COMBAT("Combat", 0xFFFF5555),
	MOVEMENT("Movement", 0xFFFF55FF),
	RENDER("Render", 0xFF5555FF),
	WORLD("World", 0xFF55FF55), 
	PLAYER("Player", 0xFF00AAAA),
	CHAT("Chat", 0xFFFFAA00),
	SPECIAL("Special", 0xFFFFFFFF);
	
	public String name;
	public int color;
	
	Category(String name, int color) 
    {
		this.name = name;
		this.color = color;
	}
}
