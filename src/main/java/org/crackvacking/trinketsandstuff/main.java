package org.crackvacking.trinketsandstuff;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import org.crackvacking.trinketsandstuff.Registry.*;
import org.crackvacking.trinketsandstuff.block.entity.ModBlockEntities;
import org.crackvacking.trinketsandstuff.block.entity.renderer.RunecrafterBlockentityRenderer;
import org.crackvacking.trinketsandstuff.client.ManaHudOverlay;
import org.crackvacking.trinketsandstuff.networking.ModMessages;
import org.crackvacking.trinketsandstuff.screen.ModScreenHandlers;
import org.crackvacking.trinketsandstuff.screen.RunecrafterScreen;
import org.crackvacking.trinketsandstuff.screen.RunecrafterScreenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class main implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("TAS");

	@Override
	public void onInitialize() {
		ModItems.Register();
		ModEntities.Register();
		ModBlocks.Register();
		ModRecipes.Register();
		ModCommands.Register();
		ModBlockEntities.registerAllBlockEntities();
		ModItemGroup.registerItemGroups();
		GeckoLib.initialize();
		ModMessages.registerS2CPackets();
		ModMessages.registerC2SPackets();

		// move this to another class later
		HandledScreens.register(ModScreenHandlers.RUNECRAFTER_SCREEN_HANDLER, RunecrafterScreen::new);
		HudRenderCallback.EVENT.register(new ManaHudOverlay());

		BlockEntityRendererFactories.register(ModBlockEntities.runecrafter_block_entity, RunecrafterBlockentityRenderer::new);
	}
}
