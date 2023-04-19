package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.item.runes.*;

public class ModItems {
    private static final ItemGroup TAS = FabricItemGroupBuilder.create(new Identifier("trinketsandstuff", "tas"))
            .icon(() -> new ItemStack(ModItems.aqua)).build();
    public static final org.crackvacking.trinketsandstuff.item.runes.aqua aqua = new aqua(new FabricItemSettings().group(TAS).maxCount(1));
    public static final org.crackvacking.trinketsandstuff.item.runes.igni igni = new igni(new FabricItemSettings().group(TAS).maxCount(1));
    public static final org.crackvacking.trinketsandstuff.item.runes.terra terra = new terra(new FabricItemSettings().group(TAS).maxCount(1));
    public static final org.crackvacking.trinketsandstuff.item.runes.anima anima = new anima(new FabricItemSettings().group(TAS).maxCount(1));
    public static final org.crackvacking.trinketsandstuff.item.runes.caelum caelum = new caelum(new FabricItemSettings().group(TAS).maxCount(1));
    public static final org.crackvacking.trinketsandstuff.item.runes.mortus mortus = new mortus(new FabricItemSettings().group(TAS).maxCount(1));
    public static final org.crackvacking.trinketsandstuff.item.runes.perdito perdito = new perdito(new FabricItemSettings().group(TAS).maxCount(1));

    public static void Register(){
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","aqua"),aqua);
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","igni"),igni);
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","terra"),terra);
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","anima"),anima);
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","caelum"),caelum);
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","mortus"),mortus);
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff","perdito"),perdito);
    }
    // Mody powinny być pisane w *python*
}
