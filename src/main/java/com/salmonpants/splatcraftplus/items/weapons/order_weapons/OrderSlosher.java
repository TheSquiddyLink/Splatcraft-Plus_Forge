package com.salmonpants.splatcraftplus.items.weapons.order_weapons;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.splatcraft.forge.items.weapons.SlosherItem;
import static com.salmonpants.splatcraftplus.SplatcraftPlus.TAB;
public class OrderSlosher extends SlosherItem{
    public OrderSlosher(){
        super("slosher");
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
