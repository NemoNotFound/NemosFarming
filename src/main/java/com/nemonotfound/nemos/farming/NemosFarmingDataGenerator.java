package com.nemonotfound.nemos.farming;

import com.nemonotfound.nemos.farming.datagen.*;
import com.nemonotfound.nemos.farming.datagen.langdatagen.EnglishLanguageGenerator;
import com.nemonotfound.nemos.farming.datagen.langdatagen.GermanLanguageGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class NemosFarmingDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageGenerator::new);
		pack.addProvider(GermanLanguageGenerator::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(LootTableGnerator::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(RegistryProvider::new);
	}
}
