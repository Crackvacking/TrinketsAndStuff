package org.crackvacking.trinketsandstuff.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;
import org.crackvacking.trinketsandstuff.util.ManaControll;

public class ManaC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender){
        ManaControll.syncMana(((IEntityDataSaver) player).getPersistentData().getInt("mana")-1, player);
        ManaControll.syncMana(((IEntityDataSaver) player).getPersistentData().getInt("mana")+1, player);
        player.sendMessage(new LiteralText("[LOG] Mana Status Updated!").fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), false);
    }
}
