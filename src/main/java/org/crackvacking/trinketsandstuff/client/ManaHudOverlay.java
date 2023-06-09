package org.crackvacking.trinketsandstuff.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawableHelper;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;
import org.crackvacking.trinketsandstuff.util.ManaControll;

public class ManaHudOverlay implements HudRenderCallback {
    public static final Identifier MANA_HUD = new Identifier("trinketsandstuff", "textures/gui/manabar.png");
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();

        if(client != null){
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f,1f,1f,1f);
        RenderSystem.setShaderTexture(0, MANA_HUD);
        if(MinecraftClient.getInstance().player.getInventory().getMainHandStack().toString().equals("1 wand")){
            DrawableHelper.drawTexture(matrixStack, x-197, y-19, 0, 42,58,  18, 64, 64);
            DrawableHelper.drawTexture(matrixStack, x-197, y-19, 0, 23, ManaControll.getScaledManaProgress((IEntityDataSaver) MinecraftClient.getInstance().player), 18, 64, 64);
            DrawableHelper.drawTexture(matrixStack, x-200, y-22, 0, 0, 62, 22, 64, 64);
        }
    }
}
