/*
	Copyright (C) 2026 xyomera,
	All rights reserved.
	but based on the Apache 2.0 license.
 */

package com.xyomera.items

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.item.component.Consumable
import net.minecraft.world.item.component.Consumables
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect
import net.minecraft.world.effect.MobEffects

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents

import com.xyomera.register.RegisterItem

object SuperApple {
    // Resource Key
    @JvmStatic
    val SUPER_APPLE_KEY: ResourceKey<Item> = RegisterItem.create("super_apple");

    // Buff
    @JvmStatic
    val SUPER_APPLE_CONSUMABLE: Consumable = Consumables.defaultFood()
        .onConsume(ApplyStatusEffectsConsumeEffect(MobEffectInstance(MobEffects.SPEED, 5 * 60 * 20, 1), 1.0f))
        .onConsume(ApplyStatusEffectsConsumeEffect(MobEffectInstance(MobEffects.STRENGTH, 5 * 60 * 20, 1), 1.0f))
        .onConsume(ApplyStatusEffectsConsumeEffect(MobEffectInstance(MobEffects.REGENERATION, 5 * 60 * 20, 1), 1.0f))
        .onConsume(ApplyStatusEffectsConsumeEffect(MobEffectInstance(MobEffects.RESISTANCE, 5 * 60 * 20, 4), 1.0f))
        .build()

    // Item
    @JvmStatic
    val SUPER_APPLE: Item = RegisterItem.register(SUPER_APPLE_KEY,{ Item(it) },
        Item.Properties().food(
            FoodProperties.Builder()
                .nutrition(10)
                .saturationModifier(20f)
                .alwaysEdible()
                .build(),
            SUPER_APPLE_CONSUMABLE
        ))

    // Initializer
    @JvmStatic
    fun initialize() {
        // Add to the Creative Mode Tabs
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
            .register { creativeTab -> creativeTab.accept(SUPER_APPLE) }
    }
}