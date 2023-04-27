package org.crackvacking.trinketsandstuff;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.crackvacking.trinketsandstuff.Registry.ModBlocks;
import org.crackvacking.trinketsandstuff.Registry.ModEntities;
import org.crackvacking.trinketsandstuff.Registry.ModItems;
import org.crackvacking.trinketsandstuff.Registry.ModRecipes;
import org.crackvacking.trinketsandstuff.block.entity.ModBlockEntities;
import org.crackvacking.trinketsandstuff.screen.ModScreenHandlers;
import org.crackvacking.trinketsandstuff.screen.runecrafterScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("TAS");

	@Override
	public void onInitialize() {
		ModItems.Register();
		ModEntities.Register();
		ModBlocks.Register();
		ModBlockEntities.registerAllBlockEntities();
		HandledScreens.register(ModScreenHandlers.RUNECRAFTER_SCREEN_HANDLER, runecrafterScreen::new);
		ModRecipes.Register();
	}
}
