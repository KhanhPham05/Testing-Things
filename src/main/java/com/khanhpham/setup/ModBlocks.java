package com.khanhpham.setup;


import com.khanhpham.StorageChests;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> COPPER_ORE = registry("copper_ore", () ->
            new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(3, 10).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.ANCIENT_DEBRIS).setRequiresTool()));

    public static final RegistryObject<Block> COPPER_BLOCK = registry("copper_block", () ->
            new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(3, 12).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.ANCIENT_DEBRIS).setRequiresTool()));

    static void register() {
    }

    //Helper method for registry block
    private static <T extends Block> RegistryObject<T> registryNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    //helper method for registry BlockItem
    private static <T extends Block> RegistryObject<T> registry(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = registryNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().group(StorageChests.ITEM_GROUP)));
        return registryObject;
    }
}
