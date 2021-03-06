package sokratis12GR.ArmorPlus.api.recipe;

/**
 * sokratis12GR.ArmorPlus.api.recipe
 * ArmorPlus created by sokratis12GR on 6/22/2016 5:26 PM.
 */

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArmorForgeRecipe {
    protected ItemStack output = null;
    protected ArrayList<Object> input = new ArrayList<Object>();

    public ArmorForgeRecipe(Block result, Object... recipe) {
        this(new ItemStack(result), recipe);
    }

    public ArmorForgeRecipe(Item result, Object... recipe) {
        this(new ItemStack(result), recipe);
    }

    public ArmorForgeRecipe(ItemStack result, Object... recipe) {
        output = result.copy();
        for (Object in : recipe) {
            if (in instanceof ItemStack) {
                input.add(((ItemStack) in).copy());
            } else if (in instanceof Item) {
                input.add(new ItemStack((Item) in));
            } else if (in instanceof Block) {
                input.add(new ItemStack((Block) in));
            } else if (in instanceof String) {
                input.add(OreDictionary.getOres((String) in));
            } else {
                String ret = "Invalid Armor Forge recipe: ";
                for (Object tmp : recipe) {
                    ret += tmp + ", ";
                }
                ret += output;
                throw new RuntimeException(ret);
            }
        }
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize() {
        return input.size();
    }

    /**
     * Returns the output of the recipe, sensitive to the input list provided.
     * If the input list does not technically match, the recipe should return
     * the default output.
     *
     * @param inputList
     * @return
     */
    public ItemStack getRecipeOutput(List<ItemStack> inputList) {
        return output.copy();
    }

    /**
     * Used to check if a recipe matches current crafting inventory. World and
     * BlockPos are for future-proofing
     */
    @SuppressWarnings("unchecked")
    public boolean matches(List<ItemStack> checkedList, World world, BlockPos pos) {
        ArrayList<Object> required = new ArrayList<Object>(input);

        for (int x = 0; x < checkedList.size(); x++) {
            ItemStack slot = checkedList.get(x);

            if (slot != null) {
                boolean inRecipe = false;
                Iterator<Object> req = required.iterator();

                while (req.hasNext()) {
                    boolean match = false;

                    Object next = req.next();

                    if (next instanceof ItemStack) {
                        match = OreDictionary.itemMatches((ItemStack) next, slot, false);
                    } else if (next instanceof List) {
                        Iterator<ItemStack> itr = ((List<ItemStack>) next).iterator();
                        while (itr.hasNext() && !match) {
                            match = OreDictionary.itemMatches(itr.next(), slot, false);
                        }
                    }

                    if (match) {
                        inRecipe = true;
                        required.remove(next);
                        break;
                    }
                }

                if (!inRecipe) {
                    return false;
                }
            }
        }

        return required.isEmpty();
    }

    /**
     * Returns the input for this recipe, any mod accessing this value should
     * never manipulate the values in this array as it will effect the recipe
     * itself.
     *
     * @return The recipes input vales.
     */
    public ArrayList<Object> getInput() {
        return this.input;
    }

    public ItemStack[] getRemainingItems(ItemStack[] inventory) {
        ItemStack[] ret = inventory.clone();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = getContainerItem(inventory[i]);
        }

        return ret;
    }

    protected ItemStack getContainerItem(ItemStack stack) {
        if (stack == null) {
            return null;
        }

        ItemStack copyStack = stack.copy();

        if (copyStack.getItem().hasContainerItem(stack)) {
            return copyStack.getItem().getContainerItem(copyStack);
        }

        copyStack.stackSize--;
        if (copyStack.stackSize <= 0) {
            return null;
        }

        return copyStack;
    }
}