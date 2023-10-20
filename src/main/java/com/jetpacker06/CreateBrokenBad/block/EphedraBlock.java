package com.jetpacker06.CreateBrokenBad.block;

import com.jetpacker06.CreateBrokenBad.register.CBBItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class EphedraBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty CROP_AGE = IntegerProperty.create("age", 0, MAX_AGE);

    public EphedraBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return CBBItems.EPHEDRA_SEEDS.get();
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return CROP_AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CROP_AGE);
    }
}
