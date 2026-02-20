package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

/** Гоблин — слабый, но быстрый враг. */
public class Goblin extends Enemy {

    // Дефолтные статы гоблина
    public static final int DEFAULT_HEALTH = 100;
    public static final int DEFAULT_DAMAGE = 15;
    public static final int DEFAULT_DEFENSE = 5;
    public static final int DEFAULT_SPEED = 35;

    public Goblin(String name) {
        super(name, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_DEFENSE, DEFAULT_SPEED);
    }

    public Goblin(String name, int health, int damage, int defense, int speed,
                  List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, abilities, lootTable);
    }

    private Goblin(Goblin other) {
        super(other);
    }

    @Override
    public Enemy clone() {
        return new Goblin(this);
    }
}
