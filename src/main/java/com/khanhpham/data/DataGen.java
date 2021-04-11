package com.khanhpham.data;

import com.khanhpham.GeneralModding;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = GeneralModding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    private DataGen() {
    }

    /**
    * Event method have to be <strong>public static void</strong>
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper file = event.getExistingFileHelper();

        gen.addProvider(new BlockStateModel(gen, file));
        gen.addProvider(new ItemModel(gen, file));
        gen.addProvider(new LootProvider(gen));
        gen.addProvider(new LangProvider(gen));
    }
}
