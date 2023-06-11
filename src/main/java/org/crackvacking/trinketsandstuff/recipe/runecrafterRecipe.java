package org.crackvacking.trinketsandstuff.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.crackvacking.trinketsandstuff.block.entity.runecrafterblockentity;

public class runecrafterRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;

    private runecrafterblockentity runecrafter;

    public runecrafterRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()) { return false; }
        for (int i = 0; i < (inventory.size()-1); i++) {
            if(!recipeItems.get(i).test(inventory.getStack(i))) {
                return false;
            }
        }return true;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<runecrafterRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "runecrafter";
    }

    public static class Serializer implements RecipeSerializer<runecrafterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "runecrafter";
        // this is the name given in the json file

        @Override
        public runecrafterRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));

            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(8, Ingredient.EMPTY);



            for (int i = 0; i < inputs.size(); i++) {
                if (ingredients.get(i).toString().equals("{\"item\":\"\"}") || ingredients.get(i).toString().equals("{\"item\":\"minecraft:air\"}")){
                    inputs.set(i, Ingredient.EMPTY);
                }
                else{
                    inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
                }
            }

            return new runecrafterRecipe(id, output, inputs);
        }

        @Override
        public runecrafterRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new runecrafterRecipe(id, output, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, runecrafterRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}