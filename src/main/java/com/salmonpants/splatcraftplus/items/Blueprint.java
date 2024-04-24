package com.salmonpants.splatcraftplus.items;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.GENERAL;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Random;

import org.jetbrains.annotations.NotNull;

import net.minecraft.advancements.Advancement;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Blueprint extends Item {
    private String[] ADVANCMENTS;
    private String END;
    private String PATH;
    
    public Blueprint(String path, String end, String... advancements) {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
        this.ADVANCMENTS = advancements;
        this.PATH = path;
        this.END = end; 
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.isShiftKeyDown() && player instanceof ServerPlayer) {
            ArrayList<Advancement> pool = new ArrayList<Advancement>();
            ArrayList<String> poolIds = new ArrayList<String>();
            ServerPlayer serverPlayer = (ServerPlayer) player;
            for (String advancement : ADVANCMENTS) {
                Advancement adv = serverPlayer.getServer().getAdvancements().getAdvancement(new ResourceLocation(PATH + advancement));
                if (!serverPlayer.getAdvancements().getOrStartProgress(adv).isDone()) {
                    pool.add(adv);
                    poolIds.add(advancement);
                }
            }
            // Check if the player is sneaking and is a server player
            // Retrieve the advancement for the player
            Random random = new Random();
            if(pool.size() > 0){
                int randomIndex = random.nextInt(pool.size());
                serverPlayer.getAdvancements().award(pool.get(randomIndex), "default");
                
                if(END != null){
                    Advancement endAdvancement = serverPlayer.getServer().getAdvancements().getAdvancement(new ResourceLocation(PATH+END));
                    serverPlayer.getAdvancements().award(endAdvancement, poolIds.get(randomIndex));
                }
                // TODO: Change TranslatableCompenet to use the lang file
            } else serverPlayer.displayClientMessage(new TranslatableComponent("No new unlocks"), true);
        }
        // Return PASS to allow the default behavior (e.g., placing a block if applicable)
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items)
    {
        if(group.equals(GENERAL))
        {
            items.add(new ItemStack(this));
        }
    }
}
