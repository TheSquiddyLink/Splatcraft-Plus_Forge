package com.salmonpants.splatcraftplus.items.weapons.other_weapons;

import static com.salmonpants.splatcraftplus.SplatcraftPlus.WEAPONS;

import com.salmonpants.splatcraftplus.items.weapons.template_weapon.Slosher;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.splatcraft.forge.entities.InkProjectileEntity;
import net.splatcraft.forge.items.weapons.settings.SlosherWeaponSettings;
import net.splatcraft.forge.util.InkBlockUtils;
import net.splatcraft.forge.util.PlayerCooldown;

public class Dreadwringer extends Slosher {
    private int ticksPassed = 0;
    private boolean secondProj = false;
    public Dreadwringer(){
        super(WEAPONS);
    }
    @Override
    public void weaponUseTick(Level level, LivingEntity entity, ItemStack stack, int timeLeft) {
        super.weaponUseTick(level, entity, stack, timeLeft);
        if(ticksPassed >= 3 && !secondProj) {
            Player player = (Player)entity;
            player.displayClientMessage(new TranslatableComponent("IT HAS BEEN 3 TICKS"),true);
            this.SpawnSecondProj(player, getSettings(stack), level, stack);
        } else {
            ticksPassed++;
        }
    }
    private void SpawnSecondProj(Player player, SlosherWeaponSettings settings, Level level, ItemStack stack){
        if (!level.isClientSide && reduceInk(player, this, settings.inkConsumption, settings.inkRecoveryCooldown, true)) {
            boolean hasTrail = 0 == Math.floor((settings.projectileCount - 1) / 2f) || 0 == Math.ceil((settings.projectileCount - 1) / 2f);
            float angle = settings.angleOffset * 0 - settings.angleOffset * (settings.projectileCount - 1) / 2;
            InkProjectileEntity proj = new InkProjectileEntity(level, player, stack, InkBlockUtils.getInkType(player), settings.projectileSize * (hasTrail ? 1 : 0.8f), settings);
            proj.shootFromRotation(player, player.getXRot(), player.getYRot() + angle, settings.pitchCompensation, settings.projectileSpeed, 2);
            proj.setSlosherStats(settings);
            level.addFreshEntity(proj);
            this.secondProj = true;
            switch (slosherType) {
                case EXPLODING:
                    proj.explodes = true;
                    proj.setProjectileType(InkProjectileEntity.Types.BLASTER);
                case CYCLONE:
                    proj.canPierce = true;
            }
        }
    }
    @Override
    public void onPlayerCooldownEnd(Level level, Player player, ItemStack stack, PlayerCooldown cooldown){
        super.onPlayerCooldownEnd(level, player, stack, cooldown);
        this.secondProj = false;
    }
}
