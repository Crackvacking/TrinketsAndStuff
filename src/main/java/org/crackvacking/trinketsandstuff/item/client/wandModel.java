package org.crackvacking.trinketsandstuff.item.client;

import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.item.tools.wand;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class wandModel extends AnimatedGeoModel<wand> {
    @Override
    public Identifier getModelLocation(wand object) {
        return new Identifier("trinketsandstuff", "geo/wand.geo.json");
    }

    @Override
    public Identifier getTextureLocation(wand object) {
        return new Identifier("trinketsandstuff", "textures/item/wand.png");
    }

    @Override
    public Identifier getAnimationFileLocation(wand animatable) {
        return new Identifier("trinketsandstuff", "animations/wand.animation.json");
    }
}
