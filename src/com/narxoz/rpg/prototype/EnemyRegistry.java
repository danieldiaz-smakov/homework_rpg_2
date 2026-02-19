package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** Реестр шаблонов врагов. По ключу возвращает клон, не оригинал. */
public class EnemyRegistry {

    private final Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template) {
        if (key == null || key.trim().isEmpty()) {
            throw new IllegalArgumentException("Template key must be non-empty");
        }
        if (template == null) {
            throw new IllegalArgumentException("Template must not be null");
        }
        templates.put(key, template);
    }

    /** Возвращает клон шаблона по ключу. */
    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) {
            throw new IllegalArgumentException("Unknown template: " + key);
        }
        return template.clone();
    }

    public Set<String> listTemplates() {
        return Collections.unmodifiableSet(templates.keySet());
    }
}
