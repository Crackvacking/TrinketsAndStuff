package org.crackvacking.trinketsandstuff.item.client;

import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.item.tools.Wand;
import org.crackvacking.trinketsandstuff.util.ModConstants;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WandModel extends AnimatedGeoModel<Wand> {
    @Override
    public Identifier getModelLocation(Wand object) {
        return new Identifier(ModConstants.MODID, "geo/wand.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Wand object) {
        return new Identifier(ModConstants.MODID, "textures/item/wand.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Wand animatable) {
        return new Identifier(ModConstants.MODID, "animations/wand.animation.json");
    }
}
