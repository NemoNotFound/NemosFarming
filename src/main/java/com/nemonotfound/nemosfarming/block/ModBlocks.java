package com.nemonotfound.nemosfarming.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nemonotfound.nemosfarming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemosfarming.NemosFarming.log;

public class ModBlocks {

    public static final Block LETTUCE = register("lettuce",
            LettuceCropBlock::new, AbstractBlock.Settings.copy(Blocks.CARROTS));
    public static final Block TOMATO = register("tomato",
            TomatoCropBlock::new, AbstractBlock.Settings.copy(Blocks.CARROTS));
    public static final Block CUCUMBER = register("cucumber",
            CucumberCropBlock::new, AbstractBlock.Settings.copy(Blocks.CARROTS));

    public static void registerBlocks() {
        log.info("Registering blocks");
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, id));
    }

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Blocks.register(keyOf(id), factory, settings);
    }
}
