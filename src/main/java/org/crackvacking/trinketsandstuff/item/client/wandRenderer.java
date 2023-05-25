package org.crackvacking.trinketsandstuff.item.client;

import org.crackvacking.trinketsandstuff.item.tools.wand;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class wandRenderer extends GeoItemRenderer<wand> {
    public wandRenderer() {
        super(new wandModel());
    }
}
