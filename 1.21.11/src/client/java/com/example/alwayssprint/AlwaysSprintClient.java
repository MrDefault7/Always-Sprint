package com.example.alwayssprint;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

/**
 * Always Sprint
 * Author: PavitraXD
 *
 * Forces the local player to sprint automatically whenever they are moving
 * forward - no sprint keybind, no toggle option, and no holding Ctrl needed.
 */
public class AlwaysSprintClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
	}

	private void onTick(MinecraftClient client) {
		ClientPlayerEntity player = client.player;
		if (player == null) {
			return;
		}

		if (player.isSneaking() || player.isUsingItem()) {
			return;
		}

		if (!player.isSprinting() && player.input.hasForwardMovement()) {
			player.setSprinting(true);
		}
	}
}
