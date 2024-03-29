package org.crackvacking.trinketsandstuff.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.crackvacking.trinketsandstuff.item.inventory.ImplementedInventory;
import org.crackvacking.trinketsandstuff.recipe.runecrafterRecipe;
import org.crackvacking.trinketsandstuff.screen.runecrafterScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class runecrafterblockentity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(9, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress=72;

    public runecrafterblockentity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.runecrafter_block_entity, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return runecrafterblockentity.this.progress;
                    case 1:
                        return runecrafterblockentity.this.maxProgress;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        runecrafterblockentity.this.progress = value;
                        break;
                    case 1:
                        runecrafterblockentity.this.maxProgress = value;
                        break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText("gui.trinketsandstuff.runecrafter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new runecrafterScreenHandler(syncId, inv, this,this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("crafting.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("crafting.progress");
    }

    public static void tick(World world, BlockPos pos, BlockState state, runecrafterblockentity entity) {
        if(hasRecipe(entity)) {
                entity.progress++;
                if(entity.progress > entity.maxProgress) {
                    craftItem(entity);
                }

        } else {
            entity.resetProgress();
        }
    }
    private static boolean hasRecipe(runecrafterblockentity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<runecrafterRecipe> match = world.getRecipeManager()
                .getFirstMatch(runecrafterRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(runecrafterblockentity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<runecrafterRecipe> match = world.getRecipeManager()
                .getFirstMatch(runecrafterRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()) {
            entity.removeStack(1,1);
            entity.removeStack(2,1);
            entity.removeStack(3,1);
            entity.removeStack(4,1);
            entity.removeStack(5,1);
            entity.removeStack(6,1);
            entity.removeStack(7,1);
            entity.removeStack(0,1);


            entity.setStack(8, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(8).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output) {
        return inventory.getStack(8).getItem() == output.getItem() || inventory.getStack(8).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(8).getMaxCount() > inventory.getStack(8).getCount();
    }
}
