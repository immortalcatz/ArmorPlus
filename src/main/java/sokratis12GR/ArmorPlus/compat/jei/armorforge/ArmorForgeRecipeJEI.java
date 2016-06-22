package sokratis12GR.ArmorPlus.compat.jei.armorforge;

/**
 * sokratis12GR.ArmorPlus.compat.jei.armorforge
 * ArmorPlus created by sokratis12GR on 6/21/2016 11:39 PM.
 */

import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;
import sokratis12GR.ArmorPlus.api.recipe.ArmorForgeRecipe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArmorForgeRecipeJEI extends BlankRecipeWrapper {

    private ArmorForgeRecipe recipe;

    public ArmorForgeRecipeJEI(ArmorForgeRecipe recipe)
    {
        this.recipe = recipe;
    }

    @Override
    @Nonnull
    public List<Collection> getInputs()
    {
        ArrayList<Collection> ret = new ArrayList<Collection>();
        ret.add(recipe.getInput());
        return ret;
    }

    @Override
    @Nonnull
    public List<ItemStack> getOutputs()
    {
        return Collections.singletonList(recipe.getRecipeOutput(new ArrayList<ItemStack>()));
    }

    @Nullable
    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY)
    {
        return null;
    }
}