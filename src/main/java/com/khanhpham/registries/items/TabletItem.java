package com.khanhpham.registries.items;

import net.minecraft.item.Item;

import static com.khanhpham.GeneralModding.RANDOM_THINGS;

public class TabletItem extends Item {
    public TabletItem() {
        super(new Item.Properties().tab(RANDOM_THINGS)
                    .stacksTo(1));
    }
}
