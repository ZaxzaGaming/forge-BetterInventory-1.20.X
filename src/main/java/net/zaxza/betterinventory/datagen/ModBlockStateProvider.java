package net.zaxza.betterinventory.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.zaxza.betterinventory.BetterInventory;
import net.zaxza.betterinventory.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BetterInventory.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CORE_BLOCK);
        blockWithItem(ModBlocks.RAW_CORE_BLOCK);

        blockWithItem(ModBlocks.CORE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CORE_ORE);
        blockWithItem(ModBlocks.NETHER_CORE_ORE);
        blockWithItem(ModBlocks.END_STONE_CORE_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
