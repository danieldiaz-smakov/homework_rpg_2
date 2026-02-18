package com.narxoz.rpg.combat;

/**
 * Base class for abilities with common fields and clone support.
 * Concrete abilities extend this and implement clone() for Prototype pattern.
 */
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
