package com.nemonotfound.nemos.farming.mixin;

import com.nemonotfound.nemos.farming.enchantment.ModEnchantments;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import static com.nemonotfound.nemos.farming.utils.EnchantmentUtils.getEnchantmentLevel;
import static com.nemonotfound.nemos.farming.utils.EnchantmentUtils.hasEnchantment;

@Mixin(HoeItem.class)
public class HoeItemMixin extends Item {

    public HoeItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        ItemStack hoe = miner.getMainHandStack();
        Block block = state.getBlock();
        boolean isBlockCropBlock = block instanceof CropBlock;

        if (isBlockCropBlock) {
            boolean hasFarmersKnowledge = hasEnchantment(world, ModEnchantments.FARMERS_KNOWLEDGE, hoe);
            boolean isCropRipe = ((CropBlock) block).isMature(state);

            if (hasFarmersKnowledge) {
                return miner.isCreative() || isCropRipe;
            }
        }

        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        ItemStack hoe = miner.getMainHandStack();
        boolean isBlockCropBlock = state.getBlock() instanceof CropBlock;
        boolean hasHoeReaperEnchantment = hasEnchantment(world, ModEnchantments.REAPER, hoe);

        if (isBlockCropBlock && hasHoeReaperEnchantment) {
            int enchantmentLevel = getEnchantmentLevel(world, ModEnchantments.REAPER, hoe);
            int breakingRange = 2 * enchantmentLevel + 1;

            for (int i = 0; i < Math.pow(breakingRange, 3); i++) {
                BlockPos nextPos = nemosFarming_getNextBlockPos(pos, i, breakingRange);

                nemosFarming_breakCrop(world, nextPos, miner);
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    @Unique
    private BlockPos nemosFarming_getNextBlockPos(BlockPos pos, int i, int breakingRange) {
        int halfRange = breakingRange / 2;
        int x = (i / (breakingRange * breakingRange)) - halfRange;
        int y = ((i / breakingRange) % breakingRange) - halfRange;
        int z = (i % breakingRange) - halfRange;

        return pos.add(x, y, z);
    }

    @Unique
    private void nemosFarming_breakCrop(World world, BlockPos pos, LivingEntity miner) {
        BlockState nextBlockState = world.getBlockState(pos);
        Block nextBlock = nextBlockState.getBlock();

        if (nextBlock instanceof CropBlock && canMine(nextBlockState, world, pos, (PlayerEntity) miner)) {
            nemosFarming_breakBlock(world, nextBlockState, pos, miner);
        }
    }

    @Unique
    private void nemosFarming_breakBlock(World world, BlockState blockState, BlockPos pos, LivingEntity breakingEntity) {

        if (!(blockState.getBlock() instanceof AbstractFireBlock)) {
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(blockState));
        }

        BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(blockState, world, pos, blockEntity, breakingEntity, breakingEntity.getMainHandStack());


        if (!hasEnchantment(world, ModEnchantments.REPLANTING, breakingEntity.getMainHandStack()) && nemosFarming_setBlockState(world, pos)) {
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(breakingEntity, blockState));
        }
    }

    @Unique
    private boolean nemosFarming_setBlockState(World world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);

        return world.setBlockState(pos, fluidState.getBlockState(), Block.NOTIFY_ALL, 512);
    }
}
