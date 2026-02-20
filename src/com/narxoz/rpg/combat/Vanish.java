package com.narxoz.rpg.combat;

/** Shadow theme: stealth/evasion. */
public class Vanish extends Ability {

    public Vanish() {
        super("Vanish", 0, "Enters stealth, greatly increasing evasion", Ability.Type.DEBUFF);
    }

    private Vanish(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new Vanish(getName(), getDamage(), getDescription(), getType());
    }
}
