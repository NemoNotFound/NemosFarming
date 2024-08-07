package com.nemonotfound.nemosfarming.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.nemonotfound.nemosfarming.enchantment.ModEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

import static com.nemonotfound.nemosfarming.utils.EnchantmentUtils.hasEnchantment;

@Debug(export = true)
@Mixin(Block.class)
public class BlockMixin {

    @ModifyReturnValue(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;", at = @At("RETURN"))
    private static List<ItemStack> getDroppedStacks(List<ItemStack> original, BlockState state, ServerWorld world, BlockPos pos,
                                                    @Nullable BlockEntity blockEntity, @Nullable Entity entity, ItemStack stack) {
        Block block = state.getBlock();

        if (block instanceof CropBlock && stack.isIn(ItemTags.HOES) && hasEnchantment(world, ModEnchantments.REPLANTING, stack)) {
            nemosFarming_replantCrops(world, pos, state, block, original);
        }

        return original;
    }

    @Unique
    private static void nemosFarming_replantCrops(ServerWorld world, BlockPos pos, BlockState state, Block block, List<ItemStack> original) {
        world.setBlockState(pos, state.with(((CropBlock) block).getAgeProperty(), 1), Block.NOTIFY_ALL, 512);

        for (ItemStack itemStack : original) {
            if (itemStack.isIn(ItemTags.VILLAGER_PLANTABLE_SEEDS)) {
                itemStack.setCount(itemStack.getCount() - 1);

                break;
            }
        }
    }

}
