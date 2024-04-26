package com.salmonpants.splatcraftplus.items.weapons.other_weapons;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.WEAPONS;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.DualieItem;

public class DouserDualies extends DualieItem {
    private CreativeModeTab group = WEAPONS;
    public DouserDualies(){
        super("douser_dualies");
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
