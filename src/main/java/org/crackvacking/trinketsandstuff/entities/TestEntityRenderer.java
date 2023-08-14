package org.crackvacking.trinketsandstuff.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.Registry.ModEntities;
import org.crackvacking.trinketsandstuff.util.ModConstants;

@Environment(EnvType.CLIENT)
public class TestEntityRenderer extends MobEntityRenderer<TestEntity, TestEntityModel> {
    public TestEntityRenderer(EntityRendererFactory.Context context){
        super(context, new TestEntityModel(context.getPart(ModEntities.MODEL_CUBE_LAYER)), 0.5f);
    }
    public static final Identifier TEXTURE = new Identifier(ModConstants.MODID,"textures/entity/testentity.png");

    @Override
    public Identifier getTexture(TestEntity entity) { return TEXTURE;}
}