package org.crackvacking.trinketsandstuff.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;

public class ManaLimitSyncDataS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        ((IEntityDataSaver) client.player).getPersistentData().putInt("mana_limit", buf.readInt());
    }
}
