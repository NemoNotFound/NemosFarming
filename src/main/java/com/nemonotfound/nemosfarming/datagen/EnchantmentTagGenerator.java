package com.nemonotfound.nemosfarming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnchantmentTagGenerator extends FabricTagProvider.EnchantmentTagProvider {

    public EnchantmentTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //TODO: Figure out why it's not working
//        getOrCreateTagBuilder(EnchantmentTags.IN_ENCHANTING_TABLE)
//                .add(wrapperLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(FARMERS_KNOWLEDGE).registryKey());
    }
}
