package com.salmonpants.splatcraftplus.items.weapons.defaultTypes;
import net.splatcraft.forge.items.weapons.ShooterItem;
import net.splatcraft.forge.items.weapons.settings.WeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;
import net.minecraftforge.registries.RegistryObject;

public class Splattershot extends ShooterItem {
    private static RegistryObject<ShooterItem> splattershot = SplatcraftItems.splattershot;
    private static ShooterItem item = splattershot.get();
    private static WeaponSettings settings = item.settings;
    public Splattershot() {
        super(settings);
    }
}

