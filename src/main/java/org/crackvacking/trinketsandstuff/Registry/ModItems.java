package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.item.client.WandRenderer;
import org.crackvacking.trinketsandstuff.item.runes.*;
import org.crackvacking.trinketsandstuff.item.tools.Wand;
import org.crackvacking.trinketsandstuff.util.ModConstants;

import static org.crackvacking.trinketsandstuff.Registry.ModBlocks.*;


public class ModItems {
    public static final Aqua aqua = new Aqua(new FabricItemSettings().maxCount(16));
    public static final Igni igni = new Igni(new FabricItemSettings().maxCount(16));
    public static final Terra terra = new Terra(new FabricItemSettings().maxCount(16));
    public static final Anima anima = new Anima(new FabricItemSettings().maxCount(16));
    public static final Caelum caelum = new Caelum(new FabricItemSettings().maxCount(16));
    public static final Mortuus mortuus = new Mortuus(new FabricItemSettings().maxCount(16));
    public static final Perdito perdito = new Perdito(new FabricItemSettings().maxCount(16));
    public static final RuneDust runedust = new RuneDust(new FabricItemSettings());
    public static final Wand wand = new Wand(new FabricItemSettings().maxCount(1));

    public static void Register(){
        //crafting items
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"aqua"), aqua);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"igni"), igni);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"terra"), terra);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"anima"), anima);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"caelum"), caelum);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"mortuus"), mortuus);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"perdito"), perdito);
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID,"runedust"), runedust);

        //block items
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID, "runecrafter"), new BlockItem(runecrafter, new FabricItemSettings().maxCount(1)));
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID, "manastone"), new BlockItem(manastone, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID, "managlass"), new BlockItem(managlass, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID, "sage"), new BlockItem(sage, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID, "lavendar"), new BlockItem(lavendar, new FabricItemSettings()));
        Registry.register(Registries.ITEM, new Identifier(ModConstants.MODID, "yarrow"), new BlockItem(yarrow, new FabricItemSettings()));
        //tools
        Registry.register(Registries.ITEM,new Identifier(ModConstants.MODID, "wand"), wand);

        //GeoItemRenderer
        //GeoItemRenderer.registerItemRenderer(ModItems.wand, new WandRenderer());
    }
}
