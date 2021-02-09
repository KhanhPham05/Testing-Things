package com.khanhpham.datagen.recipe;

import com.khanhpham.datagen.tag.ModTags;
import com.khanhpham.setup.ModBlocks;
import com.khanhpham.setup.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;

import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider {

    public ModRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        storageBlock(consumer, ModItems.COPPER_INGOT.get(), ModBlocks.COPPER_BLOCK.get(),"has_copper_ingot");
        ingotFromStorageBlock(consumer, ModItems.COPPER_INGOT.get(), ModTags.Items.STORAGE_BLOCKS_COPPER, "has_copper_block");
        smeltingRecipe(consumer, ModBlocks.COPPER_ORE.get(), ModItems.COPPER_INGOT.get(), 0.5f, 20, "has_copper_ore");
    }

    //CRAFTING RECIPE
    private void storageBlock(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider result, String criterionName) {
        ShapedRecipeBuilder.shapedRecipe(result)
                .key('I', input)
                .patternLine("III")
                .patternLine("III")
                .patternLine("III")
                .addCriterion(criterionName, hasItem(input))
                .build(consumer);
    }

    private void ingotFromStorageBlock(Consumer<IFinishedRecipe> consumer, IItemProvider storageBlock, ITag<Item> blockTag, String criterionName) {
        ShapelessRecipeBuilder.shapelessRecipe(storageBlock, 9)
                .addIngredient(blockTag)
                .addCriterion(criterionName, hasItem(blockTag))
                .build(consumer);
    }

    //SMELTING RECIPE
    private void smeltingRecipe(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output, float exp, int tick, String criterionName) {
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(input), output, exp, tick)
                .addCriterion(criterionName, hasItem(input))
                .build(consumer);
    }
}

