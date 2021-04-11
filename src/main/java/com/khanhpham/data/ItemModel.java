package com.khanhpham.data;

import com.khanhpham.GeneralModding;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class ItemModel extends ItemModelProvider {
    public ItemModel(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, GeneralModding.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModelFile modelFile = getExistingFile(mcLoc("item/generated"));

        withExistingParent("cabinet", modLoc("block/cabinet"));
        withExistingParent("hello_block", modLoc("block/hello_block"));


        builder(modelFile, "tablet");
    }

    private ItemModelBuilder builder(ModelFile modelFile, String name) {
        return getBuilder(name).parent(modelFile).texture("layer0", "item/" + name);
    }

    @Nonnull
    @Override
    public String getName() {
        return "General Items";
    }
}
