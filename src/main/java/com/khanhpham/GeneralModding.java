package com.khanhpham;

import com.khanhpham.registries.ModRegistries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(GeneralModding.MOD_ID)
public class GeneralModding {
    public static final String MOD_ID = "generalmod";

    public static ItemGroup RANDOM_THINGS = new ItemGroup("randomThings"){

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModRegistries.TABLET.get());
        }
    };

    public GeneralModding() {
        MinecraftForge.EVENT_BUS.register(this);
        ModRegistries.register();
    }
}
