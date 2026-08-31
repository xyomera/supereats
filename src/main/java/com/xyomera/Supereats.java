/*
	Copyright (C) 2026 xyomera,
	All rights reserved.
	but based on the Apache 2.0 license.
 */

package com.xyomera;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyomera.items.SuperApple;

public class Supereats implements ModInitializer {
	// Mod ID
	public static final String MOD_ID = "supereats";

	// Logger
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SuperApple.initialize();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
