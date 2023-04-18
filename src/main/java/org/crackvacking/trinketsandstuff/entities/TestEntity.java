package org.crackvacking.trinketsandstuff.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;

public class TestEntity extends MobEntity {
    public TestEntity(EntityType<? extends MobEntity> entityType, World world){
        super(entityType, world);
    }
}

