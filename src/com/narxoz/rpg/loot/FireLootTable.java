package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

/** Fire theme loot: Fire Gem, Dragon Scale, Flame Rune. */
public class FireLootTable extends AbstractLootTable {

    private static final List<String> DEFAULT_ITEMS = Arrays.asList("Fire Gem", "Dragon Scale", "Flame Rune");

    public FireLootTable() {
        super(DEFAULT_ITEMS, 150, 200, "Fire");
    }

    public FireLootTable(int goldDrop, int experienceDrop) {
        super(DEFAULT_ITEMS, goldDrop, experienceDrop, "Fire");
    }

    private FireLootTable(FireLootTable other) {
        super(other);
    }

    @Override
    public LootTable clone() {
        return new FireLootTable(this);
    }
}
