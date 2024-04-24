package com.salmonpants.splatcraftplus.items.weapons.template_weapon;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.DualieItem;

public class Dualie extends DualieItem{
    private CreativeModeTab group;
    public Dualie(CreativeModeTab group){
        super("splat_dualies");
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
