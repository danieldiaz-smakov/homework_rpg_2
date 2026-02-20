package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

/** Базовый билдер врагов. */
public abstract class EnemyBuilder {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;

    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
        return this;
    }

    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        return this;
    }

    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    // Boss-методы — дефолт "ничего не делать"
    public EnemyBuilder setElement(String element) { return this; }
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) { return this; }
    public EnemyBuilder setAI(String aiBehavior) { return this; }
    public EnemyBuilder setCanFly(boolean canFly) { return this; }
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { return this; }
    public EnemyBuilder setWingspan(int wingspan) { return this; }

    public abstract Enemy build();
}
