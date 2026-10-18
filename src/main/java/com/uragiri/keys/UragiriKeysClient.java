package com.uragiri.keys;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

/** 裏切りスキルごとのキー割り当てを追加し、押すと /trigger sk_xxx を送るクライアント専用MOD。 */
public class UragiriKeysClient implements ClientModInitializer {
    // データパック側の trigger 目的名 sk_<id> と対応
    private static final String[] IDS = {
        "hunger", "zombie", "randomtp", "invisibility",
        "pig", "tnt", "deathsentence", "baggage"
    };
    private static final String CATEGORY = "category.uragiri_keys";

    private final KeyMapping[] keys = new KeyMapping[IDS.length];

    @Override
    public void onInitializeClient() {
        for (int i = 0; i < IDS.length; i++) {
            keys[i] = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.uragiri_keys." + IDS[i], InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, CATEGORY));
        }
        ClientTickEvents.END_CLIENT_TICK.register(mc -> {
            for (int i = 0; i < IDS.length; i++) {
                while (keys[i].consumeClick()) {
                    if (mc.player != null && mc.screen == null) {
                        mc.player.connection.sendCommand("trigger sk_" + IDS[i]);
                    }
                }
            }
        });
    }
}
