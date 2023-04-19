package org.crackvacking.trinketsandstuff;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.crackvacking.trinketsandstuff.Registry.ModEntities;
import org.crackvacking.trinketsandstuff.Registry.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("TAS");
	@Override
	public void onInitialize() {
		ModItems.Register();
		ModEntities.Register();
	}
}
