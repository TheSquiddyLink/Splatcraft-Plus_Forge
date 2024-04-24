package com.salmonpants.splatcraftplus.items;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.GENERAL;

import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class EmptyPalette extends Item{
    private String tooltip;
    public EmptyPalette(String tooltip){
        super(new Item.Properties().tab(GENERAL).stacksTo(1));
        this.tooltip = tooltip;
    }
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag){
        super.appendHoverText(stack, level, tooltip, flag);
        if(this.tooltip != null) tooltip.add(new TranslatableComponent("item.splatcraftplus.tooltip."+this.tooltip).withStyle(ChatFormatting.RED));
    }
}
