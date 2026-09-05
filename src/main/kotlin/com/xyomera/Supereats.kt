/*
	Copyright (C) 2026 xyomera,
	All rights reserved.
	but based on the Apache 2.0 license.
 */

package com.xyomera

import net.fabricmc.api.ModInitializer
import net.minecraft.resources.Identifier
import org.slf4j.LoggerFactory

import com.xyomera.items.SuperApple

object Supereats : ModInitializer {
	// Mod ID
	const val MOD_ID: String = "supereats"

	// Logger
	private val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		SuperApple.initialize()
	}

	fun id(path: String): Identifier
		= Identifier.fromNamespaceAndPath(MOD_ID, path)
}
