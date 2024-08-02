package com.nemonotfound.nemosfarming.mixin;

import com.nemonotfound.nemosfarming.enchantment.ModEnchantments;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
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
            boolean hasFarmersKnowledge = EnchantmentHelper.getLevel(ModEnchantments.FARMERS_KNOWLEDGE, hoe) > 0;
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
        boolean hasHoeReaperEnchantment = EnchantmentHelper.getLevel(ModEnchantments.REAPER, hoe) > 0;

        if (isBlockCropBlock && hasHoeReaperEnchantment) {
            for (int i = 0; i < 27; i++) {
                BlockPos nextPos = getNextBlockPos(pos, i);

                breakCrop(world, nextPos, miner);
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    @Unique
    private BlockPos getNextBlockPos(BlockPos pos, int i) {
        int x = (i / 9) - 1;
        int y = ((i / 3) % 3) -1;
        int z = (i % 3) - 1;

        return pos.add(x, y, z);
    }

    @Unique
    private void breakCrop(World world, BlockPos pos, LivingEntity miner) {
        BlockState nextBlockState = world.getBlockState(pos);
        Block nextBlock = nextBlockState.getBlock();

        if (nextBlock instanceof CropBlock && canMine(nextBlockState, world, pos, (PlayerEntity) miner)) {
            breakBlock(world, nextBlockState, pos, miner);
        }
    }

    @Unique
    private void breakBlock(World world, BlockState blockState, BlockPos pos, LivingEntity breakingEntity) {
        FluidState fluidState = world.getFluidState(pos);
        if (!(blockState.getBlock() instanceof AbstractFireBlock)) {
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(blockState));
        }

        BlockEntity blockEntity = blockState.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(blockState, world, pos, blockEntity, breakingEntity, breakingEntity.getMainHandStack());

        boolean blockStateIsSet = world.setBlockState(pos, fluidState.getBlockState(), Block.NOTIFY_ALL, 512);

        if (blockStateIsSet) {
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(breakingEntity, blockState));
        }

    }
}
