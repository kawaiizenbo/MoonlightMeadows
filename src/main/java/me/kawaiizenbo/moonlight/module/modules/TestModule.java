package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;
import me.kawaiizenbo.moonlight.module.settings.StringSetting;

public class TestModule extends Module 
{
    public BooleanSetting bs = new BooleanSetting("BooleanSetting", false);
    public DoubleSetting ds = new DoubleSetting("DoubleSetting", 1, 0, 10, 10);
    public StringSetting ss = new StringSetting("StringSetting", "string");

    public TestModule()
    {
        super("Test Module", "Used for testing module features.", Category.WORLD);
        addSettings(bs, ds, ss);
    }
}
