package me.kawaiizenbo.moonlight.module.modules;

import me.kawaiizenbo.moonlight.module.Category;
import me.kawaiizenbo.moonlight.module.Module;
import me.kawaiizenbo.moonlight.module.settings.BooleanSetting;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;

public class AutoTotem extends Module 
{
	public BooleanSetting overrideItems = new BooleanSetting("Override other items", false);
	
    public AutoTotem()
    {
        super("Auto Totem", "Automatically puts totems in offhand.", Category.COMBAT);
        settings.add(overrideItems);
    }
    
    @Override
    public void tick()
    {
    	if (mc.player.getInventory().offHand.get(0).getItem() != Items.TOTEM_OF_UNDYING)
    	{
    		if((!mc.player.getInventory().offHand.isEmpty()) && !overrideItems.value) return;
    		for (int i = 0; i <= 35; i++)
    		{
    			if (mc.player.getInventory().getStack(i).getItem() == Items.TOTEM_OF_UNDYING)
    			{
    				mc.interactionManager.clickSlot(0, i, 8, SlotActionType.SWAP, mc.player);
    				mc.interactionManager.clickSlot(0, 45, 8, SlotActionType.SWAP, mc.player);
    				mc.interactionManager.clickSlot(0, i, 8, SlotActionType.SWAP, mc.player);
    			}
    		}
    	}
    }
}
