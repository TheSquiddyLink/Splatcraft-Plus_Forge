package com.salmonpants.splatcraftplus.items.weapons.hero_weapons;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.SplatlingItem;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.TAB;
public class HeroSplatling extends SplatlingItem{
    public HeroSplatling(){
        super("heavy_splatling");
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
