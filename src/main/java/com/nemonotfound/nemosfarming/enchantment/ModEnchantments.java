package com.nemonotfound.nemosfarming.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemosfarming.NemosFarming.MOD_ID;
import static com.nemonotfound.nemosfarming.NemosFarming.log;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> FARMERS_KNOWLEDGE = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "farmers-knowledge"));
    public static final RegistryKey<Enchantment> REAPER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(MOD_ID, "reaper"));

    public static void registerEnchantments() {
        log.info("Register enchantments");

    }
}
