package com.salmonpants.splatcraftplus.items;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.GENERAL;

import net.minecraft.world.item.Item;

public class ColorChip extends Item {
    public ColorChip(){
        super(new Item.Properties().tab(GENERAL).stacksTo(16));
    }
}
