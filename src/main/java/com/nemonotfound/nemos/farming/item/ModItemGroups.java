package com.nemonotfound.nemos.farming.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemos.farming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemos.farming.NemosFarming.log;

public class ModItemGroups {

    public static void registerItemGroups() {
        log.info("Registering item groups");

        registerNemosFarmingItemGroup();
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
                    entries.add(ModItems.RED_GRAPES);
                })
                .build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID, MOD_ID), itemGroup);
    }
}
