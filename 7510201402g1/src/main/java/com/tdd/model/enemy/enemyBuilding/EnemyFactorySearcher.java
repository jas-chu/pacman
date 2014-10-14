package com.tdd.model.enemy.enemyBuilding;

import java.util.HashMap;

/**
 *
 *
 */
public class EnemyFactorySearcher {

    public enum EnemyName {

        GHOST
    }
    private final HashMap<EnemyName, EnemyFactory> factorySearcher;

    public EnemyFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(EnemyName.GHOST, new GhostFactory());
    }
        /**
     *
     * @param name
     * @return
     */
    public EnemyFactory getFactory(String name) {
        return this.factorySearcher.get(nameToEnemyname(name));
    }
    /**
     * Por ahora esta harcodeado que retorne un fantasma. 
     * Mas adelante se puede expandir a disintos tipos de enemigos
     * @param name
     * @return 
     */
    private EnemyName nameToEnemyname(String name){
        return EnemyName.GHOST;
    }
}
