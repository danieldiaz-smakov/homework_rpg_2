package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

/**
 * Интерфейс билдера врагов (паттерн Builder).
 * Fluent-интерфейс: каждый сеттер возвращает this для цепочки вызовов.
 * Конкретные билдеры (BasicEnemyBuilder, BossEnemyBuilder) собирают разные типы врагов.
 *
 * Factory Method: метод build() — фабричный метод, создающий продукт (Enemy).
 * Разные билдеры возвращают разные реализации (BasicEnemy, DragonBoss).
 */
public interface EnemyBuilder {

    EnemyBuilder setName(String name);

    EnemyBuilder setHealth(int health);

    EnemyBuilder setDamage(int damage);

    EnemyBuilder setDefense(int defense);

    EnemyBuilder setSpeed(int speed);

    EnemyBuilder setElement(String element);

    EnemyBuilder addAbility(Ability ability);

    EnemyBuilder setAbilities(List<Ability> abilities);

    EnemyBuilder addPhase(int phaseNumber, int healthThreshold);

    EnemyBuilder setLootTable(LootTable lootTable);

    EnemyBuilder setAI(String aiBehavior);

    EnemyBuilder setCanFly(boolean canFly);

    EnemyBuilder setHasBreathAttack(boolean hasBreathAttack);

    EnemyBuilder setWingspan(int wingspan);

    /**
     * Валидирует обязательные поля и создаёт врага.
     * Обязательно: name не null/пустой, health > 0.
     *
     * @return собранный враг (BasicEnemy или DragonBoss)
     * @throws IllegalStateException если валидация не прошла
     */
    Enemy build();
}
