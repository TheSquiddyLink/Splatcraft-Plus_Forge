package com.salmonpants.splatcraftplus.items.weapons.hero_weapons;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.ShooterItem;
import static com.salmonpants.splatcraftplus.SplatcraftPlus.WEAPONS;
public class HeroShot_1 extends ShooterItem{
    public HeroShot_1(){
        super("splattershot");
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
