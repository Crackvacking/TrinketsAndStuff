package org.crackvacking.trinketsandstuff.mixin;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.crackvacking.trinketsandstuff.networking.ModMessages;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;
import org.crackvacking.trinketsandstuff.util.ManaControll;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class RegisterPlayer {

    @Inject(method = "init()V", at = @At("HEAD"))
    protected void registerMana(CallbackInfo ci){
        IEntityDataSaver player = (IEntityDataSaver) MinecraftClient.getInstance().player;
        assert player != null;
        ManaControll.registerPlayer(player);
        ClientPlayNetworking.send(ModMessages.MANA_ID, PacketByteBufs.create());
    }
}
