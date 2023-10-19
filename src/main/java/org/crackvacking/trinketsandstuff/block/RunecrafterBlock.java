package org.crackvacking.trinketsandstuff.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.crackvacking.trinketsandstuff.block.entity.ModBlockEntities;
import org.crackvacking.trinketsandstuff.block.entity.RunecrafterBlockentity;
import org.jetbrains.annotations.Nullable;


public class RunecrafterBlock extends BlockWithEntity implements BlockEntityProvider {

    public RunecrafterBlock(Settings settings) {
        super(settings);
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof RunecrafterBlockentity) {
                ItemScatterer.spawn(world, pos, (RunecrafterBlockentity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }

        return ActionResult.SUCCESS;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state){
        return  BlockRenderType.MODEL;
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.8125),
                                 VoxelShapes.cuboid(0.375, 0.0625, 0.375, 0.625, 0.75, 0.625),
                                 VoxelShapes.cuboid(0.0625, 0.75, 0.0625, 0.9375, 0.8125, 0.9375),
                                 VoxelShapes.cuboid(0.3125, 0.0625, 0.3125, 0.375, 0.75, 0.375),
                                 VoxelShapes.cuboid(0.3125, 0.0625, 0.625, 0.375, 0.75, 0.6875),
                                 VoxelShapes.cuboid(0.625, 0.0625, 0.625, 0.6875, 0.75, 0.6875),
                                 VoxelShapes.cuboid(0.625, 0.0625, 0.3125, 0.6875, 0.75, 0.375));
    }


    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RunecrafterBlockentity(pos,state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.runecrafter_block_entity,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}