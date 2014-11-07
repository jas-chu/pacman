package com.tdd.model.stageAbstractions;

public interface Collidable {
	
	/**
	 * Element to Element collision.
	 * @param anotherElement
	 */
	void collideWithElement(StageElement anotherElement);

	/**
	 * Element to Protagonist collision.
	 * @param givenProtagonist
	 */
	void collideWithProtagonist(Protagonist givenProtagonist);
	
	/**
	 * Element to Consumable collision.
	 * @param givenConsumable
	 */
	void collideWithConsumable(Consumable givenConsumable);
	
	/**
	 * Element to Enemy collision.
	 * Special behavior: Calls another collision method to determine
	 * the state and therefore, behavior of the enemy.
	 * @param givenEnemy
	 */
	void collideWithEnemy(Enemy givenEnemy);
	
}
