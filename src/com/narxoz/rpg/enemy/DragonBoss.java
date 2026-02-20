package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Босс-дракон с фазами, элементом и специальными свойствами. */
public class DragonBoss extends Enemy {

    private String element;
    private Map<Integer, Integer> phases;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities,
                      int phase1, int phase2, int phase3,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {
        super(name, health, damage, defense, speed, abilities, lootTable);
        this.element = element;
        this.phases = new HashMap<>();
        this.phases.put(1, phase1);
        this.phases.put(2, phase2);
        this.phases.put(3, phase3);
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    private DragonBoss(DragonBoss other) {
        super(other);
        this.element = other.element;
        this.phases = new HashMap<>(other.phases);
        this.aiBehavior = other.aiBehavior;
        this.canFly = other.canFly;
        this.hasBreathAttack = other.hasBreathAttack;
        this.wingspan = other.wingspan;
    }

    @Override
    public Enemy clone() {
        return new DragonBoss(this);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + getName() + " (Dragon Boss) ===");
        System.out.println("Health: " + getHealth() + " | Damage: " + getDamage()
                + " | Defense: " + getDefense() + " | Speed: " + getSpeed());
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + getAbilities().size() + "):");
        for (Ability a : getAbilities()) {
            System.out.println("  - " + a.getName() + " (" + a.getType() + "): " + a.getDescription());
        }
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly + " | Breath Attack: " + hasBreathAttack + " | Wingspan: " + wingspan);
        if (getLootTable() != null) {
            System.out.println("Loot: " + getLootTable().getLootInfo());
        }
    }

    @Override
    public void multiplyStats(double multiplier) {
        super.multiplyStats(multiplier);
        for (Integer phase : phases.keySet()) {
            phases.put(phase, (int) (phases.get(phase) * multiplier));
        }
    }

    // --- Boss-specific setters for Prototype ---

    public void setElement(String element) {
        this.element = element;
    }

    public void setAiBehavior(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }

    // --- Boss-specific getters ---

    public String getElement() {
        return element;
    }

    public Map<Integer, Integer> getPhases() {
        return new HashMap<>(phases);
    }

    public String getAiBehavior() {
        return aiBehavior;
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean hasBreathAttack() {
        return hasBreathAttack;
    }

    public int getWingspan() {
        return wingspan;
    }
}
