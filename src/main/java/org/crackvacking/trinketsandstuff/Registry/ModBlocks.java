package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.block.ManaGlass;
import org.crackvacking.trinketsandstuff.block.Manastone;
import org.crackvacking.trinketsandstuff.block.RunecrafterBlock;
import org.crackvacking.trinketsandstuff.block.vegetation.Lavendar;
import org.crackvacking.trinketsandstuff.block.vegetation.Sage;
import org.crackvacking.trinketsandstuff.block.vegetation.Yarrow;
import org.crackvacking.trinketsandstuff.util.ModConstants;
import org.lwjgl.system.CallbackI;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;
import software.bernie.shadowed.fasterxml.jackson.core.util.DefaultPrettyPrinter;

public class ModBlocks {

    public static final RunecrafterBlock runecrafter = new RunecrafterBlock(FabricBlockSettings.of(Material.STONE).hardness(0.69f));
    public static final Manastone manastone = new Manastone(FabricBlockSettings.of(Material.STONE).strength(2f, 4.2f).luminance(5).requiresTool());
    public static final ManaGlass managlass = new ManaGlass(FabricBlockSettings.of(Material.GLASS).strength(0.3f, 0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque());
    public static final Sage sage = new Sage(StatusEffects.LUCK, 2, FabricBlockSettings.copy(Blocks.DANDELION).breakInstantly().nonOpaque().noCollision());
    public static final Lavendar lavendar = new Lavendar(StatusEffects.HASTE, 5,FabricBlockSettings.copy(Blocks.DANDELION).breakInstantly().nonOpaque().noCollision());
    public static final Yarrow yarrow = new Yarrow(FabricBlockSettings.copy(Blocks.ROSE_BUSH).breakInstantly().nonOpaque().noCollision());

    private static void SetRenderLayers(){
        BlockRenderLayerMap.INSTANCE.putBlock(managlass, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(sage, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(lavendar, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(yarrow, RenderLayer.getCutout());
    }

    public static void Register() {
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "runecrafter"), runecrafter);
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "manastone"), manastone);
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "managlass"), managlass);
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "sage"), sage);
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "lavendar"), lavendar);
        Registry.register(Registry.BLOCK, new Identifier(ModConstants.MODID, "yarrow"), yarrow);
        SetRenderLayers();
    }
}