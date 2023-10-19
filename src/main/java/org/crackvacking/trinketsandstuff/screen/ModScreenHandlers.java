package org.crackvacking.trinketsandstuff.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.Main;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RunecrafterScreenHandler> RUNECRAFTER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(ModConstants.MODID, "runecrafter"),
                    new ExtendedScreenHandlerType<>(RunecrafterScreenHandler::new));

    public static void registerScreenHandlers() {
    }
}