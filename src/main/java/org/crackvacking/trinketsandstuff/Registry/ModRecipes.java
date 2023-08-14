package org.crackvacking.trinketsandstuff.Registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.recipe.RunecrafterRecipe;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModRecipes {
    public static void Register(){
        Registry.register(Registry.RECIPE_SERIALIZER,new Identifier(ModConstants.MODID, RunecrafterRecipe.Serializer.ID), RunecrafterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE,new Identifier(ModConstants.MODID, RunecrafterRecipe.Type.ID), RunecrafterRecipe.Type.INSTANCE);
    }
}
