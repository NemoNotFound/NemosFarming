package com.nemonotfound.nemosfarming.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosfarming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemosfarming.NemosFarming.log;

public class ModEnchantments {

    public static final Enchantment REAPER = register(
            "reaper", new ReaperEnchantment(Enchantment.properties(ItemTags.HOES, 1, 1,
                    Enchantment.constantCost(15), Enchantment.constantCost(65), 8,
                    EquipmentSlot.MAINHAND)));
    public static final Enchantment FARMERS_KNOWLEDGE = register(
            "farmers_knowledge", new FarmersKnowledgeEnchantment(Enchantment.properties(ItemTags.HOES, 1, 1,
                    Enchantment.constantCost(15), Enchantment.constantCost(65), 8,
                    EquipmentSlot.MAINHAND)));

    public static void registerEnchantments() {
        log.info("Nemo's Farming: Register enchantments");
    }

    private static Enchantment register(String path, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, Identifier.of(MOD_ID, path), enchantment);
    }
}
