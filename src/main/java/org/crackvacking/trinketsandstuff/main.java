package org.crackvacking.trinketsandstuff;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.crackvacking.trinketsandstuff.Registry.ModEntities;
import org.crackvacking.trinketsandstuff.Registry.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("TAS");

	@Override
	public void onInitialize() {
		ModItems.Register();
		ModEntities.Register();
	}
}
