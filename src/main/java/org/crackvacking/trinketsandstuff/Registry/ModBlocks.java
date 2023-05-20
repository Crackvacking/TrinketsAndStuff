package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.block.manastone;
import org.crackvacking.trinketsandstuff.block.runecrafterblock;

public class ModBlocks {

    public static final runecrafterblock runecrafter = new runecrafterblock(FabricBlockSettings.of(Material.STONE).hardness(0.69f));
    public static final manastone manastone = new manastone(FabricBlockSettings.of(Material.STONE).strength(0.75f, 4.2f).luminance(5).requiresTool());


    public static void Register() {
        Registry.register(Registry.BLOCK, new Identifier("trinketsandstuff", "runecrafter"), runecrafter);
        Registry.register(Registry.BLOCK, new Identifier("trinketsandstuff", "manastone"), manastone);
    }
}