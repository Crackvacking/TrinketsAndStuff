package org.crackvacking.trinketsandstuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.Registry.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<runecrafterblockentity> runecrafter_block_entity;

    public static void registerAllBlockEntities() {
        runecrafter_block_entity = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier("trinketsandstuff", "runecrafter"),
                FabricBlockEntityTypeBuilder.create(runecrafterblockentity::new,
                        ModBlocks.runecrafter).build(null));
    }
}
