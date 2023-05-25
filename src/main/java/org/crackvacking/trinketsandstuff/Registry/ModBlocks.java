package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.block.mana_glass;
import org.crackvacking.trinketsandstuff.block.manastone;
import org.crackvacking.trinketsandstuff.block.runecrafterblock;

public class ModBlocks {

    public static final runecrafterblock runecrafter = new runecrafterblock(FabricBlockSettings.of(Material.STONE).hardness(0.69f));
    public static final manastone manastone = new manastone(FabricBlockSettings.of(Material.STONE).strength(2f, 4.2f).luminance(5).requiresTool());
    public static final mana_glass managlass = new mana_glass(FabricBlockSettings.of(Material.GLASS).strength(0.3f, 0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque());


    public static void Register() {
        Registry.register(Registry.BLOCK, new Identifier("trinketsandstuff", "runecrafter"), runecrafter);
        Registry.register(Registry.BLOCK, new Identifier("trinketsandstuff", "manastone"), manastone);
        BlockRenderLayerMap.INSTANCE.putBlock(managlass, RenderLayer.getTranslucent());
        Registry.register(Registry.BLOCK, new Identifier("trinketsandstuff", "managlass"), managlass);
    }
}