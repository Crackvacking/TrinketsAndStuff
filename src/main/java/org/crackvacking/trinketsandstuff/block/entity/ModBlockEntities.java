package org.crackvacking.trinketsandstuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.crackvacking.trinketsandstuff.Registry.ModBlocks;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModBlockEntities {
    public static BlockEntityType<RunecrafterBlockentity> runecrafter_block_entity;

    public static void registerAllBlockEntities() {
        runecrafter_block_entity = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(ModConstants.MODID, "runecrafter"),
                FabricBlockEntityTypeBuilder.create(RunecrafterBlockentity::new,
                        ModBlocks.runecrafter).build(null));
    }
}
