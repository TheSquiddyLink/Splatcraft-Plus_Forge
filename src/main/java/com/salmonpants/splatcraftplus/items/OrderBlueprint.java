package com.salmonpants.splatcraftplus.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.Random;
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
            // Check if the player is sneaking and is a server player
            ServerPlayer serverPlayer = (ServerPlayer) player;
            // Retrieve the advancement for the player
            Random random = new Random();
            int randomIndex = random.nextInt(ADVANCMENTS.length);
            ResourceLocation advancementId = new ResourceLocation(PATH+ADVANCMENTS[randomIndex]);
            if (serverPlayer.getServer().getAdvancements().getAdvancement(advancementId) != null) {
                // Grant the advancement to the player
                serverPlayer.getAdvancements().award(serverPlayer.getServer().getAdvancements().getAdvancement(advancementId), "default");
                // Display a message to the player
                serverPlayer.displayClientMessage(new TranslatableComponent(PATH+ADVANCMENTS[randomIndex]), true);
            }
        }
        // Return PASS to allow the default behavior (e.g., placing a block if applicable)
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
