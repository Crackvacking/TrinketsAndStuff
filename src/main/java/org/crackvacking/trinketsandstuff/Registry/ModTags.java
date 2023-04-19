package org.crackvacking.trinketsandstuff.Registry;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static final TagKey<Item> RUNES = Register("runes");
    public static TagKey<Item> Register(String id){
        return TagKey.of(Registry.ITEM_KEY, new Identifier("trinketsandstuff", id));
    }
}
