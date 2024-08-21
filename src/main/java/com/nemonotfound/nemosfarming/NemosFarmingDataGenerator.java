package com.nemonotfound.nemosfarming;

import com.nemonotfound.nemosfarming.datagen.*;
import com.nemonotfound.nemosfarming.datagen.langdatagen.EnglishLanguageGenerator;
import com.nemonotfound.nemosfarming.datagen.langdatagen.GermanLanguageGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class NemosFarmingDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLanguageGenerator::new);
		pack.addProvider(GermanLanguageGenerator::new);
		pack.addProvider(EnchantmentGenerator::new);
		pack.addProvider(EnchantmentTagGenerator::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(LootTableGnerator::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(ItemTagProvider::new);
	}
}
