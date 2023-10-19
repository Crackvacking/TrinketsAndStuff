package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModItemGroup {

    public static void registerItemGroups() {
        ItemGroup TAS = FabricItemGroup.builder(new Identifier("tas", "tas"))
                .displayName(Text.literal("TAS"))
                .icon(() -> new ItemStack(ModItems.igni))
                .entries((displayContext,entries) -> {
                    entries.add(ModItems.igni);
                    entries.add(ModItems.aqua);
                    entries.add(ModItems.caelum);
                    entries.add(ModItems.anima);

                    entries.add(ModItems.mortuus);
                    entries.add(ModItems.perdito);

                    entries.add(ModItems.runedust);
                    entries.add(ModItems.terra);
                    entries.add(ModItems.wand);
                    entries.add(ModBlocks.runecrafter);
                    entries.add(ModBlocks.managlass);
                    entries.add(ModBlocks.manastone);
                    entries.add(ModBlocks.yarrow);
                    entries.add(ModBlocks.sage);
                }).build();
        }
    }
