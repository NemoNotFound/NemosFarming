package com.nemonotfound.nemos.farming.datagen;

import com.nemonotfound.nemos.farming.block.CucumberCropBlock;
import com.nemonotfound.nemos.farming.block.LettuceCropBlock;
import com.nemonotfound.nemos.farming.block.ModBlocks;
import com.nemonotfound.nemos.farming.block.TomatoCropBlock;
import com.nemonotfound.nemos.farming.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModelProvider extends FabricModelProvider {

    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.LETTUCE, LettuceCropBlock.AGE, 0, 1, 2, 3 , 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO, TomatoCropBlock.AGE, 0, 1, 2, 3 , 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.CUCUMBER, CucumberCropBlock.AGE, 0, 1, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LETTUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CUCUMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIXED_SALAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIXED_SALAD_WITH_CARROTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIXED_SALAD_WITH_BEETROOT, Models.GENERATED);
    }
}
