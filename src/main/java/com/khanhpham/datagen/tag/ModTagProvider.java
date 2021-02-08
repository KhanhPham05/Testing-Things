package com.khanhpham.datagen.tag;

import com.khanhpham.StorageChests;
import com.khanhpham.setup.ModBlocks;
import com.khanhpham.setup.ModItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModTagProvider {
    public static final class Blocks extends BlockTagsProvider {

        public Blocks(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
            super(generatorIn, StorageChests.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerTags() {
            getOrCreateBuilder(ModTags.Blocks.ORES_COPPER).add(ModBlocks.COPPER_ORE.get());
            getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_COPPER).add(ModBlocks.COPPER_BLOCK.get());
        }
    }

    public static final class Items extends ItemTagsProvider {


        public Items(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
            super(dataGenerator, blockTagsProvider ,StorageChests.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerTags() {
            getOrCreateBuilder(ModTags.Items.INGOTS_COPPER)
            .add(ModItems.COPPER_INGOT.get());
        }
    }
}