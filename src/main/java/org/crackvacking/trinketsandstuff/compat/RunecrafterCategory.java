package org.crackvacking.trinketsandstuff.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.crackvacking.trinketsandstuff.Registry.ModBlocks;
import org.crackvacking.trinketsandstuff.screen.slot.ModResultSlot;
import org.crackvacking.trinketsandstuff.util.ModConstants;

import java.util.LinkedList;
import java.util.List;

public class RunecrafterCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE =
            new Identifier(ModConstants.MODID, "textures/gui/runecrafter.png");
    public static final CategoryIdentifier<RuneCrafterDisplay> runecrafter =
            CategoryIdentifier.of(ModConstants.MODID, "runecrafter");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return runecrafter;
    }

    @Override
    public Text getTitle() {
        return Text.literal("RuneCrafter");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.runecrafter.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 70);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 6))
                .entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 103, startPoint.y + 12))
                .entries(display.getInputEntries().get(1)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 109, startPoint.y + 35))
                .entries(display.getInputEntries().get(2)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 103, startPoint.y + 58))
                .entries(display.getInputEntries().get(3)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 64))
                .entries(display.getInputEntries().get(4)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 57, startPoint.y + 58))
                .entries(display.getInputEntries().get(5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 52, startPoint.y + 35))
                .entries(display.getInputEntries().get(6)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 57, startPoint.y + 12))
                .entries(display.getInputEntries().get(7)));


        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 35))
                .markOutput().entries(display.getOutputEntries().get(0)));


        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}