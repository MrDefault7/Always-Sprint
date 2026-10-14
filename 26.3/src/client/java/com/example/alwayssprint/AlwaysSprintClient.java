package com.example.alwayssprint;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.player.LocalPlayer;

/**
 * Always Sprint
 * Author: PavitraXD
 *
 * Forces the local player to sprint automatically whenever they are moving
 * forward - no sprint keybind, no toggle option, and no holding Ctrl needed.
 *
 * How it works:
 * Every client tick (20x/second) we check the player's current input state.
 * If they are pressing forward, aren't sneaking, and aren't using an item
 * (eating/blocking/drawing a bow), we flip their sprinting flag on. This
 * mirrors exactly what vanilla does when you hold the sprint key yourself,
 * so the server sees a completely normal sprint state and packet - nothing
 * is spoofed or forced past the game's own rules, which keeps it safe on
 * anti-cheat protected servers.
 */
public class AlwaysSprintClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
	}

	private void onTick(net.minecraft.client.Minecraft client) {
		LocalPlayer player = client.player;
		if (player == null) {
			return;
		}

		// Don't fight the player: sneaking and sprinting are mutually
		// exclusive in vanilla, and forcing sprint while using an item
		// (eating, blocking, drawing a bow) causes visual glitches.
		if (player.isShiftKeyDown() || player.isUsingItem()) {
			return;
		}

		if (!player.isSprinting() && player.input.hasForwardImpulse()) {
			player.setSprinting(true);
		}
	}
}
