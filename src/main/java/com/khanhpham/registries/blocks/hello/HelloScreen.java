package com.khanhpham.registries.blocks.hello;

import com.khanhpham.GeneralModding;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;


/**
 * @see net.minecraft.client.gui.screen.inventory.ChestScreen
 * @see net.minecraft.client.gui.screen.inventory.CraftingScreen
 */

public class HelloScreen extends Screen {
    protected HelloScreen() {
        super(new TranslationTextComponent("hello.title"));
    }
    @Override
    public boolean shouldCloseOnEsc() {
        return true;
    }

    //194, 135
    //U is horizontal coordinate on the texture. V is vertical
    @SuppressWarnings("deprecation")
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        RenderSystem.color4f(1, 1, 1, 1);
        this.minecraft.getTextureManager().bind(new ResourceLocation(GeneralModding.MOD_ID, "textures/gui/hello.png"));
        this.blit(matrixStack, 125, 50, 0, 0, 194, 135);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
    @Override
    protected void init() {
        addButton(new Button(150, 100, 160,20, new TranslationTextComponent("press_me.button"), button -> sendMessage("hi", true)));
    }

    @Override
    public void renderBackground(MatrixStack matrixStack) {
        super.renderBackground(matrixStack);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
