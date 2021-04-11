package com.khanhpham.registries.blocks.cabinet;

import com.khanhpham.registries.ModRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CabinetTile extends LockableLootTileEntity/* implements ITickableTileEntity*/ {
    public static final int slots = 3;

    private NonNullList<ItemStack> itemList = NonNullList.withSize(slots, ItemStack.EMPTY);

    /**
     * @see net.minecraft.tileentity.ChestTileEntity
     */
    public CabinetTile() {
        super(ModRegistries.CABINET_TILE.get());
    }


    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.itemList;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.itemList = itemsIn;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("te.cabinet");
    }

    @Override
    protected CabinetContainer createMenu(int id, PlayerInventory player) {
        return new CabinetContainer(id, player, this);
    }

    @Override
    public int getContainerSize() {
        return itemList.size();
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        itemList = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, itemList);
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        if (!this.trySaveLootTable(compound)) {
            ItemStackHelper.saveAllItems(compound, itemList);
        }
        return compound;
    }
}

