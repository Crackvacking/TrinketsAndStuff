package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.block.ManaGlass;
import org.crackvacking.trinketsandstuff.block.Manastone;
import org.crackvacking.trinketsandstuff.block.RunecrafterBlock;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModBlocks {

    public static final RunecrafterBlock runecrafter = new RunecrafterBlock(FabricBlockSettings.of(Material.STONE).hardness(0.69f));
    public static final Manastone manastone = new Manastone(FabricBlockSettings.of(Material.STONE).strength(2f, 4.2f).luminance(5).requiresTool());
    public static final ManaGlass managlass = new ManaGlass(FabricBlockSettings.of(Material.GLASS).strength(0.3f, 0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque());


    public static void Register() {
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "runecrafter"), runecrafter);
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "manastone"), manastone);
        BlockRenderLayerMap.INSTANCE.putBlock(managlass, RenderLayer.getTranslucent());
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "managlass"), managlass);
    }
}