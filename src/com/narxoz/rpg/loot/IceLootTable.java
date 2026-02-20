package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

/** Ice theme loot: Ice Gem, Frost Scale, Ice Rune. */
public class IceLootTable extends LootTable {

    private static final List<String> DEFAULT_ITEMS = Arrays.asList("Ice Gem", "Frost Scale", "Ice Rune");

    public IceLootTable() {
        super(DEFAULT_ITEMS, 120, 180, "Ice");
    }

    public IceLootTable(int goldDrop, int experienceDrop) {
        super(DEFAULT_ITEMS, goldDrop, experienceDrop, "Ice");
    }

    private IceLootTable(IceLootTable other) {
        super(other);
    }

    @Override
    public LootTable clone() {
        return new IceLootTable(this);
    }
}
