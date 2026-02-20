package com.narxoz.rpg.combat;

/** Базовый класс для всех способностей. */
public abstract class Ability {

    public enum Type {
        DAMAGE, BUFF, DEBUFF, ULTIMATE
    }

    private final String name;
    private final int damage;
    private final String description;
    private final Type type;

    protected Ability(String name, int damage, String description, Type type) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public abstract Ability clone();
}
