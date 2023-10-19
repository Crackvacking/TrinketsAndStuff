package org.crackvacking.trinketsandstuff.Registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.Registry;
import org.crackvacking.trinketsandstuff.util.ModConstants;

public class ModTags {
    public static final TagKey<Item> RUNES = Register("runes");
    public static TagKey<Item> Register(String id){
        return TagKey.of(Registries.ITEM.getKey(), new Identifier(ModConstants.MODID, id));
    }
}
