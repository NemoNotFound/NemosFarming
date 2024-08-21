package com.nemonotfound.nemosfarming.loot;

import com.nemonotfound.nemosfarming.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import static com.nemonotfound.nemosfarming.NemosFarming.log;
import static net.minecraft.loot.LootTables.*;

public class ModLootTables {

    public static void registerLootTables() {
        log.info("Registering loot tables");

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == VILLAGE_PLAINS_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.TOMATO).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == VILLAGE_TAIGA_HOUSE_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.TOMATO).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS).weight(5)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == VILLAGE_SNOWY_HOUSE_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.TOMATO).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == SHIPWRECK_SUPPLY_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.TOMATO).weight(7)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER).weight(7)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE).weight(7)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == PILLAGER_OUTPOST_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.TOMATO).weight(5)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == ABANDONED_MINESHAFT_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.TOMATO_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == SIMPLE_DUNGEON_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.TOMATO_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == WOODLAND_MANSION_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.CUCUMBER_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.TOMATO_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                    builder.with(ItemEntry.builder(ModItems.LETTUCE_SEEDS).weight(10)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F))));
                });
            }
        }));

        LootTableEvents.MODIFY.register(((key, tableBuilder, source, registries) -> {
            if (key == TRIAL_CHAMBERS_SUPPLY_CHEST) {
                tableBuilder.modifyPools(builder -> {
                    builder.with(ItemEntry.builder(ModItems.MIXED_SALAD).weight(2)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))));
                    builder.with(ItemEntry.builder(ModItems.MIXED_SALAD_WITH_CARROTS).weight(2)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))));
                    builder.with(ItemEntry.builder(ModItems.MIXED_SALAD_WITH_BEETROOT).weight(2)
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))));
                });
            }
        }));
    }
}
