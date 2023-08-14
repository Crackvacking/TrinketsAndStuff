package org.crackvacking.trinketsandstuff.screen;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModScreenHandlers {
    public static ScreenHandlerType<RunecrafterScreenHandler> RUNECRAFTER_SCREEN_HANDLER =
            Registry.register(
                    Registry.SCREEN_HANDLER,
                    new Identifier(ModConstants.MODID, "runecrafter"),
                    new ScreenHandlerType<>(RunecrafterScreenHandler::new)
            );
}
