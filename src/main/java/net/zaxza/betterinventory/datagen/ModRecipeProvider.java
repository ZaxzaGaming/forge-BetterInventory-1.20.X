package net.zaxza.betterinventory.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.zaxza.betterinventory.BetterInventory;
import net.zaxza.betterinventory.block.ModBlocks;
import net.zaxza.betterinventory.item.ModItems;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CORE_SMELTTABLES = List.of(ModItems.RAW_CORE.get(),
            ModBlocks.CORE_ORE.get(),
            ModBlocks.DEEPSLATE_CORE_ORE.get(),
            ModBlocks.NETHER_CORE_ORE.get(),
            ModBlocks.END_STONE_CORE_ORE.get());
    private static final List<ItemLike> CORE_BLOCK_SMELTTABLES = List.of(ModBlocks.RAW_CORE_BLOCK.get();
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, CORE_SMELTTABLES, RecipeCategory.MISC, ModItems.INVENTORY_CORE.get(), 0.2F, 200, "inventory_core");
        oreSmelting(pWriter, CORE_BLOCK_SMELTTABLES, RecipeCategory.MISC, ModBlocks.CORE_BLOCK.get(), 0.2F, 100, "core_block");
        oreBlasting(pWriter, CORE_SMELTTABLES, RecipeCategory.MISC, ModItems.INVENTORY_CORE.get(), 0.2F, 1000, "inventory_core");
        oreBlasting(pWriter, CORE_BLOCK_SMELTTABLES, RecipeCategory.MISC, ModBlocks.CORE_BLOCK.get(), 0.2F, 500, "Method...");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CORE_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.INVENTORY_CORE.get())
                .unlockedBy(getHasName(ModItems.INVENTORY_CORE.get()), has(ModItems.INVENTORY_CORE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CORE_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.RAW_CORE.get())
                .unlockedBy(getHasName(ModItems.RAW_CORE.get()), has(ModItems.RAW_CORE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.INVENTORY_CORE.get(), 9)
                .requires(ModBlocks.CORE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CORE_BLOCK.get()), has(ModBlocks.CORE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CORE.get(), 9)
                .requires(ModBlocks.RAW_CORE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_CORE_BLOCK.get()), has(ModBlocks.RAW_CORE_BLOCK.get()))
                .save(pWriter);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, BetterInventory.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
