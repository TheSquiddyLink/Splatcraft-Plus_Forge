package com.salmonpants.splatcraftplus.items.weapons.order_weapons;
import net.splatcraft.forge.items.weapons.ShooterItem;
import net.splatcraft.forge.items.weapons.settings.WeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;
import net.minecraftforge.registries.RegistryObject;

public class OctoShot extends ShooterItem {
    private static RegistryObject<ShooterItem> splattershot = SplatcraftItems.splattershot;
    private static ShooterItem item = splattershot.get();
    private static WeaponSettings settings = item.settings;
    public OctoShot() {
        super(settings);
    }
}

