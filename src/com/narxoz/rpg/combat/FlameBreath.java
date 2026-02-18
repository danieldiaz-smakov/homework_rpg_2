package com.narxoz.rpg.combat;

/** Fire theme: AoE damage + burn. */
public class FlameBreath extends AbstractAbility {

    public FlameBreath() {
        super("Flame Breath", 40, "Deals fire damage in a cone and applies burn", Ability.Type.DAMAGE);
    }

    private FlameBreath(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new FlameBreath(getName(), getDamage(), getDescription(), getType());
    }
}
