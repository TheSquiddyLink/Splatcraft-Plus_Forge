package com.salmonpants.splatcraftplus.items;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.GENERAL;

import net.minecraft.world.item.Item;

public class EmptyPalette extends Item{
    public EmptyPalette(){
        super(new Item.Properties().tab(GENERAL).stacksTo(1));
    }
}
