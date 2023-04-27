package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.entities.TestEntityModel;
import org.crackvacking.trinketsandstuff.entities.TestEntityRenderer;
import org.crackvacking.trinketsandstuff.entities.TestEntity;

public class ModEntities {
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("entitytesting", "cube"), "main");
    public static final EntityType<TestEntity> testie = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("trinketsandstuff", "testie"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TestEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static void Register(){
        FabricDefaultAttributeRegistry.register(testie, TestEntity.createMobAttributes());

        EntityRendererRegistry.register(testie, (context) -> {
            return new TestEntityRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, TestEntityModel::getTexturedModelData);
    }
}
