package org.crackvacking.trinketsandstuff.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.crackvacking.trinketsandstuff.util.IEntityDataSaver;
import org.crackvacking.trinketsandstuff.util.ManaControll;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;


public class ManaCommands {
    public static void Register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated){
        dispatcher.register(CommandManager.literal("tas")
                            .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(4))
                            .then(CommandManager.literal("mana")
                            .then(CommandManager.literal("add")
                            .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                            .executes(context -> addManaCommand(context.getSource(), getInteger(context, "amount")))))));

        dispatcher.register(CommandManager.literal("tas")
                            .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(4))
                            .then(CommandManager.literal("mana")
                            .then(CommandManager.literal("remove")
                            .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                            .executes(context -> removeManaCommand(context.getSource(), getInteger(context, "amount")))))));

        dispatcher.register(CommandManager.literal("tas")
                            .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(4))
                            .then(CommandManager.literal("mana")
                            .then(CommandManager.literal("set_limit")
                            .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                            .executes(context -> setManaLimCommand(context.getSource(), getInteger(context, "amount")))))));

        dispatcher.register(CommandManager.literal("tas")
                            .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(4))
                            .then(CommandManager.literal("mana")
                            .then(CommandManager.literal("query")
                            .executes(context -> getManaCommand(context.getSource())))));

        dispatcher.register(CommandManager.literal("tas")
                            .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(4))
                            .then(CommandManager.literal("mana")
                            .then(CommandManager.literal("get_limit")
                            .executes(context -> getManaLimCommand(context.getSource())))));
    }

    private static int addManaCommand(ServerCommandSource source, int amount){
        ManaControll.addMana((IEntityDataSaver) source.getEntity(), amount);
        return Command.SINGLE_SUCCESS;
    }

    private static int removeManaCommand(ServerCommandSource source, int amount){
        ManaControll.removeMana((IEntityDataSaver) source.getEntity(), amount);
        return Command.SINGLE_SUCCESS;
    }

    private static int setManaLimCommand(ServerCommandSource source, int value){
        ManaControll.setLimit((IEntityDataSaver) source.getEntity(), value);
        return Command.SINGLE_SUCCESS;
    }

    private static int getManaLimCommand(ServerCommandSource source){
        ServerPlayerEntity player = (ServerPlayerEntity) source.getEntity();
        player.sendMessage(Text.literal("Your mana limit is §2"+ManaControll.getLimit((IEntityDataSaver) source.getEntity())), false);
        return Command.SINGLE_SUCCESS;
    }

    private static int getManaCommand(ServerCommandSource source){
        ServerPlayerEntity player = (ServerPlayerEntity) source.getEntity();
        player.sendMessage(Text.literal("Your mana level is §3" + ManaControll.getMana((IEntityDataSaver) source.getEntity())), false);
        return Command.SINGLE_SUCCESS;
    }
}
