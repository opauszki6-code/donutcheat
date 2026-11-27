package dev.bestclient;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.List;

public final class BestClientScreen extends Screen {
    private static final int PANEL_W = 300;
    private static final int PANEL_H = 270;

    public BestClientScreen() {
        super(Text.literal("Best Client"));
    }

    @Override
    protected void init() {
        clearChildren();
        List<ClientModule> modules = BestClient.MODULES.all();
        int left = (width - PANEL_W) / 2;
        int top = (height - PANEL_H) / 2;
        int y = top + 44;
        for (ClientModule module : modules) {
            if (y > top + PANEL_H - 25) break;
            addDrawableChild(ButtonWidget.builder(
                    Text.literal(module.name() + "  [" + (module.enabled() ? "ON" : "OFF") + "]"),
                    button -> {
                        module.toggle();
                        button.setMessage(Text.literal(module.name() + "  [" + (module.enabled() ? "ON" : "OFF") + "]"));
                    }).dimensions(left + 18, y, PANEL_W - 36, 20).build());
            y += 24;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        int left = (width - PANEL_W) / 2;
        int top = (height - PANEL_H) / 2;
        context.fill(left, top, left + PANEL_W, top + PANEL_H, 0xEE11131A);
        context.fill(left, top, left + PANEL_W, top + 3, 0xFF8A5CFF);
        context.drawCenteredTextWithShadow(textRenderer, "BEST CLIENT", width / 2, top + 13, 0xFFFFFFFF);
        context.drawCenteredTextWithShadow(textRenderer, "Minecraft 1.21.11  |  Right Shift", width / 2, top + 29, 0xFFB8B8C8);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
