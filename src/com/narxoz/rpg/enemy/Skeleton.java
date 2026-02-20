package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

/** Скелет — базовый враг для Prototype. */
public class Skeleton implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Skeleton(String name) {
        this.name = name;
        this.health = 80;
        this.damage = 20;
        this.defense = 10;
        this.speed = 25;
        this.abilities = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return List.copyOf(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size());
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + ": " + a.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }
    }

    @Override
    public Enemy clone() {
        Skeleton copy = new Skeleton(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }
        copy.lootTable = this.lootTable != null ? this.lootTable.clone() : null;
        return copy;
    }

    // --- Методы для создания вариантов ---

    public void setName(String name) {
        this.name = name;
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
}
