package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FrostBreath;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.enemy.Skeleton;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

/**
 * Демонстрация всех четырёх порождающих паттернов:
 * Abstract Factory, Builder, Factory Method, Prototype.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        // ============================================================
        // PART 1: ABSTRACT FACTORY
        // ============================================================
        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        System.out.println("Fire Factory:");
        printFactoryComponents(fireFactory);

        System.out.println("Ice Factory:");
        printFactoryComponents(iceFactory);

        System.out.println("Shadow Factory:");
        printFactoryComponents(shadowFactory);

        System.out.println(">>> Abstract Factory гарантирует: одна фабрика = одна тема.");
        System.out.println(">>> Fire-фабрика не может выдать Ice-лут.\n");

        // ============================================================
        // PART 2: BUILDER
        // ============================================================
        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // Сложный босс через BossEnemyBuilder
        Enemy fireDragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setCanFly(true)
                .setHasBreathAttack(true)
                .setWingspan(25)
                .build();

        System.out.println("Босс через BossEnemyBuilder:");
        fireDragon.displayInfo();
        System.out.println();

        // Простой враг через BasicEnemyBuilder
        Enemy iceMinion = new BasicEnemyBuilder()
                .setName("Ice Minion")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(30)
                .setAbilities(iceFactory.createAbilities())
                .setLootTable(iceFactory.createLootTable())
                .build();

        System.out.println("Простой враг через BasicEnemyBuilder:");
        iceMinion.displayInfo();
        System.out.println();

        // Director с пресетами
        EnemyDirector bossDirector = new EnemyDirector(BossEnemyBuilder::new);
        Enemy raidBoss = bossDirector.createRaidBoss(shadowFactory);

        System.out.println("Рейд-босс через Director:");
        raidBoss.displayInfo();
        System.out.println();

        System.out.println(">>> Builder: пошаговая сборка вместо 15-параметрового конструктора.");
        System.out.println(">>> Director: готовые пресеты (minion, elite, miniBoss, raidBoss).\n");

        // ============================================================
        // PART 3: PROTOTYPE
        // ============================================================
        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        // Создаём реестр и регистрируем шаблоны
        EnemyRegistry registry = new EnemyRegistry();

        Goblin baseGoblin = new Goblin("Goblin");
        Skeleton baseSkeleton = new Skeleton("Skeleton");
        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("skeleton", baseSkeleton);
        registry.registerTemplate("fire-dragon", fireDragon);

        System.out.println("Зарегистрированы шаблоны: " + registry.listTemplates());
        System.out.println();

        // Варианты гоблина
        Goblin eliteGoblin = (Goblin) registry.createFromTemplate("goblin");
        eliteGoblin.setName("Elite Goblin");
        eliteGoblin.multiplyStats(2.0);

        Goblin championGoblin = (Goblin) registry.createFromTemplate("goblin");
        championGoblin.setName("Champion Goblin");
        championGoblin.multiplyStats(5.0);
        championGoblin.addAbility(new FrostBreath());

        System.out.println("Варианты гоблина:");
        baseGoblin.displayInfo();
        System.out.println();
        eliteGoblin.displayInfo();
        System.out.println();
        championGoblin.displayInfo();
        System.out.println();

        // Проверка глубокого копирования
        System.out.println("--- Проверка глубокого копирования ---");
        System.out.println("У шаблона Goblin способностей: " + baseGoblin.getAbilities().size());
        System.out.println("У Champion Goblin способностей: " + championGoblin.getAbilities().size());
        System.out.println(">>> Шаблон не изменился — глубокое копирование работает!\n");

        // Варианты дракона
        DragonBoss iceDragon = (DragonBoss) registry.createFromTemplate("fire-dragon");
        iceDragon.setName("Ice Dragon");
        iceDragon.setElement("ICE");
        iceDragon.setAbilities(iceFactory.createAbilities());
        iceDragon.setLootTable(iceFactory.createLootTable());
        iceDragon.setAiBehavior("DEFENSIVE");

        System.out.println("Ice Dragon (вариант Fire Dragon):");
        iceDragon.displayInfo();
        System.out.println();

        System.out.println(">>> Prototype: клонируем шаблон, модифицируем — быстрее чем билдить заново.\n");

        // ============================================================
        // PART 4: ALL PATTERNS TOGETHER
        // ============================================================
        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        // 1. Abstract Factory создаёт Shadow-компоненты
        System.out.println("Step 1: Shadow Factory создаёт компоненты");

        // 2. Builder собирает Demon Lord
        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(80000)
                .setDamage(800)
                .setDefense(250)
                .setSpeed(45)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .addPhase(1, 80000)
                .addPhase(2, 40000)
                .addPhase(3, 20000)
                .build();

        System.out.println("Step 2: Builder собрал Demon Lord");
        demonLord.displayInfo();
        System.out.println();

        // 3. Регистрируем как шаблон Prototype
        registry.registerTemplate("demon-lord", demonLord);
        System.out.println("Step 3: Demon Lord зарегистрирован как шаблон");

        // 4. Клонируем варианты
        DragonBoss greaterDemon = (DragonBoss) registry.createFromTemplate("demon-lord");
        greaterDemon.setName("Greater Demon");
        greaterDemon.multiplyStats(1.5);

        DragonBoss archDemon = (DragonBoss) registry.createFromTemplate("demon-lord");
        archDemon.setName("Arch Demon");
        archDemon.multiplyStats(3.0);

        System.out.println("Step 4: Созданы варианты через Prototype");
        System.out.println();
        greaterDemon.displayInfo();
        System.out.println();
        archDemon.displayInfo();
        System.out.println();

        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println();
        System.out.println("Abstract Factory: тематические семейства компонентов (Fire, Ice, Shadow)");
        System.out.println("Builder: пошаговая сборка сложных врагов (BossEnemyBuilder, BasicEnemyBuilder)");
        System.out.println("Factory Method: build() в билдерах, Director вызывает его полиморфно");
        System.out.println("Prototype: клонирование шаблонов для быстрого создания вариантов");
        System.out.println();

        // Расширяемость (5.2)
        System.out.println("--- Расширяемость ---");
        System.out.println("Добавить тему Nature: создать NatureComponentFactory (implements EnemyComponentFactory)");
        System.out.println("Добавить врага Lich: создать класс Lich (implements Enemy) + LichBuilder если нужно");
        System.out.println("Добавить Mythic-уровень: registry.createFromTemplate() + multiplyStats(20.0)");

        System.out.println("\n=== Demo Complete ===");
    }

    private static void printFactoryComponents(EnemyComponentFactory factory) {
        List<Ability> abilities = factory.createAbilities();
        LootTable loot = factory.createLootTable();
        String ai = factory.createAIBehavior();

        System.out.println("  Abilities: ");
        for (Ability a : abilities) {
            System.out.println("    - " + a.getName());
        }
        System.out.println("  Loot: " + loot.getLootInfo());
        System.out.println("  AI: " + ai);
        System.out.println();
    }
}
