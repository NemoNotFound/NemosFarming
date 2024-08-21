package com.nemonotfound.nemosfarming;

import com.nemonotfound.nemosfarming.block.ModBlocks;
import com.nemonotfound.nemosfarming.enchantment.ModEnchantments;
import com.nemonotfound.nemosfarming.item.ModItemGroups;
import com.nemonotfound.nemosfarming.item.ModItems;
import com.nemonotfound.nemosfarming.loot.ModLootTables;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosFarming implements ModInitializer {

	public static final String MOD_ID = "nemos-farming";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		log.info("Thank you for using Nemo's Farming!");

		ModEnchantments.registerEnchantments();
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModLootTables.registerLootTables();
	}
}