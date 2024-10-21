package com.nemonotfound.nemosfarming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

import static com.nemonotfound.nemosfarming.enchantment.ModEnchantments.*;

public class EnchantmentTagGenerator extends FabricTagProvider.EnchantmentTagProvider {

    public EnchantmentTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        RegistryWrapper.Impl<Enchantment> enchantmentRegistryWrapper = wrapperLookup.getOrThrow(RegistryKeys.ENCHANTMENT);

        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE)
                .add(enchantmentRegistryWrapper.getOrThrow(FARMERS_KNOWLEDGE).registryKey())
                .add(enchantmentRegistryWrapper.getOrThrow(REAPER).registryKey())
                .add(enchantmentRegistryWrapper.getOrThrow(REPLANTING).registryKey());

        getOrCreateTagBuilder(EnchantmentTags.ON_RANDOM_LOOT)
                .add(enchantmentRegistryWrapper.getOrThrow(FARMERS_KNOWLEDGE).registryKey())
                .add(enchantmentRegistryWrapper.getOrThrow(REAPER).registryKey())
                .add(enchantmentRegistryWrapper.getOrThrow(REPLANTING).registryKey());

        getOrCreateTagBuilder(EnchantmentTags.ON_TRADED_EQUIPMENT)
                .add(enchantmentRegistryWrapper.getOrThrow(FARMERS_KNOWLEDGE).registryKey())
                .add(enchantmentRegistryWrapper.getOrThrow(REAPER).registryKey())
                .add(enchantmentRegistryWrapper.getOrThrow(REPLANTING).registryKey());
    }
}
