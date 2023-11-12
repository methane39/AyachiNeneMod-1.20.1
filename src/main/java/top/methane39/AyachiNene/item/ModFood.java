package top.methane39.AyachiNene.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties RAMEN = new FoodProperties.Builder().nutrition(6).saturationMod(0.6f).effect(
            () ->new MobEffectInstance(MobEffects.DAMAGE_BOOST,800, 5),1f).effect(
            () ->new MobEffectInstance(MobEffects.CONFUSION,1200), 0.7f).build();
}
