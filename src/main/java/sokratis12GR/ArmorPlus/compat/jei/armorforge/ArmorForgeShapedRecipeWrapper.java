package sokratis12GR.ArmorPlus.compat.jei.armorforge;

import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import mezz.jei.plugins.vanilla.VanillaRecipeWrapper;
import net.minecraft.item.ItemStack;
import sokratis12GR.ArmorPlus.api.crafting.ShapedRecipes;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * sokratis12GR.ArmorPlus.compat.jei.armorforge
 * ArmorPlus created by sokratis12GR on 6/22/2016 6:16 PM.
 */
public class ArmorForgeShapedRecipeWrapper extends VanillaRecipeWrapper implements IShapedCraftingRecipeWrapper {

    @Nonnull
    private final ShapedRecipes recipe;

    public ArmorForgeShapedRecipeWrapper(@Nonnull ShapedRecipes recipe) {
        this.recipe = recipe;
        for (ItemStack itemStack : this.recipe.recipeItems) {
            if (itemStack != null && itemStack.stackSize != 1) {
                itemStack.stackSize = 1;
            }
        }
    }

    @Nonnull
    @Override
    public List getInputs() {
        return Arrays.asList(recipe.recipeItems);
    }

    @Nonnull
    @Override
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(recipe.getRecipeOutput());
    }

    @Override
    public int getWidth() {
        return recipe.recipeWidth;
    }

    @Override
    public int getHeight() {
        return recipe.recipeHeight;
    }
}