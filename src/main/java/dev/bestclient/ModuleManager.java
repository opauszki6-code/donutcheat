package dev.bestclient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModuleManager {
    private final List<ClientModule> modules = new ArrayList<>();

    public void registerDefaults() {
        register("Block ESP", ClientModule.Category.RENDER);
        register("Storage ESP", ClientModule.Category.RENDER);
        register("Fullbright", ClientModule.Category.RENDER);
        register("Freecam", ClientModule.Category.PLAYER);
        register("Sus Chunk Finder", ClientModule.Category.WORLD);
        register("Auto Totem", ClientModule.Category.COMBAT);
        register("Crystal Macro", ClientModule.Category.COMBAT);
        register("Crystal Optimizer", ClientModule.Category.COMBAT);
        register("Anchor Macro", ClientModule.Category.COMBAT);
    }

    public void register(String name, ClientModule.Category category) {
        modules.add(new ClientModule(name, category));
    }

    public List<ClientModule> all() {
        return Collections.unmodifiableList(modules);
    }
}
