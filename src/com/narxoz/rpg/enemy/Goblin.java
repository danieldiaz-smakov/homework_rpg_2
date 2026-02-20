package com.narxoz.rpg.enemy;

/** Гоблин — слабый, но быстрый враг. */
public class Goblin extends Enemy {

    public Goblin(String name) {
        super(name, 100, 15, 5, 35);
    }

    @Override
    public Enemy clone() {
        return new Goblin(this);
    }

    private Goblin(Goblin other) {
        super(other);
    }
}
