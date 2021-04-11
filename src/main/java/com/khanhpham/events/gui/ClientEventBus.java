package com.khanhpham.events.gui;

import com.khanhpham.GeneralModding;
import com.khanhpham.registries.ModRegistries;
import com.khanhpham.registries.blocks.cabinet.CabinetScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GeneralModding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBus {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.register(ModRegistries.CABINET_CONTAINER.get(), CabinetScreen::new);
    }
}
