package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Базовый класс для всех врагов. */
public abstract class Enemy {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities;
    protected LootTable lootTable;

    protected Enemy(String name, int health, int damage, int defense, int speed) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = new ArrayList<>();
    }

    protected Enemy(String name, int health, int damage, int defense, int speed,
                    List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.lootTable = lootTable;
    }

    /** Copy constructor для clone(). */
    protected Enemy(Enemy other) {
        this.name = other.name;
        this.health = other.health;
        this.damage = other.damage;
        this.defense = other.defense;
        this.speed = other.speed;
        this.abilities = new ArrayList<>();
        for (Ability a : other.abilities) {
            this.abilities.add(a.clone());
        }
        this.lootTable = other.lootTable != null ? other.lootTable.clone() : null;
    }

    // --- Getters ---

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public List<Ability> getAbilities() {
        return Collections.unmodifiableList(abilities);
    }

    public LootTable getLootTable() {
        return lootTable;
    }

    // --- Display ---

    public void displayInfo() {
        System.out.println("=== " + name + " ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size());
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " (" + a.getType() + "): " + a.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    // --- Prototype helper methods ---

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void multiplyStats(double multiplier) {
        this.health = (int) (this.health * multiplier);
        this.damage = (int) (this.damage * multiplier);
        this.defense = (int) (this.defense * multiplier);
        this.speed = (int) (this.speed * multiplier);
    }

    public void addAbility(Ability ability) {
        if (ability != null) {
            this.abilities.add(ability);
        }
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities.clear();
        if (abilities != null) {
            this.abilities.addAll(abilities);
        }
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    // --- Clone (Prototype) ---

    public abstract Enemy clone();
}
