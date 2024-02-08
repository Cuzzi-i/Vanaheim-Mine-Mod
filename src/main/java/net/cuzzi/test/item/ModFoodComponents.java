package net.cuzzi.test.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent HAMBUR = new FoodComponent.Builder().hunger(12).saturationModifier(0.5f).build();

}