package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Base implementation of LootTable with shared logic and deep-copy support.
 */
public abstract class AbstractLootTable implements LootTable {

    private final List<String> items;
    private final int goldDrop;
    private final int experienceDrop;
    private final String themeName;

    protected AbstractLootTable(List<String> items, int goldDrop, int experienceDrop, String themeName) {
        this.items = new ArrayList<>(items);
        this.goldDrop = goldDrop;
        this.experienceDrop = experienceDrop;
        this.themeName = themeName;
    }

    /** Copy constructor for clone() — creates deep copy of items list. */
    protected AbstractLootTable(AbstractLootTable other) {
        this.items = new ArrayList<>(other.items);
        this.goldDrop = other.goldDrop;
        this.experienceDrop = other.experienceDrop;
        this.themeName = other.themeName;
    }

    @Override
    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
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
}
