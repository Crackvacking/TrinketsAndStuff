package org.crackvacking.trinketsandstuff.Registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.util.ModConstants;


public class ModItemGroup {
    public static final RegistryKey<ItemGroup> TAS = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(ModConstants.MODID, "tas"));
    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, TAS, FabricItemGroup.builder()
                       .icon(() -> new ItemStack(Items.DIAMOND_PICKAXE))
                       .displayName(Text.translatable("example-mod.group.example"))
                        .entries((displayContext,entries) -> {
                    entries.add(ModItems.igni);
                    entries.add(ModItems.aqua);
                    entries.add(ModItems.caelum);
                    entries.add(ModItems.anima);

                    entries.add(ModItems.mortuus);
                    entries.add(ModItems.perdito);
                    entries.add(ModBlocks.lavendar);
                    entries.add(ModItems.runedust);
                    entries.add(ModItems.terra);
                    entries.add(ModItems.wand);
                    entries.add(ModBlocks.runecrafter);
                    entries.add(ModBlocks.managlass);
                    entries.add(ModBlocks.manastone);
                    entries.add(ModBlocks.yarrow);
                    entries.add(ModBlocks.sage);
                }).build());
        }
    }
