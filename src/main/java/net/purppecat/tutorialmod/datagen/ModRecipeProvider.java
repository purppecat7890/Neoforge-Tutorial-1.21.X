package net.purppecat.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.purppecat.tutorialmod.block.ModBlocks;
import net.purppecat.tutorialmod.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MAGICSTICK.get())
                .pattern("B")
                .pattern("A")
                .define('B', Items.IRON_INGOT)
                .define('A', Items.STICK)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(recipeOutput);

    }
}
