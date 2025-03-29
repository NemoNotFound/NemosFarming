package com.nemonotfound.nemos.farming.datagen.langdatagen;

import com.nemonotfound.nemos.farming.block.ModBlocks;
import com.nemonotfound.nemos.farming.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class GermanLanguageGenerator extends FabricLanguageProvider {

    public GermanLanguageGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "de_de", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.LETTUCE, "Kopfsalat");
        translationBuilder.add(ModItems.LETTUCE, "Kopfsalat");
        translationBuilder.add(ModItems.LETTUCE_SEEDS, "Kopfsalatsamen");
        translationBuilder.add(ModBlocks.TOMATO, "Tomate");
        translationBuilder.add(ModItems.TOMATO, "Tomate");
        translationBuilder.add(ModItems.TOMATO_SEEDS, "Tomatensamen");
        translationBuilder.add(ModItems.CUCUMBER, "Gurke");
        translationBuilder.add(ModItems.CUCUMBER_SEEDS, "Gurkensamen");
        translationBuilder.add(ModItems.MIXED_SALAD, "Gemischter Salat");
        translationBuilder.add(ModItems.MIXED_SALAD_WITH_CARROTS, "Gemischter Salat mit Karotten");
        translationBuilder.add(ModItems.MIXED_SALAD_WITH_BEETROOT, "Gemischter Salat mit roter Bete");
    }
}
