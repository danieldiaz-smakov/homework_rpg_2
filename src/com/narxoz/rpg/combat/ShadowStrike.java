package com.narxoz.rpg.combat;

/** Shadow theme: high single-target damage + blind. */
public class ShadowStrike extends AbstractAbility {

    public ShadowStrike() {
        super("Shadow Strike", 55, "Deals heavy shadow damage and may blind the target", Ability.Type.DAMAGE);
    }

    private ShadowStrike(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new ShadowStrike(getName(), getDamage(), getDescription(), getType());
    }
}
