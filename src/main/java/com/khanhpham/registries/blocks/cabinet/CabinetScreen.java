package com.khanhpham.registries.blocks.cabinet;

import com.khanhpham.GeneralModding;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.IContainerFactory;

/**
 * @see net.minecraft.client.gui.screen.inventory.ChestScreen
 * @see IContainerFactory
 */
@OnlyIn(Dist.CLIENT)
public class CabinetScreen extends ContainerScreen<CabinetContainer> {
    public CabinetScreen(CabinetContainer screenContainer, PlayerInventory inv, ITextComponent text) {
        super(screenContainer, inv, text);

        this.leftPos = this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 201;
    }

    private final ResourceLocation gui = new ResourceLocation(GeneralModding.MOD_ID, "textures/gui/cabinet_gui.png");

    @SuppressWarnings("deprecation")
    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mx, int my) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        minecraft.textureManager.bind(gui);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        blit(matrixStack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int x, int y) {
        font.draw(matrixStack, this.inventory.getDisplayName(), (float) titleLabelX, (float) titleLabelY, 4210752);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        renderTooltip(matrixStack, mouseX, mouseY);
    }
}
