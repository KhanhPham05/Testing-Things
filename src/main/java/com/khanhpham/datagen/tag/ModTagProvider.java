package com.khanhpham.datagen.tag;

import com.khanhpham.StorageChests;
import com.khanhpham.setup.ModBlocks;
import com.khanhpham.setup.ModItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModTagProvider {
    public static final class Blocks extends BlockTagsProvider {

        public Blocks(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
            super(generatorIn, StorageChests.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerTags() {
            getOrCreateBuilder(ModTags.Blocks.ORES_COPPER).add(ModBlocks.COPPER_ORE.get());
            getOrCreateBuilder(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_COPPER);
            getOrCreateBuilder(ModTags.Blocks.STORAGE_BLOCKS_COPPER).add(ModBlocks.COPPER_BLOCK.get());
            getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_COPPER);
        }
    }

    public static final class Items extends ItemTagsProvider {


        public Items(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
            super(dataGenerator, blockTagsProvider ,StorageChests.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerTags() {
            copy(ModTags.Blocks.STORAGE_BLOCKS_COPPER, ModTags.Items.STORAGE_BLOCKS_COPPER);
            copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
            copy(ModTags.Blocks.ORES_COPPER, ModTags.Items.ORES_COPPER);
            copy(Tags.Blocks.ORES, Tags.Items.ORES);



            getOrCreateBuilder(ModTags.Items.INGOTS_COPPER).add(ModItems.COPPER_INGOT.get());
            getOrCreateBuilder(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_COPPER);
        }
    }
}
