package org.crackvacking.trinketsandstuff.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.Registry.ModBlocks;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModBlockEntities {
    public static BlockEntityType<RunecrafterBlockentity> runecrafter_block_entity;

    public static void registerAllBlockEntities() {
        runecrafter_block_entity = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(ModConstants.MODID, "runecrafter"),
                FabricBlockEntityTypeBuilder.create(RunecrafterBlockentity::new,
                        ModBlocks.runecrafter).build(null));
    }
}
