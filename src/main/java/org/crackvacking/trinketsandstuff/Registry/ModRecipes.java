package org.crackvacking.trinketsandstuff.Registry;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.recipe.runecrafterRecipe;

public class ModRecipes {
    public static void Register(){
        Registry.register(Registry.RECIPE_SERIALIZER,new Identifier("trinketsandstuff", runecrafterRecipe.Serializer.ID),runecrafterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE,new Identifier("trinketsandstuff", runecrafterRecipe.Type.ID),runecrafterRecipe.Type.INSTANCE);
    }
}
