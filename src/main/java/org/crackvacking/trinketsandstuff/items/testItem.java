package org.crackvacking.trinketsandstuff.items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class testItem extends Item {
    public testItem(Settings settings){
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack){
        return true;
    }
}
