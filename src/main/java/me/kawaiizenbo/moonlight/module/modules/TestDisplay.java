package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;
import me.kawaiizenbo.moonlight.module.settings.DoubleSetting;

public class TestDisplay extends Module_
{
    DoubleSetting test1 = new DoubleSetting("test1", 1, 0, 20, 1);
    DoubleSetting test2 = new DoubleSetting("test2", 0, 0, 1, 0.1);

    public TestDisplay()
    {
        super("TestDisplay", "Test of settings window", Category.RENDER);
        this.settings.add(test1);
        this.settings.add(test2);
    }
}
