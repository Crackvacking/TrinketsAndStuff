package org.crackvacking.trinketsandstuff.screen;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
    public static ScreenHandlerType<runecrafterScreenHandler> RUNECRAFTER_SCREEN_HANDLER =
            Registry.register(
                    Registry.SCREEN_HANDLER,
                    new Identifier("trinketsandstuff", "runecrafter"),
                    new ScreenHandlerType<>(runecrafterScreenHandler::new)
            );
}
