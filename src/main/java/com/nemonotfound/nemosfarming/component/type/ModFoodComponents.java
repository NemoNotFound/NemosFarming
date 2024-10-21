package com.nemonotfound.nemosfarming.component.type;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent LETTUCE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();
    public static final FoodComponent CUCUMBER = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f).build();
    public static final FoodComponent MIXED_SALAD = new FoodComponent.Builder().nutrition(7).saturationModifier(0.5f).build();
    public static final FoodComponent MIXED_SALAD_WITH_CARROTS = new FoodComponent.Builder().nutrition(10).saturationModifier(0.6f).build();
    public static final FoodComponent MIXED_SALAD_WITH_BEETROOT = new FoodComponent.Builder().nutrition(8).saturationModifier(0.5f).build();
}
