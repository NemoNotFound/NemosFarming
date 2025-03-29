package com.nemonotfound.nemos.farming.item;

import com.nemonotfound.nemos.farming.block.ModBlocks;
import com.nemonotfound.nemos.farming.component.type.ModFoodComponents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import java.util.function.Function;

import static com.nemonotfound.nemos.farming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemos.farming.NemosFarming.log;
import static net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL;

public class ModItems {

    public static final Item LETTUCE = register("lettuce", new Item.Settings().food(ModFoodComponents.LETTUCE));
    public static final Item LETTUCE_SEEDS = register("lettuce_seeds", createBlockItemWithUniqueName(ModBlocks.LETTUCE));
    public static final Item TOMATO = register("tomato", new Item.Settings().food(ModFoodComponents.TOMATO));
    public static final Item TOMATO_SEEDS = register("tomato_seeds", createBlockItemWithUniqueName(ModBlocks.TOMATO));
    public static final Item CUCUMBER = register("cucumber", new Item.Settings().food(ModFoodComponents.CUCUMBER));
    public static final Item CUCUMBER_SEEDS = register("cucumber_seeds", createBlockItemWithUniqueName(ModBlocks.CUCUMBER));
    public static final Item MIXED_SALAD = register("mixed_salad", new Item.Settings().maxCount(1).food(ModFoodComponents.MIXED_SALAD).useRemainder(Items.BOWL));
    public static final Item MIXED_SALAD_WITH_CARROTS = register("mixed_salad_with_carrots", new Item.Settings().maxCount(1).food(ModFoodComponents.MIXED_SALAD_WITH_CARROTS).useRemainder(Items.BOWL));
    public static final Item MIXED_SALAD_WITH_BEETROOT = register("mixed_salad_with_beetroot", new Item.Settings().maxCount(1).food(ModFoodComponents.MIXED_SALAD_WITH_BEETROOT).useRemainder(Items.BOWL));

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

        TradeOfferHelper.registerWanderingTraderOffers(factories -> {
            factories.addOffersToPool(SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1),
                    new ItemStack(LETTUCE_SEEDS, 1), 12, 1, 0.05f));

            factories.addOffersToPool(SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1),
                    new ItemStack(TOMATO_SEEDS, 1), 12, 1, 0.05f));

            factories.addOffersToPool(SELL_COMMON_ITEMS_POOL, (entity, random) -> new TradeOffer(new TradedItem(Items.EMERALD, 1),
                    new ItemStack(CUCUMBER_SEEDS, 1), 12, 1, 0.05f));
        });
    }

    public static Item register(String id, Item.Settings settings) {
        return Items.register(keyOf(id), Item::new, settings);
    }

    public static Item register(String id, Function<Item.Settings, Item> factory) {
        return Items.register(keyOf(id), factory, new Item.Settings());
    }

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, id));
    }

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }
}
