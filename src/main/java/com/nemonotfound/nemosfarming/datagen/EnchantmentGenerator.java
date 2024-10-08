package com.nemonotfound.nemosfarming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

import static com.nemonotfound.nemosfarming.enchantment.ModEnchantments.*;

public class EnchantmentGenerator extends FabricDynamicRegistryProvider {

    public EnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        Enchantment.Builder builder = Enchantment.builder(Enchantment.definition(registries.
                                getWrapperOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.HOES), 1, 1,
                                Enchantment.constantCost(15), Enchantment.constantCost(65),
                                8, AttributeModifierSlot.MAINHAND));

        Enchantment.Builder reaperEnchantmentBuilder = Enchantment.builder(Enchantment.definition(registries.
                        getWrapperOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.HOES), 2, 3,
                Enchantment.leveledCost(15, 9), Enchantment.leveledCost(65, 9),
                4, AttributeModifierSlot.MAINHAND));

        entries.add(FARMERS_KNOWLEDGE, builder.build(FARMERS_KNOWLEDGE.getValue()));
        entries.add(REAPER, reaperEnchantmentBuilder.build(REAPER.getValue()));
        entries.add(REPLANTING, builder.build(REPLANTING.getValue()));
    }

    @Override
    public String getName() {
        return "Enchantments";
    }
}
