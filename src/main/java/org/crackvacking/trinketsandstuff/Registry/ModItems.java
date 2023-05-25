package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.item.client.wandRenderer;
import org.crackvacking.trinketsandstuff.item.runes.*;
import org.crackvacking.trinketsandstuff.item.tools.wand;
import org.lwjgl.system.CallbackI;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static org.crackvacking.trinketsandstuff.Registry.ModBlocks.*;


public class ModItems {
    private static final ItemGroup TAS = FabricItemGroupBuilder.create(new Identifier("trinketsandstuff", "tas"))
            .icon(() -> new ItemStack(ModItems.aqua)).build();
    public static final aqua aqua = new aqua(new FabricItemSettings().group(TAS).maxCount(16));
    public static final igni igni = new igni(new FabricItemSettings().group(TAS).maxCount(16));
    public static final terra terra = new terra(new FabricItemSettings().group(TAS).maxCount(16));
    public static final anima anima = new anima(new FabricItemSettings().group(TAS).maxCount(16));
    public static final caelum caelum = new caelum(new FabricItemSettings().group(TAS).maxCount(16));
    public static final mortuus mortuus = new mortuus(new FabricItemSettings().group(TAS).maxCount(16));
    public static final perdito perdito = new perdito(new FabricItemSettings().group(TAS).maxCount(16));
    public static final runeDust runedust = new runeDust(new FabricItemSettings().group(TAS));

    public static final wand wand = new wand(new FabricItemSettings().group(TAS).maxCount(1));

    public static void Register(){
        //crafting items
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","aqua"), aqua);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","igni"), igni);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","terra"), terra);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","anima"), anima);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","caelum"), caelum);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","mortuus"), mortuus);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","perdito"), perdito);
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff","runedust"), runedust);

        //block items
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff", "runecrafter"), new BlockItem(runecrafter, new FabricItemSettings().group(TAS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff", "manastone"), new BlockItem(manastone, new FabricItemSettings().group(TAS)));
        Registry.register(Registry.ITEM, new Identifier("trinketsandstuff", "managlass"), new BlockItem(managlass, new FabricItemSettings().group(TAS)));

        //tools
        Registry.register(Registry.ITEM,new Identifier("trinketsandstuff", "wand"), wand);

        //GeoItemRenderer
        GeoItemRenderer.registerItemRenderer(ModItems.wand, new wandRenderer());
    }
}
