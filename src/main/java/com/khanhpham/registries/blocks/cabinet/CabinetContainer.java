package com.khanhpham.registries.blocks.cabinet;

import com.khanhpham.registries.ModRegistries;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class CabinetContainer extends Container implements IHasContainer {

    /**
     * @see ChestContainer
     */
    private final CabinetTile te;
    private final IWorldPosCallable canInteractWithCallable;

    protected CabinetContainer(final int id, final PlayerInventory inv, CabinetTile tile) {
        super(ModRegistries.CABINET_CONTAINER.get(), id);
        te = tile;
        this.canInteractWithCallable = IWorldPosCallable.create(tile.getLevel(), te.getBlockPos());

        for (int col = 0; col <= 9; col++) {
            super.addSlot(new Slot(inv, col, 8 + col * 18, 142));
        }

        //Tile Entity
        super.addSlot(new Slot(te, 0, 80, 35));
        super.addSlot(new Slot(te, 1, 80, 50));

    }

    public CabinetContainer(final int id, final PlayerInventory inv, PacketBuffer data) {
        this(id, inv, getTE(inv, data));
    }

    private static CabinetTile getTE(final PlayerInventory inv, PacketBuffer data) {
        Objects.requireNonNull(inv, "Inv Is Null !");
        Objects.requireNonNull(data, "data can not be null");

        final TileEntity te = inv.player.level.getBlockEntity(data.readBlockPos());

        if (te instanceof CabinetTile) {
            return (CabinetTile) te;
        } else throw new IllegalStateException("te isn't CabinetTile");
    }

    private void playerInventory(PlayerInventory inv) {
        for (int row = 0; row <= 3; row++) {
            for (int col = 0; col <= 9; col++) {
                super.addSlot(new Slot(inv, col * row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10+1));
            }
        }
    }

    private void playerHotBar(PlayerInventory inv) {
        for (int col = 0; col <= 9; col++) {
            super.addSlot(new Slot(inv, col, 8 + col * 18, 142+1));
        }
    }


    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     *
     * @param playerIn
     * @param index
     */
    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if (index < 36 && moveItemStackTo(stack1,CabinetTile.slots, slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if (!moveItemStackTo(stack1,0,CabinetTile.slots,false)) {
                return  ItemStack.EMPTY;
            }

            if(stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return stack;
    }

    @Override
    public Container getMenu() {
        return this;
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(canInteractWithCallable, player, ModRegistries.CABINET_BLOCK.get());
    }
}
