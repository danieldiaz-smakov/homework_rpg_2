package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

import java.util.function.Supplier;

/** Director с пресетами врагов. Использует Builder для сборки. */
public class EnemyDirector {

    private final Supplier<EnemyBuilder> builderSupplier;

    public EnemyDirector(Supplier<EnemyBuilder> builderSupplier) {
        this.builderSupplier = builderSupplier;
    }

    /** Слабый минён. */
    public Enemy createMinion(EnemyComponentFactory factory) {
        return builderSupplier.get()
                .setName("Minion")
                .setHealth(50)
                .setDamage(10)
                .setDefense(3)
                .setSpeed(20)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    /** Элитный враг — средняя сложность. */
    public Enemy createElite(EnemyComponentFactory factory) {
        return builderSupplier.get()
                .setName("Elite")
                .setHealth(500)
                .setDamage(50)
                .setDefense(20)
                .setSpeed(30)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    /** Мини-босс. */
    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builderSupplier.get()
                .setName("Mini Boss")
                .setHealth(5000)
                .setDamage(150)
                .setDefense(80)
                .setSpeed(35)
                .setElement(factory.createAIBehavior().equals("AGGRESSIVE") ? "FIRE" : "SHADOW")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 5000)
                .addPhase(2, 2500)
                .build();
    }

    /** Рейд-босс — максимальная сложность. */
    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builderSupplier.get()
                .setName("Raid Boss")
                .setHealth(100000)
                .setDamage(1000)
                .setDefense(300)
                .setSpeed(40)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 100000)
                .addPhase(2, 50000)
                .addPhase(3, 25000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(30)
                .build();
    }
}
