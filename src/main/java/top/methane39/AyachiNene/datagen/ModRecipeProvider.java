package top.methane39.AyachiNene.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.block.ModBlock;
import top.methane39.AyachiNene.item.ModItem;

import java.util.List;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> DETONATOR_SMELTABLES = List.of(ModBlock.DETONATOR_ORE.get());
    private static final List<ItemLike> DETONATOR_SMELT = List.of(ModItem.DETONATOR_COMPONENT.get(),
            ModBlock.DETONATOR_BLOCK.get(),ModBlock.DETONATOR_ORE.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput p_297267_) {
        oreBlasting(p_297267_,DETONATOR_SMELTABLES,RecipeCategory.MISC,ModItem.DETONATOR_COMPONENT.get(),0.25f,100,"detonator_component");
        oreSmelting(p_297267_,DETONATOR_SMELTABLES,RecipeCategory.MISC,ModItem.DETONATOR_COMPONENT.get(),0.25f,100,"detonator_component");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlock.DETONATOR_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S',ModItem.DETONATOR.get())
                .unlockedBy(getHasName(ModItem.DETONATOR.get()),has(ModItem.DETONATOR.get()))
                .save(p_297267_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItem.DETONATOR.get())
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('S',ModItem.DETONATOR_COMPONENT.get())
                .define('A', Items.REDSTONE)
                .unlockedBy(getHasName(ModItem.DETONATOR_COMPONENT.get()),has(ModItem.DETONATOR_COMPONENT.get()))
                .save(p_297267_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItem.DETONATOR.get(),9)
                .requires(ModBlock.DETONATOR_BLOCK.get())
                .unlockedBy(getHasName(ModBlock.DETONATOR_BLOCK.get()),has(ModBlock.DETONATOR_BLOCK.get()))
                .save(p_297267_,"detonator_from_detonator_block");
    }

    protected static void oreSmelting(RecipeOutput p_300202_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(p_300202_, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput p_298528_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(p_298528_, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput p_297621_, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).
                    group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(p_297621_, AyachiNene.MODID +":"+getItemName(pResult)+pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
