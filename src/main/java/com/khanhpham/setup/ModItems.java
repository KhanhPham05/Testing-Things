package com.khanhpham.setup;

import com.khanhpham.StorageChests;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;


public class ModItems {
    public static final RegistryObject<Item> COPPER_SHEET = Registration.ITEMS.register("copper_sheet", () -> new Item(new Item.Properties().group(StorageChests.ITEM_GROUP)));
    public static final RegistryObject<Item> COPPER_INGOT = Registration.ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(StorageChests.ITEM_GROUP)));

    static void register() {}
}
