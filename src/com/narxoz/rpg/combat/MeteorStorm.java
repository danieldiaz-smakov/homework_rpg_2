package com.narxoz.rpg.combat;

/** Fire theme: ultimate, high AoE damage. */
public class MeteorStorm extends AbstractAbility {

    public MeteorStorm() {
        super("Meteor Storm", 120, "Calls down meteors in a large area", Ability.Type.ULTIMATE);
    }

    private MeteorStorm(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new MeteorStorm(getName(), getDamage(), getDescription(), getType());
    }
}
