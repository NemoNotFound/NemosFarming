package com.nemonotfound.nemos.farming.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemos.farming.utils.EnchantmentUtils;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FarmlandBlock.class)
public class FarmlandBlockMixin {

    @Definition(id = "random", field = "Lnet/minecraft/world/World;random:Lnet/minecraft/util/math/random/Random;")
    @Definition(id = "nextFloat", method = "Lnet/minecraft/util/math/random/Random;nextFloat()F")
    @Expression("((double) ?.random.nextFloat()) < ? - 0.5")
    @ModifyExpressionValue(method = "onLandedUpon", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean onLandedUpon(boolean original, @Local(argsOnly = true) Entity entity, @Local(argsOnly = true) World world) {
        if (original && entity instanceof PlayerEntity player) {
            ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

            if (boots.isIn(ItemTags.FOOT_ARMOR)) {
                return !EnchantmentUtils.hasEnchantment(world, Enchantments.FEATHER_FALLING, boots);
            }
        }

        return original;
    }
}