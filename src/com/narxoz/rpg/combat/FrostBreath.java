package com.narxoz.rpg.combat;

/** Ice theme: damage + slow. */
public class FrostBreath extends AbstractAbility {

    public FrostBreath() {
        super("Frost Breath", 35, "Deals ice damage and slows the target", Ability.Type.DAMAGE);
    }

    private FrostBreath(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new FrostBreath(getName(), getDamage(), getDescription(), getType());
    }
}
