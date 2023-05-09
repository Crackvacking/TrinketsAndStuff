package org.crackvacking.trinketsandstuff.util;

import net.minecraft.nbt.NbtCompound;

public class ManaControll {
    public static void addMana(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        if(nbt.get("mana_limit")!=null){
            int mana = nbt.getInt("mana");
            int mana_lim = nbt.getInt("mana_limit");
            if((mana + amount)<mana_lim){
                nbt.putInt("mana", (mana + amount));
            }
            else{
                nbt.putInt("mana", mana_lim);
            }
        }
        else {
            nbt.putInt("mana_limit", 100);
        }
    }

    public static void removeMana(IEntityDataSaver player, int amount){
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("mana");
        if((mana - amount)>0){
            nbt.putInt("mana", (mana - amount));
        }
        else{
            nbt.putInt("mana", 0);
        }
    }

    public static void setLimit(IEntityDataSaver player, int value){
        NbtCompound nbt = player.getPersistentData();
        if(value>nbt.getInt("mana")){
            nbt.putInt("mana", value);
        }
        nbt.putInt("mana_limit", value);
    }

    public static int getLimit(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt("mana_limit");
    }

    public static int getMana(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt("mana");
    }
}
