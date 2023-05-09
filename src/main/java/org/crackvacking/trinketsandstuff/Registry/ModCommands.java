package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import org.crackvacking.trinketsandstuff.command.ManaCommands;

public class ModCommands {
    public static void Register(){
        CommandRegistrationCallback.EVENT.register(ManaCommands::Register);
    }
}
