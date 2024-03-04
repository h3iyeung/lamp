package io.github.h3iyeung.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class LampBlock extends HorizontalFacingBlock {

	public LampBlock(AbstractBlock.Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(Properties.HORIZONTAL_FACING);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return VoxelShapes.union(
			Block.createCuboidShape(4.325, 0.0, 4.325, 11.675, 0.225, 4.675), Block.createCuboidShape(4.325, 0.0, 4.575, 4.675, 0.225, 11.425), Block.createCuboidShape(11.325, 0.0, 4.575, 11.675, 0.225, 11.425)
			, Block.createCuboidShape(4.325, 0.0, 11.325, 11.675, 0.225, 11.675)
		);
	}



	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
	}

	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
		return LampBlock.sideCoversSmallSquare(world,pos.offset(Direction.DOWN),Direction.UP);
	}
}
