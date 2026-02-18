package com.narxoz.rpg.combat;

/** Fire theme: defensive buff. */
public class FireShield extends AbstractAbility {

    public FireShield() {
        super("Fire Shield", 0, "Raises fire resistance and reflects part of melee damage", Ability.Type.BUFF);
    }

    private FireShield(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new FireShield(getName(), getDamage(), getDescription(), getType());
    }
}
