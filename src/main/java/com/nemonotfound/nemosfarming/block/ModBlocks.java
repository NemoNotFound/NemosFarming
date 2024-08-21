package com.nemonotfound.nemosfarming.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosfarming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemosfarming.NemosFarming.log;

public class ModBlocks {

    public static final Block LETTUCE = registerBlock("lettuce",
            new LettuceCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block TOMATO = registerBlock("tomato",
            new TomatoCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block CUCUMBER = registerBlock("cucumber",
            new CucumberCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    public static void registerBlocks() {
        log.info("Registering blocks");
    }

    private static Block registerBlock(String path, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, path), block);
    }
}
