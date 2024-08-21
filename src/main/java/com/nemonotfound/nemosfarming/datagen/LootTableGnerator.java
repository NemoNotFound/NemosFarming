package com.nemonotfound.nemosfarming.datagen;

import com.nemonotfound.nemosfarming.block.CucumberCropBlock;
import com.nemonotfound.nemosfarming.block.LettuceCropBlock;
import com.nemonotfound.nemosfarming.block.ModBlocks;
import com.nemonotfound.nemosfarming.block.TomatoCropBlock;
import com.nemonotfound.nemosfarming.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.IntProperty;

import java.util.concurrent.CompletableFuture;

public class LootTableGnerator extends FabricBlockLootTableProvider {

    public LootTableGnerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        generateCropLootTable(ModBlocks.LETTUCE, ModItems.LETTUCE, ModItems.LETTUCE_SEEDS, LettuceCropBlock.AGE, LettuceCropBlock.MAX_AGE);
        generateCropLootTable(ModBlocks.TOMATO, ModItems.TOMATO, ModItems.TOMATO_SEEDS, TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE);
        generateCropLootTable(ModBlocks.CUCUMBER, ModItems.CUCUMBER, ModItems.CUCUMBER_SEEDS, CucumberCropBlock.AGE, CucumberCropBlock.MAX_AGE);

    }

    private void generateCropLootTable(Block cropBlock, Item cropItem, Item cropSeedsItem, IntProperty ageProperty, int maxAge) {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(cropBlock)
                .properties(StatePredicate.Builder.create().exactMatch(ageProperty, maxAge));

        addDrop(cropBlock, cropDrops(cropBlock, cropItem, cropSeedsItem, builder));
    }
}
