package com.salmonpants.splatcraftplus.items.weapons.defaultTypes;

import net.minecraftforge.registries.RegistryObject;
import net.splatcraft.forge.items.weapons.BlasterItem;
import net.splatcraft.forge.items.weapons.settings.WeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;
public class LunaBlaster extends BlasterItem{
    private static RegistryObject<BlasterItem> luna_blaster = SplatcraftItems.lunaBlaster;
    private static BlasterItem item = luna_blaster.get();
    private static WeaponSettings settings = item.settings;
    public LunaBlaster(){
        super(settings);
    }
}
