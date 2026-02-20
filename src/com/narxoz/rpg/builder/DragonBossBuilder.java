package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;

/** Билдер драконов-боссов. */
public class DragonBossBuilder extends EnemyBuilder {

    private String element;
    private Map<Integer, Integer> phases = new HashMap<>();
    private String aiBehavior;
    private boolean canFly = true;
    private boolean hasBreathAttack = true;
    private int wingspan = 20;

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        this.aiBehavior = aiBehavior;
        return this;
    }

    @Override
    public EnemyBuilder setCanFly(boolean canFly) {
        this.canFly = canFly;
        return this;
    }

    @Override
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        this.hasBreathAttack = hasBreathAttack;
        return this;
    }

    @Override
    public EnemyBuilder setWingspan(int wingspan) {
        this.wingspan = wingspan;
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Enemy name required");
        }
        if (health <= 0) {
            throw new IllegalStateException("Health must be positive");
        }
        int p1 = phases.getOrDefault(1, health);
        int p2 = phases.getOrDefault(2, health / 2);
        int p3 = phases.getOrDefault(3, health / 4);
        return new DragonBoss(name, health, damage, defense, speed,
                element != null ? element : "",
                abilities, p1, p2, p3, lootTable,
                aiBehavior != null ? aiBehavior : "AGGRESSIVE",
                canFly, hasBreathAttack, wingspan);
    }
}
