package com.salmonpants.splatcraftplus.items.weapons.template_weapon;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.SplatlingItem;

public class Splatling extends SplatlingItem{
    private CreativeModeTab group;
    public Splatling(CreativeModeTab group){
        super("heavy_splatling");
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
