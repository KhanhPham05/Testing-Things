package com.khanhpham.datagen.tag;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        private static String path;

        private Blocks(String path) {
            Blocks.path = path;
        }

        public static final ITag.INamedTag<Block> ORES_COPPER = oreTag("copper").forgeTag();
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_COPPER = storageBlockTag("copper").forgeTag();

        private static Blocks storageBlockTag(String path) {
            return new Blocks("storage_blocks/" + path);
        }

        private static Blocks oreTag(String path) {
            return new Blocks("ores/" + path);
        }

        private static ITag.INamedTag<Block> forgeTag() {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", Blocks.path).toString());
        }
    }

    public static final class Items {
        private static String path;

        private Items(String name) {
            Items.path = name;
        }

        public static final ITag.INamedTag<Item> ORES_COPPER = oreTag("copper").forgeTag();
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_COPPER = storageBlockTag("copper").forgeTag();
        public static final ITag.INamedTag<Item> INGOTS_COPPER = ingotTag("copper").forgeTag();

        private static Items storageBlockTag(String path) {
            return new Items("storage_blocks/" + path);
        }

        private static Items oreTag(String path) {
            return new Items("ores/" + path);
        }

        private static Items ingotTag(String path) {
            return new Items("ingots/" + path);
        }

        private static ITag.INamedTag<Item> forgeTag() {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", Items.path).toString());
        }
    }
}
