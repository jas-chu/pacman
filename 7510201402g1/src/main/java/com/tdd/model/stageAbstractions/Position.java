package com.tdd.model.stageAbstractions;

public class Position {
	
	private int x, y;
	
	private void initialize(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(int xValue, int yValue) {
		this.initialize(xValue, yValue);
	}

	public Position(Position anotherPosition) {
		this.initialize(anotherPosition.getX(), anotherPosition.getY());
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int calculateXAddingValue(int value) {
		return this.getX() + value;
	}
	
	public int calculateXSubstractingValue(int value) {
		return this.getX() - value;
	}
	
	public int calculateYAddingValue(int value) {
		return this.getY() + value;
	}
	
	public int calculateYSubstractingValue(int value) {
		return this.getY() - value;
	}
	
	public Position createPositionAddingX(int givenX) {
		int newX = this.calculateXAddingValue(givenX);
		return new Position(newX, this.getY());
	}
	
	public Position createPositionSubstractingX(int givenX) {
		int newX = this.calculateXSubstractingValue(givenX);
		return new Position(newX, this.getY());
	}

	public Position createPositionAddingY(int givenY) {
		int newY = this.calculateYAddingValue(givenY);
		return new Position(this.getX(), newY);
	}
	
	public Position createPositionSubstractingY(int givenY) {
		int newY = this.calculateYSubstractingValue(givenY);
		return new Position(this.getX(), newY);
	}
	
	public boolean hasEqualX(int anotherX) {
		return (this.getX() == anotherX);
	}
	
	public boolean hasLesserX(int anotherX) {
		return (this.getX() < anotherX);
	}
	
	public boolean hasLesserOrEqualX(int anotherX) {
		return (this.hasLesserX(anotherX) || this.hasEqualX(anotherX));
	}
	
	public boolean hasGreaterX(int anotherX) {
		return (this.getX() > anotherX);
	}
	
	public boolean hasGreaterOrEqualX(int anotherX) {
		return (this.hasGreaterX(anotherX) || this.hasEqualX(anotherX));
	}
	
	public boolean hasEqualX(Position anotherPosition) {
		return this.hasEqualX(anotherPosition.getX());
	}
	
	public boolean hasLesserX(Position anotherPosition) {
		return this.hasLesserX(anotherPosition.getX());
	}
	
	public boolean hasLesserOrEqualX(Position anotherPosition) {
		return this.hasLesserOrEqualX(anotherPosition.getX());
	}
	
	public boolean hasGreaterX(Position anotherPosition) {
		return this.hasGreaterX(anotherPosition.getX());
	}
	
	public boolean hasGreaterOrEqualX(Position anotherPosition) {
		return this.hasGreaterOrEqualX(anotherPosition.getX());
	}
	
	public boolean hasEqualY(int anotherY) {
		return (this.getY() == anotherY);
	}
	
	public boolean hasLesserY(int anotherY) {
		return (this.getY() < anotherY);
	}
	
	public boolean hasLesserOrEqualY(int anotherY) {
		return (this.hasLesserY(anotherY) || this.hasEqualY(anotherY));
	}
	
	public boolean hasGreaterY(int anotherY) {
		return (this.getY() > anotherY);
	}
	
	public boolean hasGreaterOrEqualY(int anotherY) {
		return (this.hasGreaterY(anotherY) || this.hasEqualY(anotherY));
	}
	
	public boolean hasEqualY(Position anotherPosition) {
		return this.hasEqualY(anotherPosition.getY());
	}
	
	public boolean hasLesserY(Position anotherPosition) {
		return this.hasLesserY(anotherPosition.getY());
	}
	
	public boolean hasLesserOrEqualY(Position anotherPosition) {
		return this.hasLesserOrEqualY(anotherPosition.getY());
	}
	
	public boolean hasGreaterY(Position anotherPosition) {
		return this.hasGreaterY(anotherPosition.getY());
	}
	
	public boolean hasGreaterOrEqualY(Position anotherPosition) {
		return this.hasGreaterOrEqualY(anotherPosition.getY());
	}
	
	public boolean equals(Position anotherPosition) {
		return (this.hasEqualX(anotherPosition) && this.hasEqualY(anotherPosition));
	}
	
}
