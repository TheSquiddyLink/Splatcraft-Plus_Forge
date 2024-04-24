package com.salmonpants.splatcraftplus.items.weapons.other_weapons;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.splatcraft.forge.items.weapons.ChargerItem;
import net.splatcraft.forge.util.PlayerCharge;

public class Snipewriter extends ChargerItem {
    private static final String CHARGE_TAG = "charge";
    
    public Snipewriter() {
        super("splat_charger");
    }
    @Override 
    public void weaponUseTick(Level level, LivingEntity entity, ItemStack stack, int timeLeft) {
        if (entity instanceof Player) {
            Player player = (Player)entity;
            CompoundTag tag = stack.getOrCreateTag();
            int charges = tag.getInt(CHARGE_TAG);
            if(charges >= 1) PlayerCharge.addChargeValue(player, stack, 1, false);
        }
        super.weaponUseTick(level, entity, stack, timeLeft);
    }
    @Override
    public void onReleaseCharge(Level level, Player player, ItemStack stack, float charge) {
        CompoundTag tag = stack.getOrCreateTag();
        int totalCharge = tag.getInt(CHARGE_TAG);
        if(charge == 1 && totalCharge == 0){
            tag.putInt(CHARGE_TAG, 5);
            stack.setTag(tag);
            player.setItemInHand(InteractionHand.MAIN_HAND, stack);
        } else if (charge == 1) {
            tag.putInt(CHARGE_TAG, totalCharge - 1);
            stack.setTag(tag);
            player.setItemInHand(InteractionHand.MAIN_HAND, stack);
            totalCharge -= 1;
        }
        player.displayClientMessage(new TranslatableComponent("Charges Left: "+ Integer.toString(totalCharge)), canRepair);
        super.onReleaseCharge(level, player, stack, charge);
    }
}