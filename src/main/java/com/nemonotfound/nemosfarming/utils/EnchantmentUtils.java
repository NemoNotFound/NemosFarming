package com.nemonotfound.nemosfarming.utils;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class EnchantmentUtils {

    private EnchantmentUtils() {

    }

    public static boolean hasEnchantment(World world, RegistryKey<Enchantment> enchantment, ItemStack itemStack) {
        return EnchantmentHelper.getLevel(getEnchantmentRegistryEntry(world, enchantment), itemStack) > 0;
    }

    public static int getEnchantmentLevel(World world, RegistryKey<Enchantment> enchantment, ItemStack itemStack) {
        return EnchantmentHelper.getLevel(getEnchantmentRegistryEntry(world, enchantment), itemStack);
    }

    private static RegistryEntry<Enchantment> getEnchantmentRegistryEntry(World world, RegistryKey<Enchantment> enchantmentRegistryKey) {
        return world.getRegistryManager()
                .getOrThrow(RegistryKeys.ENCHANTMENT)
                .getOrThrow(enchantmentRegistryKey);
    }
}
