package com.salmonpants.splatcraftplus.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.advancements.Advancement;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OrderBlueprint extends Item {
    private static final String PATH = "splatcraftplus:unlocks/order/";
    private static final String[] ADVANCMENTS = {
        "ordershot",
        "order_dualie"
    };
    public OrderBlueprint() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.isShiftKeyDown() && player instanceof ServerPlayer) {
            ArrayList<Advancement> pool = new ArrayList<Advancement>();
            ServerPlayer serverPlayer = (ServerPlayer) player;
            for (String advancement : ADVANCMENTS) {
                pool.add(serverPlayer.getServer().getAdvancements().getAdvancement(new ResourceLocation(PATH+advancement)));
            }
            pool.removeIf(advancement -> serverPlayer.getAdvancements().getOrStartProgress(advancement).isDone());
            // Check if the player is sneaking and is a server player
            // Retrieve the advancement for the player
            Random random = new Random();
            if(pool.size() > 0){
                int randomIndex = random.nextInt(pool.size());
                serverPlayer.getAdvancements().award(pool.get(randomIndex), "default");
            } else serverPlayer.displayClientMessage(new TranslatableComponent("No new unlocks"), true);
        }
        // Return PASS to allow the default behavior (e.g., placing a block if applicable)
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
