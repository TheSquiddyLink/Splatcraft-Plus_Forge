package com.salmonpants.splatcraftplus.items.weapons.hero_weapons;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.TAB;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.SlosherItem;

public class HeroSlosher extends SlosherItem{
    public HeroSlosher(){
        super("splattershot");
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items)
    {
        if(group.equals(TAB))
        {
            items.add(new ItemStack(this));
        }
    }
}
