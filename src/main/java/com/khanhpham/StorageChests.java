package com.khanhpham;

import com.khanhpham.setup.ModItems;
import com.khanhpham.setup.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(StorageChests.MOD_ID)
public class StorageChests {
    public static final String MOD_ID = "storage_chests";
    private static final Logger LOGGER = LogManager.getLogger();

    public StorageChests() {
        Registration.register();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final ItemGroup ITEM_GROUP = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_INGOT.get());
        }
    };


}
