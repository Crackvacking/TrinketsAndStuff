package org.crackvacking.trinketsandstuff.item.client;

import org.crackvacking.trinketsandstuff.item.tools.Wand;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public class WandRenderer extends GeoItemRenderer<Wand> {
    public WandRenderer() {
        super(new WandModel());
    }
}
