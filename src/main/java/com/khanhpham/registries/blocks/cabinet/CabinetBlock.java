package com.khanhpham.registries.blocks.cabinet;

import com.khanhpham.registries.ModRegistries;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class CabinetBlock extends Block {
    public CabinetBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .strength(2.0f)
                .harvestTool(ToolType.AXE));
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModRegistries.CABINET_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isClientSide()) {
            TileEntity tileentity = world.getBlockEntity(pos);
            if (tileentity instanceof CabinetTile) {
                NetworkHooks.openGui((ServerPlayerEntity) player,(CabinetTile) tileentity, pos);
            }
        }
        return ActionResultType.SUCCESS;
    }

    //https://imgur.com/krR3SPH
}
