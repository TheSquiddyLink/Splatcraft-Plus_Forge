package com.salmonpants.splatcraftplus.items.weapons.defaultTypes;

import net.minecraftforge.registries.RegistryObject;
import net.splatcraft.forge.items.weapons.BlasterItem;
import net.splatcraft.forge.items.weapons.settings.WeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;
public class LunaBlaster extends BlasterItem{
    private static final RegistryObject<BlasterItem> luna_blaster = SplatcraftItems.lunaBlaster;
    private static final BlasterItem item = luna_blaster.get();
    private static final WeaponSettings settings = item.settings;
    LunaBlaster(){
        super(settings);
    }
}
