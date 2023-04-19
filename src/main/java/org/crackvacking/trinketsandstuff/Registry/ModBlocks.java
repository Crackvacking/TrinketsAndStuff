package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.block.runecrafter;

public class ModBlocks {

    public static final runecrafter runecrafter = new runecrafter(FabricBlockSettings.of(Material.STONE).hardness(0.69f));

    public static void Register() {
        Registry.register(Registry.BLOCK, new Identifier("trinketsandstuff", "runecrafter"), runecrafter);
    }
}