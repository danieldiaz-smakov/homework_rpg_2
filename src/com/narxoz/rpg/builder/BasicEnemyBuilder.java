package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BasicEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

/** Билдер простых врагов. */
public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;

    public BasicEnemyBuilder() {
        this.abilities = new ArrayList<>();
    }

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        // для простого врага не храним элемент
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        // у простого врага нет фаз
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        return this;
    }

    @Override
    public EnemyBuilder setCanFly(boolean canFly) {
        return this;
    }

    @Override
    public EnemyBuilder setHasBreathAttack(boolean hasBreathAttack) {
        return this;
    }

    @Override
    public EnemyBuilder setWingspan(int wingspan) {
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Enemy must have a non-empty name");
        }
        if (health <= 0) {
            throw new IllegalStateException("Enemy health must be positive, got: " + health);
        }
        return new BasicEnemy(name, health, damage, defense, speed, abilities, lootTable);
    }
}
