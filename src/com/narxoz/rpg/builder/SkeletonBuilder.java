package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Skeleton;

/** Билдер скелетов. */
public class SkeletonBuilder extends EnemyBuilder {

    public SkeletonBuilder() {
        this.health = Skeleton.DEFAULT_HEALTH;
        this.damage = Skeleton.DEFAULT_DAMAGE;
        this.defense = Skeleton.DEFAULT_DEFENSE;
        this.speed = Skeleton.DEFAULT_SPEED;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Enemy name required");
        }
        return new Skeleton(name, health, damage, defense, speed, abilities, lootTable);
    }
}
