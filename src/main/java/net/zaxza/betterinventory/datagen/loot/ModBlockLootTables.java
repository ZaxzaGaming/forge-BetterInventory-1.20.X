package net.zaxza.betterinventory.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.zaxza.betterinventory.block.ModBlocks;
import net.zaxza.betterinventory.item.ModItems;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CORE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CORE_BLOCK.get());
        //this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.CORE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.CORE_ORE.get(), ModItems.RAW_CORE.get()));
        this.add(ModBlocks.DEEPSLATE_CORE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_CORE_ORE.get(), ModItems.RAW_CORE.get()));
        this.add(ModBlocks.NETHER_CORE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_CORE_ORE.get(), ModItems.RAW_CORE.get()));
        this.add(ModBlocks.END_STONE_CORE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_CORE_ORE.get(), ModItems.RAW_CORE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
