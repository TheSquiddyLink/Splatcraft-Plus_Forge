package com.salmonpants.splatcraftplus.items.weapons.defaultTypes;
import net.minecraftforge.registries.RegistryObject;
import net.splatcraft.forge.items.weapons.DualieItem;
import net.splatcraft.forge.items.weapons.settings.WeaponSettings;
import net.splatcraft.forge.registries.SplatcraftItems;

public class Splatdualie extends DualieItem {
    private static RegistryObject<DualieItem> splattershot = SplatcraftItems.splatDualie;
    private static DualieItem item = splattershot.get();
    private static WeaponSettings settings = item.settings;
    public Splatdualie() {
        super(settings);
    }
}
