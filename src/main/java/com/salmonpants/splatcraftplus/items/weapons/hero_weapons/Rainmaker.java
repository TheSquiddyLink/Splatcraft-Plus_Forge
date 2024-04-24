package com.salmonpants.splatcraftplus.items.weapons.hero_weapons;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.splatcraft.forge.handlers.PlayerPosingHandler;
import net.splatcraft.forge.items.weapons.SlosherItem;

public class Rainmaker extends SlosherItem {

    public Rainmaker() {
        super("rainmaker");
    }
    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }
    @Override
    public PlayerPosingHandler.WeaponPose getPose(ItemStack stack)
    {
        return PlayerPosingHandler.WeaponPose.FIRE;
    }

}
