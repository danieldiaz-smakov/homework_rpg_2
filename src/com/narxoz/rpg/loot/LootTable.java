package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Базовый класс для лут-таблиц с deep-copy поддержкой. */
public abstract class LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;
    private final String themeName;

    protected LootTable(List<String> items, int goldDrop, int experienceDrop, String themeName) {
        this.items = new ArrayList<>(items);
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
        this.themeName = themeName;
    }

    /** Copy constructor для clone() — deep copy списка items. */
    protected LootTable(LootTable other) {
        this.items = new ArrayList<>(other.items);
        this.goldDrop = other.goldDrop;
        this.experienceDrop = other.experienceDrop;
        this.themeName = other.themeName;
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public int getExperienceDrop() {
        return experienceDrop;
    }

    public String getLootInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(themeName).append("] Items: ");
        sb.append(String.join(", ", items));
        sb.append(" | Gold: ").append(goldDrop);
        sb.append(" | XP: ").append(experienceDrop);
        return sb.toString();
    }

    protected String getThemeName() {
        return themeName;
    }

    public abstract LootTable clone();
}
