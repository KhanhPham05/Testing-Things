package com.khanhpham.datagen;

import com.khanhpham.StorageChests;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = StorageChests.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator  = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        /**
         * All the data provider classes have to be called in ' new ClassName() '
         * DataGenerator.addProvider(new ClassName());
         */
        generator.addProvider(new ModItemModelProvider(generator, fileHelper));
        generator.addProvider(new ModBlockStateProvider(generator, fileHelper));

    }
}
