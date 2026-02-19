package com.narxoz.rpg.combat;

/** Базовая реализация способности с общими полями. */
public abstract class AbstractAbility implements Ability {

    private final String name;
    private final int damage;
    private final String description;
    private final Ability.Type type;

    protected AbstractAbility(String name, int damage, String description, Ability.Type type) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Ability.Type getType() {
        return type;
    }
}
