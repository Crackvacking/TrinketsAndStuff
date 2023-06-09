package org.crackvacking.trinketsandstuff.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.networking.packet.ManaC2SPacket;
import org.crackvacking.trinketsandstuff.networking.packet.ManaLimitSyncDataS2CPacket;
import org.crackvacking.trinketsandstuff.networking.packet.ManaSyncDataS2CPacket;

public class ModMessages {
    public static final Identifier MANA_SYNC_ID = new Identifier("trinketsandstuff", "mana_sync");
    public static final Identifier MANA_LIMIT_SYNC_ID = new Identifier("trinketsandstuff", "mana_limit");
    public static final Identifier MANA_ID = new Identifier("trinketsandstuff", "mana");

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC_ID, ManaSyncDataS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(MANA_LIMIT_SYNC_ID, ManaLimitSyncDataS2CPacket::receive);
    }

    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(MANA_ID, ManaC2SPacket::receive);
    }
}
