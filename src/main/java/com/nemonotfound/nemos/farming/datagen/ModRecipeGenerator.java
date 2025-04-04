package com.nemonotfound.nemos.farming.datagen;

import com.nemonotfound.nemos.farming.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                this.createShapeless(RecipeCategory.FOOD, ModItems.MIXED_SALAD)
                        .input(ModItems.TOMATO)
                        .input(ModItems.LETTUCE)
                        .input(ModItems.CUCUMBER)
                        .input(Items.BOWL)
                        .criterion("has_mixed_salad", conditionsFromItem(ModItems.MIXED_SALAD))
                        .criterion("has_bowl", conditionsFromItem(Items.BOWL))
                        .criterion("has_tomato", conditionsFromItem(ModItems.TOMATO))
                        .criterion("has_lettuce", conditionsFromItem(ModItems.LETTUCE))
                        .criterion("has_cucumber", conditionsFromItem(ModItems.CUCUMBER))
                        .offerTo(exporter);
                this.createShapeless(RecipeCategory.FOOD, ModItems.MIXED_SALAD_WITH_CARROTS)
                        .input(ModItems.TOMATO)
                        .input(ModItems.LETTUCE)
                        .input(ModItems.CUCUMBER)
                        .input(Items.CARROT)
                        .input(Items.BOWL)
                        .criterion("has_mixed_salad", conditionsFromItem(ModItems.MIXED_SALAD))
                        .criterion("has_bowl", conditionsFromItem(Items.BOWL))
                        .criterion("has_tomato", conditionsFromItem(ModItems.TOMATO))
                        .criterion("has_lettuce", conditionsFromItem(ModItems.LETTUCE))
                        .criterion("has_cucumber", conditionsFromItem(ModItems.CUCUMBER))
                        .criterion("has_carrot", conditionsFromItem(Items.CARROT))
                        .offerTo(exporter);
                this.createShapeless(RecipeCategory.FOOD, ModItems.MIXED_SALAD_WITH_CARROTS)
                        .input(Items.CARROT)
                        .input(ModItems.MIXED_SALAD)
                        .criterion("has_mixed_salad", conditionsFromItem(ModItems.MIXED_SALAD))
                        .criterion("has_bowl", conditionsFromItem(Items.BOWL))
                        .criterion("has_tomato", conditionsFromItem(ModItems.TOMATO))
                        .criterion("has_lettuce", conditionsFromItem(ModItems.LETTUCE))
                        .criterion("has_cucumber", conditionsFromItem(ModItems.CUCUMBER))
                        .criterion("has_carrot", conditionsFromItem(Items.CARROT))
                        .offerTo(exporter, getItemId(ModItems.MIXED_SALAD_WITH_CARROTS).withSuffixedPath("_2").getPath());
                this.createShapeless(RecipeCategory.FOOD, ModItems.MIXED_SALAD_WITH_BEETROOT)
                        .input(ModItems.TOMATO)
                        .input(ModItems.LETTUCE)
                        .input(ModItems.CUCUMBER)
                        .input(Items.BEETROOT)
                        .input(Items.BOWL)
                        .criterion("has_mixed_salad", conditionsFromItem(ModItems.MIXED_SALAD))
                        .criterion("has_bowl", conditionsFromItem(Items.BOWL))
                        .criterion("has_tomato", conditionsFromItem(ModItems.TOMATO))
                        .criterion("has_lettuce", conditionsFromItem(ModItems.LETTUCE))
                        .criterion("has_cucumber", conditionsFromItem(ModItems.CUCUMBER))
                        .criterion("has_beetroot", conditionsFromItem(Items.BEETROOT))
                        .offerTo(exporter);
                this.createShapeless(RecipeCategory.FOOD, ModItems.MIXED_SALAD_WITH_BEETROOT)
                        .input(Items.BEETROOT)
                        .input(ModItems.MIXED_SALAD)
                        .criterion("has_mixed_salad", conditionsFromItem(ModItems.MIXED_SALAD))
                        .criterion("has_bowl", conditionsFromItem(Items.BOWL))
                        .criterion("has_tomato", conditionsFromItem(ModItems.TOMATO))
                        .criterion("has_lettuce", conditionsFromItem(ModItems.LETTUCE))
                        .criterion("has_cucumber", conditionsFromItem(ModItems.CUCUMBER))
                        .criterion("has_beetroot", conditionsFromItem(Items.BEETROOT))
                        .offerTo(exporter, getItemId(ModItems.MIXED_SALAD_WITH_BEETROOT).withSuffixedPath("_2").getPath());
                this.createShapeless(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS, 2)
                        .input(ModItems.TOMATO)
                        .criterion("has_tomato", conditionsFromItem(ModItems.TOMATO))
                        .criterion("has_tomato_seeds", conditionsFromItem(ModItems.TOMATO_SEEDS))
                        .offerTo(exporter);
                this.createShapeless(RecipeCategory.FOOD, ModItems.LETTUCE_SEEDS, 2)
                        .input(ModItems.LETTUCE)
                        .criterion("has_lettuce", conditionsFromItem(ModItems.LETTUCE))
                        .criterion("has_lettuce_seeds", conditionsFromItem(ModItems.LETTUCE_SEEDS))
                        .offerTo(exporter);
                this.createShapeless(RecipeCategory.FOOD, ModItems.CUCUMBER_SEEDS, 2)
                        .input(ModItems.CUCUMBER)
                        .criterion("has_cucumber", conditionsFromItem(ModItems.CUCUMBER))
                        .criterion("has_cucumber_seeds", conditionsFromItem(ModItems.CUCUMBER_SEEDS))
                        .offerTo(exporter);
            }

            private static Identifier getItemId(ItemConvertible item) {
                return Registries.ITEM.getId(item.asItem());
            }
        };
    }

    @Override
    public String getName() {
        return "Nemo's Farming Recipes";
    }
}
