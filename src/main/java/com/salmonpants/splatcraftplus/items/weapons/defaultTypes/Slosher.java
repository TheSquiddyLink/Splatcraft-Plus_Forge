package com.salmonpants.splatcraftplus.items.weapons.defaultTypes;

import net.minecraftforge.registries.RegistryObject;
import net.splatcraft.forge.items.weapons.SlosherItem;
import net.splatcraft.forge.items.weapons.settings.WeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;

public class Slosher extends SlosherItem{
    private static final RegistryObject<SlosherItem> SLOSHER = SplatcraftItems.slosher;
    private static final SlosherItem item = SLOSHER.get();
    private static final WeaponSettings settings = item.settings;
    Slosher() {
        super(settings);
    }
}
