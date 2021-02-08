package com.khanhpham.datagen;

import com.khanhpham.StorageChests;
import com.khanhpham.datagen.loottable.ModLootTableProvider;
import com.khanhpham.datagen.tag.ModTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


/**
 * this class is the main class for data generator system. provided by the classes
 *  in the this package
 */
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
        generator.addProvider(new ModBlockStateProvider(generator, fileHelper));
        generator.addProvider(new ModItemModelProvider(generator, fileHelper));
        generator.addProvider(new ModLootTableProvider(generator));

        ModTagProvider.Blocks blockTags = new ModTagProvider.Blocks(generator, fileHelper);
        generator.addProvider(blockTags);
        generator.addProvider(new ModTagProvider.Items(generator, blockTags, fileHelper));
    }
}
