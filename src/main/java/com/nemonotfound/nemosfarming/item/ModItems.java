package com.nemonotfound.nemosfarming.item;

import com.nemonotfound.nemosfarming.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import static com.nemonotfound.nemosfarming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemosfarming.NemosFarming.log;

public class ModItems {

    public static final Item LETTUCE = registerItem("lettuce", new Item(new Item.Settings().food(ModFoodComponents.LETTUCE)));
    public static final Item LETTUCE_SEEDS = registerItem("lettuce_seeds",
            new AliasedBlockItem(ModBlocks.LETTUCE, new Item.Settings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoodComponents.TOMATO)));
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO, new Item.Settings()));
    public static final Item CUCUMBER = registerItem("cucumber", new Item(new Item.Settings().food(ModFoodComponents.CUCUMBER)));
    public static final Item CUCUMBER_SEEDS = registerItem("cucumber_seeds",
            new AliasedBlockItem(ModBlocks.CUCUMBER, new Item.Settings()));
    public static final Item MIXED_SALAD = registerItem("mixed_salad", new Item(new Item.Settings().maxCount(1).food(ModFoodComponents.MIXED_SALAD)));
    public static final Item MIXED_SALAD_WITH_CARROTS = registerItem("mixed_salad_with_carrots", new Item(new Item.Settings().maxCount(1).food(ModFoodComponents.MIXED_SALAD_WITH_CARROTS)));
    public static final Item MIXED_SALAD_WITH_BEETROOT = registerItem("mixed_salad_with_beetroot", new Item(new Item.Settings().maxCount(1).food(ModFoodComponents.MIXED_SALAD_WITH_BEETROOT)));

    public static void registerItems() {
        log.info("Registering items");

        addItemsToComposter();
        addItemsToVillagerTrades();
    }

    private static void addItemsToComposter() {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(LETTUCE, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(LETTUCE_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TOMATO, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(TOMATO_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CUCUMBER, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(CUCUMBER_SEEDS, 0.3f);
    }

    private static void addItemsToVillagerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(new TradedItem(LETTUCE, 24),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));

            factories.add((entity, random) -> new TradeOffer(new TradedItem(TOMATO, 24),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));

            factories.add((entity, random) -> new TradeOffer(new TradedItem(CUCUMBER, 24),
                    new ItemStack(Items.EMERALD, 1), 16, 2, 0.05f));
        });

        TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1),
                    new ItemStack(LETTUCE_SEEDS, 1), 12, 1, 0.05f));

            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1),
                    new ItemStack(TOMATO_SEEDS, 1), 12, 1, 0.05f));

            factories.add((entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1),
                    new ItemStack(CUCUMBER_SEEDS, 1), 12, 1, 0.05f));
        });
    }

    private static Item registerItem(String path, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, path), item);
    }
}
