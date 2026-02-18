package com.narxoz.rpg.combat;

/** Ice theme: defensive buff. */
public class IceShield extends AbstractAbility {

    public IceShield() {
        super("Ice Shield", 0, "Creates a barrier that absorbs damage and can freeze attackers", Ability.Type.BUFF);
    }

    private IceShield(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new IceShield(getName(), getDamage(), getDescription(), getType());
    }
}
