package org.crackvacking.trinketsandstuff.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;
import org.crackvacking.trinketsandstuff.recipe.RunecrafterRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RuneCrafterDisplay extends BasicDisplay {
    public RuneCrafterDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public RuneCrafterDisplay(RecipeEntry<RunecrafterRecipe> recipe) {
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
    }

    private static List<EntryIngredient> getInputList(RunecrafterRecipe recipe) {
        if(recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        for (int i = 0; i < recipe.getIngredients().size(); i++){
            list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(i)));
        }
        return list;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return RunecrafterCategory.runecrafter;
    }
}