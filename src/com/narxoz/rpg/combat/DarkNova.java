package com.narxoz.rpg.combat;

/** Shadow theme: ultimate, AoE damage. */
public class DarkNova extends AbstractAbility {

    public DarkNova() {
        super("Dark Nova", 110, "Releases dark energy in all directions", Ability.Type.ULTIMATE);
    }

    private DarkNova(String name, int damage, String description, Ability.Type type) {
        super(name, damage, description, type);
    }

    @Override
    public Ability clone() {
        return new DarkNova(getName(), getDamage(), getDescription(), getType());
    }
}
