package com.khanhpham.datagen;

import com.khanhpham.StorageChests;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, StorageChests.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /**This method will take the id of the block for first String value
         *
         *Then call method modLoc and enter the name String value, It's should be the location of the block model json file when generated
         * It 's should be:  "blocks/BLOCK_ID"
         * {@link net.minecraftforge.client.model.generators.ModelProvider#modLoc(String name)}
         */
        withExistingParent("copper_ore", modLoc("blocks/copper_ore"));
        withExistingParent("copper_block", modLoc("blocks/copper_block"));

        /**
         * This will generate a exited model json file and generate
         * a copy for the item id that we have in {@link com.khanhpham.setup.ModItems}
         *
         * @see net.minecraftforge.client.model.generators.ModelFile
         */
        ModelFile itemGenerator = getExistingFile(modLoc("item/generated"));

        buildModel(itemGenerator, "copper_ingot");
        buildModel(itemGenerator, "copper_sheet");
    }


    //7:29
    //https://www.youtube.com/watch?v=YD_ajlZ5TdY
    private void buildModel(ModelFile itemGenerator,String name) {
        getBuilder(name).parent(itemGenerator).texture("layer0", "items/" + name);
    }
}
