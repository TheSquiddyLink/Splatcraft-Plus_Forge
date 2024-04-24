package com.salmonpants.splatcraftplus.items.weapons.order_weapons;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.BlasterItem;
import static com.salmonpants.splatcraftplus.SplatcraftPlus.WEAPONS;
public class OrderBlaster extends BlasterItem{
    public OrderBlaster(){
        super("luna_blaster");
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items)
    {
        if(group.equals(WEAPONS))
        {
            items.add(new ItemStack(this));
        }
    }
}
