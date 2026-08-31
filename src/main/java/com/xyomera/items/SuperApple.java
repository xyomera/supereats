/*
	Copyright (C) 2026 xyomera,
	All rights reserved.
	but based on the Apache 2.0 license.
 */

package com.xyomera.items;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import com.xyomera.register.RegisterItem;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class SuperApple {
    private SuperApple() {

    }

    // Resource Key
    public static final ResourceKey<Item> SUPER_APPLE_KEY = RegisterItem.create("super_apple");

    // Buff
    public static final Consumable SUPER_APPLE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 5 * 60 * 20, 1),
                    1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.STRENGTH, 5 * 60 * 20, 1),
                    1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 5 * 60 * 20, 1),
                    1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 5 * 60 * 20, 4),
                    1.0f))
            .build();

    // Item
    public static final Item SUPER_APPLE = RegisterItem.register(SuperApple.SUPER_APPLE_KEY, Item::new, new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(10).saturationModifier(20).alwaysEdible().build(), SUPER_APPLE_CONSUMABLE));

    // Initializer
    public static void initialize() {
        // Add to the Creative Mode Tabs
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((creativeTab) -> creativeTab.accept(SuperApple.SUPER_APPLE));
    }
}
