package com.khanhpham.registries;

import com.khanhpham.GeneralModding;
import com.khanhpham.registries.blocks.cabinet.CabinetBlock;
import com.khanhpham.registries.blocks.cabinet.CabinetContainer;
import com.khanhpham.registries.blocks.cabinet.CabinetScreen;
import com.khanhpham.registries.blocks.cabinet.CabinetTile;
import com.khanhpham.registries.blocks.hello.HelloBlock;
import com.khanhpham.registries.items.TabletItem;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.khanhpham.GeneralModding.RANDOM_THINGS;

public class ModRegistries {
    static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GeneralModding.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GeneralModding.MOD_ID);
    static final DeferredRegister<TileEntityType<?>> TILE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, GeneralModding.MOD_ID);
    static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, GeneralModding.MOD_ID);

    public static final RegistryObject<TabletItem> TABLET = registerItem("tablet", TabletItem::new);

    //https://www.youtube.com/watch?v=Rm8CupdgLrw
    //3:51
    public static final RegistryObject<Block> CABINET_BLOCK = registerBlock("cabinet", CabinetBlock::new);
    public static final RegistryObject<BlockItem> CABINET_ITEM = registerItem("cabinet", () -> new BlockItem(CABINET_BLOCK.get(), new Item.Properties().tab(RANDOM_THINGS)));

    public static final RegistryObject<Block> HELLO_WORLD_b = registerBlock("hello_block", HelloBlock::new);
    public static final RegistryObject<BlockItem> HELLO_WORLD_i = registerBlockItem("hello_block", HELLO_WORLD_b);

    public static final RegistryObject<TileEntityType<CabinetTile>> CABINET_TILE = TILE.register("cabinet_tile", () -> TileEntityType.Builder.of(CabinetTile::new, CABINET_BLOCK.get()).build(null));
    public static final RegistryObject<ContainerType<CabinetContainer>> CABINET_CONTAINER = CONTAINERS.register("cabinet_container", () ->
        IForgeContainerType.create(CabinetContainer::new)
    );

    private static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> sup) {
        return ITEMS.register(name, sup);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> sup) {
        return BLOCKS.register(name, sup);
    }

    @Deprecated
    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(RANDOM_THINGS)));
    }


    public static void register() {
        IEventBus event = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(event);
        BLOCKS.register(event);
        TILE.register(event);
        CONTAINERS.register(event);
    }
}
