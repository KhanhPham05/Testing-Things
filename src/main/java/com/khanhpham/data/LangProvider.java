package com.khanhpham.data;

import com.khanhpham.GeneralModding;
import com.khanhpham.registries.ModRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class LangProvider extends LanguageProvider {
    public LangProvider(DataGenerator gen) {
        super(gen, GeneralModding.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModRegistries.CABINET_ITEM, "Cabinet");
        add(ModRegistries.TABLET, "Tablet");
        add(ModRegistries.HELLO_WORLD_i, "Hello World Block");
    }

    private <T extends Item> void add(RegistryObject<T> reg, String trans) {
        super.add(reg.get(), trans);
    }
}
