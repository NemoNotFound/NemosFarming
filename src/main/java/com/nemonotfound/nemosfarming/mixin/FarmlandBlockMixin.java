package com.nemonotfound.nemosfarming.mixin;

import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemosfarming.utils.EnchantmentUtils;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {

    @Expression("? < ?")
    @ModifyExpressionValue(method = "onLandedUpon", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean onLandedUpon(boolean original, @Local(argsOnly = true) Entity entity, @Local(argsOnly = true) World world) {
        if (original) {
            PlayerEntity player = (PlayerEntity) entity;
            Iterable<ItemStack> armorStacks = player.getAllArmorItems();

            for (ItemStack armorStack : armorStacks) {
                if (armorStack.isIn(ItemTags.FOOT_ARMOR)) {
                    return !EnchantmentUtils.hasEnchantment(world, Enchantments.FEATHER_FALLING, armorStack);
                }
            }
        }

        return original;
    }
}