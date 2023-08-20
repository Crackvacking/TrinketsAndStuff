package org.crackvacking.trinketsandstuff.block.vegetation;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;

public class Sage extends FlowerBlock {
    public Sage(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings) {
        super(suspiciousStewEffect, effectDuration, settings);
    }
}
