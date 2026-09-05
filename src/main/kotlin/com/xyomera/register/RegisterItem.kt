/*
	Copyright (C) 2026 xyomera,
	All rights reserved.
	but based on the Apache 2.0 license.
 */

package com.xyomera.register

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item

object RegisterItem {
    // Create Resource Key
    @JvmStatic
    fun create(name: String) : ResourceKey<Item> {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("supereats", name))
    }

    // Register Item
    @JvmStatic
    fun register(itemKey: ResourceKey<Item>, itemFactory: (Item.Properties) -> Item, settings: Item.Properties) : Item {
        val props: Item.Properties = settings.setId(itemKey)
        val item: Item = itemFactory(props)
        Registry.register(BuiltInRegistries.ITEM, itemKey, item)
        return item
    }
}