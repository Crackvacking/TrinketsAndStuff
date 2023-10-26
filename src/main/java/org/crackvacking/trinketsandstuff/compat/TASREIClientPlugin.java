package org.crackvacking.trinketsandstuff.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import org.crackvacking.trinketsandstuff.Registry.ModBlocks;
import org.crackvacking.trinketsandstuff.recipe.RunecrafterRecipe;
import org.crackvacking.trinketsandstuff.screen.RunecrafterScreen;

public class TASREIClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new RunecrafterCategory());

        registry.addWorkstations(RunecrafterCategory.runecrafter, EntryStacks.of(ModBlocks.runecrafter));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(RunecrafterRecipe.class, RunecrafterRecipe.Type.INSTANCE,
                RuneCrafterDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75, 30, 20, 30), RunecrafterScreen.class,
                RunecrafterCategory.runecrafter);
    }
}