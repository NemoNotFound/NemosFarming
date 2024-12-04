package com.nemonotfound.nemos.farming;

import com.nemonotfound.nemos.farming.block.ModBlocks;
import com.nemonotfound.nemos.farming.item.ModItemGroups;
import com.nemonotfound.nemos.farming.item.ModItems;
import com.nemonotfound.nemos.farming.loot.ModLootTables;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosFarming implements ModInitializer {

	public static final String MOD_ID = "nemos-farming";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		log.info("Thank you for using Nemo's Farming!");

		ModBlocks.registerBlocks();
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModLootTables.registerLootTables();
	}
}