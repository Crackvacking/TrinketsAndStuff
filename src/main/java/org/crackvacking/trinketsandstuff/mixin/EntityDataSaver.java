package org.crackvacking.trinketsandstuff.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityDataSaver implements IEntityDataSaver {

    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData(){
        if(this.persistentData == null){
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void writeNbtData(NbtCompound nbt, CallbackInfoReturnable info){
        if(persistentData != null){
            nbt.put("trinketsandstuff.mod_data", persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void readNbtData(NbtCompound nbt, CallbackInfo info){
        if (nbt.contains("trinketsandstuff.mod_data", 10)){
            persistentData = nbt.getCompound("trinketsandstuff.mod_data");
        }
    }
}