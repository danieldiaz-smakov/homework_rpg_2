package com.narxoz.rpg;

import com.narxoz.rpg.builder.DragonBossBuilder;
import com.narxoz.rpg.builder.GoblinBuilder;
import com.narxoz.rpg.builder.SkeletonBuilder;
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
        System.out.println("=== RPG Enemy System \n");

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

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // Сложный босс через DragonBossBuilder
        Enemy fireDragon = new DragonBossBuilder()
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

        System.out.println("Босс через DragonBossBuilder:");
        fireDragon.displayInfo();
        System.out.println();

        // Гоблин через GoblinBuilder
        Enemy iceGoblin = new GoblinBuilder()
                .setName("Ice Goblin")
                .setHealth(120)
                .setAbilities(iceFactory.createAbilities())
                .setLootTable(iceFactory.createLootTable())
                .build();

        System.out.println("Goblin через GoblinBuilder:");
        iceGoblin.displayInfo();
        System.out.println();

        // Скелет через SkeletonBuilder
        Enemy iceSkeleton = new SkeletonBuilder()
                .setName("Ice Skeleton")
                .setAbilities(iceFactory.createAbilities())
                .setLootTable(iceFactory.createLootTable())
                .build();

        System.out.println("Skeleton через SkeletonBuilder (дефолтные статы):");
        iceSkeleton.displayInfo();
        System.out.println();

        // Director с пресетами
        EnemyDirector bossDirector = new EnemyDirector(DragonBossBuilder::new);
        Enemy raidBoss = bossDirector.createRaidBoss(shadowFactory);

        System.out.println("Рейд-босс через Director:");
        raidBoss.displayInfo();
        System.out.println();

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


        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        // 1. Abstract Factory создаёт Shadow-компоненты
        System.out.println("Step 1: Shadow Factory создаёт компоненты");

        // 2. Builder собирает Demon Lord
        Enemy demonLord = new DragonBossBuilder()
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
