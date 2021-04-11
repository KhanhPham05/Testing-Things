package com.khanhpham.data;

import com.khanhpham.GeneralModding;
import com.khanhpham.registries.ModRegistries;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStateModel extends BlockStateProvider {
    public BlockStateModel(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GeneralModding.MOD_ID, existingFileHelper);
    }

    /**
     * {@link BlockStateProvider#simpleBlock(Block)} is a normal/regular solid block
     * {@link BlockStateProvider#horizontalBlock(Block, ResourceLocation, ResourceLocation, ResourceLocation)} block - side - front - top
     */
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModRegistries.CABINET_BLOCK.get());
        simpleBlock(ModRegistries.HELLO_WORLD_b.get());
    }
}
