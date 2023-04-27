package org.crackvacking.trinketsandstuff.item.runes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class anima extends Item {

    public anima(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {

        playerEntity.playSound(SoundEvents.ENTITY_ENDER_EYE_DEATH,1F,1F);

        if(!playerEntity.isCreative())
            playerEntity.getStackInHand(hand).decrement(1);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
