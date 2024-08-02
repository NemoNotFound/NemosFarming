package com.nemonotfound.nemosfarming;

import com.nemonotfound.nemosfarming.datagen.EnchantmentGenerator;
import com.nemonotfound.nemosfarming.datagen.EnchantmentTagGenerator;
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
	}
}
