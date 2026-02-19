package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Простой враг (минёры, гоблины). Собирается через BasicEnemyBuilder. */
public class BasicEnemy implements Enemy {

    private final String name;
    private final int health;
    private final int damage;
    private final int defense;
    private final int speed;
    private final List<Ability> abilities;
    private final LootTable lootTable;

    public BasicEnemy(String name, int health, int damage, int defense, int speed,
                     List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = abilities == null ? new ArrayList<>() : new ArrayList<>(abilities);
        this.lootTable = lootTable;
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
        return Collections.unmodifiableList(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Basic Enemy) ===");
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

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : abilities) {
            clonedAbilities.add(a.clone());
        }
        LootTable clonedLoot = lootTable != null ? lootTable.clone() : null;
        return new BasicEnemy(name, health, damage, defense, speed, clonedAbilities, clonedLoot);
    }
}
