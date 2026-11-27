package dev.bestclient;

public final class ClientModule {
    private final String name;
    private final Category category;
    private boolean enabled;

    public ClientModule(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String name() { return name; }
    public Category category() { return category; }
    public boolean enabled() { return enabled; }
    public void toggle() { enabled = !enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public enum Category { RENDER, COMBAT, PLAYER, WORLD, MISC }
}
