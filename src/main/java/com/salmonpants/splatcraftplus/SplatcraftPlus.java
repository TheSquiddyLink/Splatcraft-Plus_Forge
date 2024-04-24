package com.salmonpants.splatcraftplus;

import com.mojang.logging.LogUtils;
import com.salmonpants.splatcraftplus.items.ColorChip;
import com.salmonpants.splatcraftplus.items.EmptyPalette;
import com.salmonpants.splatcraftplus.items.HeroBlueprint;
import com.salmonpants.splatcraftplus.items.OrderBlueprint;
import com.salmonpants.splatcraftplus.items.weapons.hero_weapons.*;
import com.salmonpants.splatcraftplus.items.weapons.order_weapons.*;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.splatcraft.forge.items.weapons.*;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("splatcraftplus")
public class SplatcraftPlus
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String MODID = "splatcraftplus";

    public static final CreativeModeTab WEAPONS = new CreativeModeTab("splatcraft_plus") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ORDER_BLUEPRINT.get());
        }
    };
    public static final CreativeModeTab GENERAL = new CreativeModeTab("splatcraft_plus.general") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ORDER_BLUEPRINT.get());
        }
    };


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    
    // Order Weapons
    public static final RegistryObject<Item> ORDER_BLUEPRINT = ITEMS.register("order_blueprint", () -> new OrderBlueprint());
    public static final RegistryObject<ShooterItem> OCTOSHOT = ITEMS.register("octoshot", () -> new OctoShot());
    public static final RegistryObject<ShooterItem> ORDERSHOT = ITEMS.register("ordershot", () -> new Ordershot());
    public static final RegistryObject<DualieItem> ORDER_DUALIES = ITEMS.register("order_dualie", () -> new OrderDualie());
    public static final RegistryObject<BlasterItem> ORDER_BLASTER = ITEMS.register("order_blaster", () -> new OrderBlaster());
    public static final RegistryObject<SlosherItem> ORDER_SLOSHER = ITEMS.register("order_slosher", () -> new OrderSlosher());
    public static final RegistryObject<RollerItem> ORDER_BRUSH = ITEMS.register("order_brush", () -> new OrderBrush());

    // Hero Weapons
    public static final RegistryObject<Item> HERO_BLUEPRINT = ITEMS.register("hero_blueprint", () -> new HeroBlueprint());
    public static final RegistryObject<ShooterItem> HEROSHOT_1 = ITEMS.register("heroshot_1", () -> new HeroShot_1());
    public static final RegistryObject<ShooterItem> HEROSHOT_2 = ITEMS.register("heroshot_2", ()-> new HeroShot_2());
    public static final RegistryObject<ShooterItem> HEROSHOT_3 = ITEMS.register("heroshot_3", () -> new HeroShot_3());
    public static final RegistryObject<ChargerItem> HERO_CHARGER = ITEMS.register("hero_charger", () -> new HeroCharger());
    public static final RegistryObject<BlasterItem> HERO_BLASTER = ITEMS.register("hero_blaster",() -> new HeroBlaster());
    public static final RegistryObject<SlosherItem> HERO_SLOSHER = ITEMS.register("hero_slosher", () -> new HeroSlosher());
    public static final RegistryObject<RollerItem> HERO_BRUSH = ITEMS.register("herobrush", () -> new HeroBrush());
    public static final RegistryObject<SplatlingItem> HERO_SPLATLING = ITEMS.register("hero_splatling", () -> new HeroSplatling());
    
    // Palettes
    public static final RegistryObject<Item> EMPTY_PALETTE = ITEMS.register("empty_palette", () -> new EmptyPalette());
    public static final RegistryObject<EmptyPalette> BIG_MAN_PALETTE = ITEMS.register("big_man_palette",() -> new EmptyPalette());
    public static final RegistryObject<EmptyPalette> PEARL_PALETTE = ITEMS.register("pearl_palette",() -> new EmptyPalette());
    public static final RegistryObject<EmptyPalette> AGENT_4_PALETTE = ITEMS.register("agent_4_palette",() -> new EmptyPalette());

    // Chips
    public static final RegistryObject<Item> POWER_CHIP = ITEMS.register("power_chip", () -> new ColorChip());
    public static final RegistryObject<Item> SUPPORT_CHIP = ITEMS.register("support_chip", () -> new ColorChip());
    public static final RegistryObject<Item> RANGE_CHIP = ITEMS.register("range_chip", () -> new ColorChip());
    public static final RegistryObject<Item> MOBILITY_CHIP = ITEMS.register("mobility_chip", () -> new ColorChip());
    public static final RegistryObject<Item> LUCKY_CHIP = ITEMS.register("lucky_chip", () -> new ColorChip());
    public static final RegistryObject<Item> DRONE_CHIP = ITEMS.register("drone_chip", () -> new ColorChip());
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("splatcraftplus", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
