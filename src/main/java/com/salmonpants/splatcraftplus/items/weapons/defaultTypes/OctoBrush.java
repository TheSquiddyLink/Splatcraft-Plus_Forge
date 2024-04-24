package com.salmonpants.splatcraftplus.items.weapons.defaultTypes;

import net.minecraftforge.registries.RegistryObject;
import net.splatcraft.forge.items.weapons.RollerItem;
import net.splatcraft.forge.items.weapons.settings.RollerWeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;

public class OctoBrush extends RollerItem {
    private static final RegistryObject<RollerItem> octobrush = SplatcraftItems.octobrush;
    private static final RollerItem item = octobrush.get();
    private static final RollerWeaponSettings settings = item.settings;

    public OctoBrush(){
        super(settings);
    }
}
