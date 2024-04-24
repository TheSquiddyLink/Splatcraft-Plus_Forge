package com.salmonpants.splatcraftplus.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.Random;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OrderBlueprint extends Item {
    private static final String[] ADVANCMENTS = {
        "Message 1",
        "Message 2",
        "Message 3",
    };

    public OrderBlueprint() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        // Check if the player is sneaking
        if (player.isShiftKeyDown()) {
            Random random = new Random();
            int randomIndex = random.nextInt(ADVANCMENTS.length);
            // Perform some action when the player is sneaking and right-clicks
            player.displayClientMessage(new TranslatableComponent(ADVANCMENTS[randomIndex]), true);
            
        }
        // Return PASS to allow the default behavior (e.g., placing a block if applicable)
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
