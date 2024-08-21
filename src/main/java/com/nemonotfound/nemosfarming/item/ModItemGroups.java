package com.nemonotfound.nemosfarming.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosfarming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemosfarming.NemosFarming.log;

public class ModItemGroups {

    public static void registerItemGroups() {
        log.info("Registering item groups");

        registerNemosFarmingItemGroup();
        modifyFoodAndDrinkItemGroup();
        modifyNaturalItemGroup();
    }

    private static void registerNemosFarmingItemGroup() {
        ItemGroup itemGroup = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.TOMATO))
                .displayName(Text.literal("Nemo's Farming"))
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.TOMATO);
                    entries.add(ModItems.LETTUCE);
                    entries.add(ModItems.CUCUMBER);
                    entries.add(ModItems.MIXED_SALAD);
                    entries.add(ModItems.MIXED_SALAD_WITH_CARROTS);
                    entries.add(ModItems.MIXED_SALAD_WITH_BEETROOT);
                    entries.add(ModItems.TOMATO_SEEDS);
                    entries.add(ModItems.LETTUCE_SEEDS);
                    entries.add(ModItems.CUCUMBER_SEEDS);
                })
                .build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID), itemGroup);
    }

    private static void modifyFoodAndDrinkItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.BEETROOT, ModItems.TOMATO);
            entries.addAfter(ModItems.TOMATO, ModItems.LETTUCE);
            entries.addAfter(ModItems.LETTUCE, ModItems.CUCUMBER);
            entries.addBefore(Items.MUSHROOM_STEW, ModItems.MIXED_SALAD);
            entries.addBefore(Items.MUSHROOM_STEW, ModItems.MIXED_SALAD_WITH_CARROTS);
            entries.addBefore(Items.MUSHROOM_STEW, ModItems.MIXED_SALAD_WITH_BEETROOT);
        });
    }

    private static void modifyNaturalItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.BEETROOT_SEEDS, ModItems.TOMATO_SEEDS);
            entries.addAfter(ModItems.TOMATO_SEEDS, ModItems.LETTUCE_SEEDS);
            entries.addAfter(ModItems.LETTUCE_SEEDS, ModItems.CUCUMBER_SEEDS);
        });
    }
}
