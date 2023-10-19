package org.crackvacking.trinketsandstuff.item.client;

import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.item.tools.Wand;
import org.crackvacking.trinketsandstuff.util.ModConstants;
import software.bernie.geckolib.model.GeoModel;

public class WandModel extends GeoModel<Wand> {

    @Override
    public Identifier getModelResource(Wand animatable) {
        return new Identifier(ModConstants.MODID, "geo/wand.geo.json");
    }

    @Override
    public Identifier getTextureResource(Wand animatable) {
        return new Identifier(ModConstants.MODID, "textures/item/wand.png");
    }

    @Override
    public Identifier getAnimationResource(Wand animatable) {
        return new Identifier(ModConstants.MODID, "animations/wand.animation.json");
    }
}
