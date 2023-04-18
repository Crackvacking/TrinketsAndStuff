package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.items.testItem;

public class ModItems {

    private static final ItemGroup TAS = FabricItemGroupBuilder.create(new Identifier("trinketsandstuff", "tas"))
            .icon(() -> new ItemStack(ModItems.testItem)).build();
    public static final testItem testItem = new testItem(new FabricItemSettings().group(TAS));

    public static void Register(){
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","testitem"),testItem);
    }
    // Mody powinny być pisane w *python*
}
