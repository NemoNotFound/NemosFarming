package com.nemonotfound.nemos.farming.datagen.langdatagen;

import com.nemonotfound.nemos.farming.block.ModBlocks;
import com.nemonotfound.nemos.farming.enchantment.ModEnchantments;
import com.nemonotfound.nemos.farming.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnglishLanguageGenerator extends FabricLanguageProvider {

    public EnglishLanguageGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(getEnchantmentTranslationKey(ModEnchantments.REAPER), "Reaper");
        translationBuilder.add(getEnchantmentTranslationKey(ModEnchantments.FARMERS_KNOWLEDGE), "Farmer's Knowledge");
        translationBuilder.add(getEnchantmentTranslationKey(ModEnchantments.REPLANTING), "Replanting");
        translationBuilder.add(ModBlocks.LETTUCE, "Lettuce");
        translationBuilder.add(ModItems.LETTUCE, "Lettuce");
        translationBuilder.add(ModItems.LETTUCE_SEEDS, "Lettuce Seeds");
        translationBuilder.add(ModBlocks.TOMATO, "Tomato");
        translationBuilder.add(ModItems.TOMATO, "Tomato");
        translationBuilder.add(ModItems.TOMATO_SEEDS, "Tomato Seeds");
        translationBuilder.add(ModItems.CUCUMBER, "Cucumber");
        translationBuilder.add(ModItems.CUCUMBER_SEEDS, "Cucumber Seeds");
        translationBuilder.add(ModItems.MIXED_SALAD, "Mixed Salad");
        translationBuilder.add(ModItems.MIXED_SALAD_WITH_CARROTS, "Mixed Salad with Carrots");
        translationBuilder.add(ModItems.MIXED_SALAD_WITH_BEETROOT, "Mixed Salad with Beetroot");
    }

    public static String getEnchantmentTranslationKey(RegistryKey<Enchantment> enchantmentRegistryKey) {
        return enchantmentRegistryKey.getValue().toTranslationKey("enchantment");
    }
}
