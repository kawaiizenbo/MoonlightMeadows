package me.kawaiizenbo.moonlight.module.settings;

public class StringSetting extends Setting
{
    public String value;

    public StringSetting(String name, String value)
    {
        this.name = name;
        this.value = value;
    }
}
