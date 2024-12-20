package com.nemonotfound.nemos.farming;

import com.nemonotfound.nemos.farming.datagen.*;
import com.nemonotfound.nemos.farming.datagen.langdatagen.EnglishLanguageGenerator;
import com.nemonotfound.nemos.farming.datagen.langdatagen.GermanLanguageGenerator;
import com.nemonotfound.nemos.farming.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class NemosFarmingDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageGenerator::new);
		pack.addProvider(GermanLanguageGenerator::new);
		pack.addProvider(EnchantmentTagGenerator::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(LootTableGnerator::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(RegistryProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);
	}
}
