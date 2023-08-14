package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.item.client.WandRenderer;
import org.crackvacking.trinketsandstuff.item.runes.*;
import org.crackvacking.trinketsandstuff.item.tools.Wand;
import org.crackvacking.trinketsandstuff.util.ModConstants;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import static org.crackvacking.trinketsandstuff.Registry.ModBlocks.*;


public class ModItems {
    private static final ItemGroup TAS = FabricItemGroupBuilder.create(new Identifier(ModConstants.MODID, "tas"))
            .icon(() -> new ItemStack(ModItems.aqua)).build();
    public static final Aqua aqua = new Aqua(new FabricItemSettings().group(TAS).maxCount(16));
    public static final Igni igni = new Igni(new FabricItemSettings().group(TAS).maxCount(16));
    public static final Terra terra = new Terra(new FabricItemSettings().group(TAS).maxCount(16));
    public static final Anima anima = new Anima(new FabricItemSettings().group(TAS).maxCount(16));
    public static final Caelum caelum = new Caelum(new FabricItemSettings().group(TAS).maxCount(16));
    public static final Mortuus mortuus = new Mortuus(new FabricItemSettings().group(TAS).maxCount(16));
    public static final Perdito perdito = new Perdito(new FabricItemSettings().group(TAS).maxCount(16));
    public static final RuneDust runedust = new RuneDust(new FabricItemSettings().group(TAS));

    public static final Wand wand = new Wand(new FabricItemSettings().group(TAS).maxCount(1));

    public static void Register(){
        //crafting items
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"aqua"), aqua);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"igni"), igni);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"terra"), terra);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"anima"), anima);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"caelum"), caelum);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"mortuus"), mortuus);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"perdito"), perdito);
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID,"runedust"), runedust);

        //block items
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID, "runecrafter"), new BlockItem(runecrafter, new FabricItemSettings().group(TAS).maxCount(1)));
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID, "manastone"), new BlockItem(manastone, new FabricItemSettings().group(TAS)));
        Registry.register(Registry.ITEM, new Identifier(ModConstants.MODID, "managlass"), new BlockItem(managlass, new FabricItemSettings().group(TAS)));

        //tools
        Registry.register(Registry.ITEM,new Identifier(ModConstants.MODID, "wand"), wand);

        //GeoItemRenderer
        GeoItemRenderer.registerItemRenderer(ModItems.wand, new WandRenderer());
    }
}
