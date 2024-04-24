package com.salmonpants.splatcraftplus.items.weapons.template_weapon;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.BlasterItem;

public class Blaster extends BlasterItem{
    private CreativeModeTab group;
    public Blaster(CreativeModeTab group){
        super("blaster");
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
