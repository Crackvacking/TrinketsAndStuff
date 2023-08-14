package org.crackvacking.trinketsandstuff.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import org.crackvacking.trinketsandstuff.networking.ModMessages;

public class ManaControll {
    public static void registerPlayer(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        if(nbt.getInt("mana_limit") == 0){
            nbt.putInt("mana_limit", 100);
        }
    }
    public static void addMana(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        if(nbt.get("mana_limit")!=null){
            int mana = nbt.getInt("mana");
            int mana_lim = nbt.getInt("mana_limit");
            if((mana + amount)<mana_lim){
                nbt.putInt("mana", (mana + amount));
                syncMana((mana + amount), (ServerPlayerEntity) player);
            }
            else{
                nbt.putInt("mana", mana_lim);
                syncMana(mana_lim, (ServerPlayerEntity) player);
            }
        }
        else {
            nbt.putInt("mana_limit", 100);
            syncManaLimit(100, (ServerPlayerEntity) player);
        }
    }

    public static void removeMana(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("mana");
        if((mana - amount)>0){
            nbt.putInt("mana", (mana - amount));
            syncMana((mana - amount), (ServerPlayerEntity) player);
        }
        else{
            nbt.putInt("mana", 0);
            syncMana(0, (ServerPlayerEntity) player);
        }
    }

    public static void setLimit(IEntityDataSaver player, int value){
        NbtCompound nbt = player.getPersistentData();
        if(value<nbt.getInt("mana")){
            nbt.putInt("mana", value);
            syncMana(value, (ServerPlayerEntity) player);
        }
        nbt.putInt("mana_limit", value);
        syncManaLimit(value, (ServerPlayerEntity) player);
    }

    public static int getLimit(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt("mana_limit");
    }

    public static int getMana(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt("mana");
    }

    public static void syncMana(int mana, ServerPlayerEntity player){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(mana);
        ServerPlayNetworking.send(player, ModMessages.MANA_SYNC_ID, buf);
    }

    public static void syncManaLimit(int manaLimit, ServerPlayerEntity player){
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(manaLimit);
        ServerPlayNetworking.send(player, ModMessages.MANA_LIMIT_SYNC_ID, buf);
    }

    public static int getScaledManaProgress(IEntityDataSaver player){
        //size of progress bar texture
        int textureSize = 58;
        return getMana(player) * textureSize / getLimit(player);
    }
}
