package org.crackvacking.trinketsandstuff.Registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.recipe.RunecrafterRecipe;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModRecipes {
    public static void Register(){
        Registry.register(Registries.RECIPE_SERIALIZER,new Identifier(ModConstants.MODID, RunecrafterRecipe.Serializer.ID), RunecrafterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,new Identifier(ModConstants.MODID, RunecrafterRecipe.Type.ID), RunecrafterRecipe.Type.INSTANCE);
    }
}
