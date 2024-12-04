package com.nemonotfound.nemos.farming.enchantment;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.farming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemos.farming.NemosFarming.log;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> FARMERS_KNOWLEDGE = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "farmers_knowledge"));
    public static final RegistryKey<Enchantment> REAPER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "reaper"));
    public static final RegistryKey<Enchantment> REPLANTING = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "replanting"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        log.info("Register enchantments");

        RegistryEntryLookup<Item> itemRegistryLookup = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, FARMERS_KNOWLEDGE, Enchantment.builder(Enchantment.definition(
                itemRegistryLookup.getOrThrow(ItemTags.HOES),
                1,
                1,
                Enchantment.constantCost(15),
                Enchantment.constantCost(65),
                8,
                AttributeModifierSlot.MAINHAND)));

        register(registerable, REPLANTING, Enchantment.builder(Enchantment.definition(
                itemRegistryLookup.getOrThrow(ItemTags.HOES),
                1,
                1,
                Enchantment.constantCost(15),
                Enchantment.constantCost(65),
                8,
                AttributeModifierSlot.MAINHAND)));

        register(registerable, REAPER, Enchantment.builder(Enchantment.definition(
                itemRegistryLookup.getOrThrow(ItemTags.HOES),
                2,
                3,
                Enchantment.leveledCost(15, 9),
                Enchantment.leveledCost(65, 9),
                4,
                AttributeModifierSlot.MAINHAND)));
    }

    private static void register(Registerable<Enchantment> registerable, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registerable.register(key, builder.build(key.getValue()));
    }
}
