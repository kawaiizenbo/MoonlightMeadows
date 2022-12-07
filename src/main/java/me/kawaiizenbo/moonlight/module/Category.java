package me.kawaiizenbo.moonlight.module;

public enum Category 
{
	COMBAT("Combat"),
	MOVEMENT("Movement"),
	RENDER("Render"),
	WORLD("World"), 
	PLAYER("Player"),
	CHAT("Chat");
	
	public String name;
	
	Category(String name) 
    {
		this.name = name;
	}
}
