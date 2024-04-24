package com.salmonpants.splatcraftplus.items.weapons.other_weapons;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.splatcraft.forge.items.weapons.ChargerItem;

public class Snipewriter extends ChargerItem {

    public Snipewriter() {
        super("splat_charger");
    }
    @Override
    public void onReleaseCharge(Level level, Player player, ItemStack stack, float charge) {
        if(charge == 1){
            CompoundTag tag = stack.getOrCreateTag();
            tag.putInt("charge", 5);
            stack.setTag(tag);
            player.displayClientMessage(new TranslatableComponent("Charge updated!"), true);
            player.setItemInHand(InteractionHand.MAIN_HAND, stack);
        }
    }
}