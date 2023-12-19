package net.zaxza.betterinventory.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zaxza.betterinventory.BetterInventory;
import net.zaxza.betterinventory.block.ModBlocks;
import net.zaxza.betterinventory.item.custom.MetalDetectorItem;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BetterInventory.MOD_ID);

    public static final RegistryObject<CreativeModeTab> BETTER_INVENTORY_TAB = CREATIVE_MODE_TABS.register("better_inventory_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INVENTORY_CORE.get()))
                    .title(Component.translatable("creativetab.better_inventory_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.RAW_CORE.get());
                        pOutput.accept(ModItems.INVENTORY_CORE.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModBlocks.CORE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_CORE_BLOCK.get());

                        pOutput.accept(ModBlocks.CORE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CORE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_CORE_ORE.get());
                        pOutput.accept(ModBlocks.END_CORE_ORE.get());

                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                    })
                    .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
