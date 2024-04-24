package com.salmonpants.splatcraftplus.items.weapons.order_weapons;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.ChargerItem;

public class Charger extends ChargerItem{
    private CreativeModeTab group;
    public Charger(CreativeModeTab group){
        super("splat_charger");
        this.group = group;
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items)
    {
        if(group.equals(this.group))
        {
            items.add(new ItemStack(this));
        }
    }
}
