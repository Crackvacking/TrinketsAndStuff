package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.items.yrden;

public class ModItems {

    private static final ItemGroup TAS = FabricItemGroupBuilder.create(new Identifier("trinketsandstuff", "tas"))
            .icon(() -> new ItemStack(ModItems.yrden)).build();
    public static final yrden yrden = new yrden(new FabricItemSettings().group(TAS).maxCount(1));

    public static void Register(){
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","yrden"),yrden);
    }
    // Mody powinny być pisane w *python*
}
