package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

/** Скелет — средние статы, выше урон чем у гоблина. */
public class Skeleton extends Enemy {

    // Дефолтные статы скелета
    public static final int DEFAULT_HEALTH = 80;
    public static final int DEFAULT_DAMAGE = 20;
    public static final int DEFAULT_DEFENSE = 10;
    public static final int DEFAULT_SPEED = 25;

    public Skeleton(String name) {
        super(name, DEFAULT_HEALTH, DEFAULT_DAMAGE, DEFAULT_DEFENSE, DEFAULT_SPEED);
    }

    public Skeleton(String name, int health, int damage, int defense, int speed,
                    List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, abilities, lootTable);
    }

    private Skeleton(Skeleton other) {
        super(other);
    }

    @Override
    public Enemy clone() {
        return new Skeleton(this);
    }
}
