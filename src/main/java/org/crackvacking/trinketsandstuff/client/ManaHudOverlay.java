package org.crackvacking.trinketsandstuff.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawableHelper;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;
import org.crackvacking.trinketsandstuff.util.ManaControll;

import static org.crackvacking.trinketsandstuff.Registry.ModItems.wand;

public class ManaHudOverlay implements HudRenderCallback {
    public static final Identifier MANA_HUD = new Identifier("trinketsandstuff", "textures/gui/manabar_anim.png");

    int frame = 0;
    float time;
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();

        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        time += MinecraftClient.getInstance().getTickDelta();

        if(time>25){
            frame = frame==17?0:frame+1;
            time=0;
        };


        //Dynamic HUD handling™
        int displacement = MinecraftClient.getInstance().player.getStackInHand(Hand.OFF_HAND).isEmpty() ? 40 : 11;

        //Define texture
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, MANA_HUD);

        //Texture drawing
        if (MinecraftClient.getInstance().player.getStackInHand(Hand.MAIN_HAND).getItem()== wand){
            DrawableHelper.drawTexture(matrixStack, x - 197 + displacement, y - 19, 123, 3, 58, 18, 180, 396);
            DrawableHelper.drawTexture(matrixStack, x - 197 + displacement, y - 19, 64, 3+(22*frame), ManaControll.getScaledManaProgress((IEntityDataSaver) MinecraftClient.getInstance().player), 18, 180, 396);
            DrawableHelper.drawTexture(matrixStack, x - 200 + displacement, y - 22, 0, 0, 62, 22, 180, 396);
        }
    }
}
