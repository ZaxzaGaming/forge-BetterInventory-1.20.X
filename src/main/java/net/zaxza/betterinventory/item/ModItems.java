package net.zaxza.betterinventory.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zaxza.betterinventory.BetterInventory;
import net.zaxza.betterinventory.item.custom.FuelItem;
import net.zaxza.betterinventory.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterInventory .MOD_ID);

    public static final RegistryObject<Item> INVENTORY_CORE = ITEMS.register("inventory_core",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_CORE = ITEMS.register("raw_core",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
        ()-> new Item(new Item.Properties().food(ModFoods.STAWBERRY)));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            ()-> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
