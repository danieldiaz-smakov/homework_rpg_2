package com.narxoz.rpg.combat;

/** Ice theme: ultimate, AoE damage. */
public class Blizzard extends Ability {

    public Blizzard() {
        super("Blizzard", 100, "Summons a blizzard that damages and slows all in area", Ability.Type.ULTIMATE);
    }

    private Blizzard(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new Blizzard(getName(), getDamage(), getDescription(), getType());
    }
}
