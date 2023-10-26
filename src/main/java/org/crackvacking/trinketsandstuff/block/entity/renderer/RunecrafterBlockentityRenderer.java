package org.crackvacking.trinketsandstuff.block.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.crackvacking.trinketsandstuff.block.entity.RunecrafterBlockentity;

import static net.minecraft.recipe.BrewingRecipeRegistry.hasRecipe;

public class RunecrafterBlockentityRenderer implements BlockEntityRenderer<RunecrafterBlockentity> {
    int Z_rotation = 0;
    public RunecrafterBlockentityRenderer(BlockEntityRendererFactory.Context context){}

    @Override
    public void render(RunecrafterBlockentity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();


        ItemStack output_stack = entity.getRenderStack().get(8);
        matrices.push();
        matrices.translate(0.5f, 0.82f, 0.5f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        itemRenderer.renderItem(output_stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5f, 0.82f, 0.19f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(0), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.69f, 0.82f, 0.31f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(1), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.81f, 0.82f, 0.5f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(2), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.69f, 0.82f, 0.69f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(3), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5f, 0.82f, 0.82f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(4), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.31f, 0.82f, 0.69f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(5), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.19f, 0.82f, 0.5f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(6), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

        matrices.push();
        matrices.translate(0.31f, 0.82f, 0.31f);
        matrices.scale(0.15f, 0.15f, 0.15f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(Z_rotation));
        itemRenderer.renderItem(entity.getRenderStack().get(7), ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        if(true){
        Z_rotation++;
        }else{Z_rotation=0;}
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
