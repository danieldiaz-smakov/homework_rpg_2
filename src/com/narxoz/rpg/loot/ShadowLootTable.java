package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

/** Shadow theme loot: Shadow Gem, Dark Essence, Shadow Rune. */
public class ShadowLootTable extends LootTable {

    private static final List<String> DEFAULT_ITEMS = Arrays.asList("Shadow Gem", "Dark Essence", "Shadow Rune");

    public ShadowLootTable() {
        super(DEFAULT_ITEMS, 180, 220, "Shadow");
    }

    public ShadowLootTable(int goldDrop, int experienceDrop) {
        super(DEFAULT_ITEMS, goldDrop, experienceDrop, "Shadow");
    }

    private ShadowLootTable(ShadowLootTable other) {
        super(other);
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(this);
    }
}
