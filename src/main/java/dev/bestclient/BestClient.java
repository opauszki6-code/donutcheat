package dev.bestclient;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class BestClient implements ClientModInitializer {
    public static final ModuleManager MODULES = new ModuleManager();
    private static KeyBinding openMenu;

    @Override
    public void onInitializeClient() {
        MODULES.registerDefaults();
        openMenu = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.bestclient.open_menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KeyBinding.Category.create(net.minecraft.util.Identifier.of("bestclient", "main"))
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openMenu.wasPressed()) {
                MinecraftClient.getInstance().setScreen(new BestClientScreen());
            }
        });
    }
}
