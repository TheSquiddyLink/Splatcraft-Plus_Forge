package com.salmonpants.splatcraftplus.items.weapons.order_weapons;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.WEAPONS;

import com.salmonpants.splatcraftplus.items.weapons.template_weapon.Shooter;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class OctoShot extends Shooter {
    public OctoShot(){
        super(WEAPONS);
    }
    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }
}