package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module_;

public class ModulesList extends Module_ 
{
    public ModulesList()
    {
        super("ModulesList", "Shows enabled modules on side of screen", Category.RENDER);
        this.enabled = true;
        this.showInModulesList.value = false;
    }
}
