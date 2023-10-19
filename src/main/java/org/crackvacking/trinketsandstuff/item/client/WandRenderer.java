package org.crackvacking.trinketsandstuff.item.client;

import org.crackvacking.trinketsandstuff.item.tools.Wand;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WandRenderer extends GeoItemRenderer<Wand> {
    public WandRenderer() {
        super(new WandModel());
    }
}
