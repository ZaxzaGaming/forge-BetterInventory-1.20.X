package net.zaxza.betterinventory.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.zaxza.betterinventory.BetterInventory;
import net.zaxza.betterinventory.Util.ModTags;
import net.zaxza.betterinventory.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BetterInventory.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.CORE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_CORE_BLOCK.get(),
                        ModBlocks.CORE_BLOCK.get(),
                        ModBlocks.CORE_ORE.get(),
                        ModBlocks.DEEPSLATE_CORE_ORE.get(),
                        ModBlocks.NETHER_CORE_ORE.get(),
                        ModBlocks.END_STONE_CORE_ORE.get()
                        );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_CORE_BLOCK.get(),
                        ModBlocks.CORE_ORE.get(),
                        ModBlocks.DEEPSLATE_CORE_ORE.get(),
                        ModBlocks.NETHER_CORE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CORE_BLOCK.get(),
                        ModBlocks.END_STONE_CORE_ORE.get());
        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

    }
}
