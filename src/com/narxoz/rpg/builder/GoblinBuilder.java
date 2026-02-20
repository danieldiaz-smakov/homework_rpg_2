package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;

/** Билдер гоблинов. */
public class GoblinBuilder extends EnemyBuilder {

    public GoblinBuilder() {
        this.health = Goblin.DEFAULT_HEALTH;
        this.damage = Goblin.DEFAULT_DAMAGE;
        this.defense = Goblin.DEFAULT_DEFENSE;
        this.speed = Goblin.DEFAULT_SPEED;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Enemy name required");
        }
        return new Goblin(name, health, damage, defense, speed, abilities, lootTable);
    }
}
