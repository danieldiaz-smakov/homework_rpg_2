package com.narxoz.rpg.enemy;

/** Скелет — средние статы, выше урон чем у гоблина. */
public class Skeleton extends Enemy {

    public Skeleton(String name) {
        super(name, 80, 20, 10, 25);
    }

    @Override
    public Enemy clone() {
        return new Skeleton(this);
    }

    private Skeleton(Skeleton other) {
        super(other);
    }
}
