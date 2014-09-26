package com.tdd.model.stageAbstractions;

import com.tdd.model.stageAbstractions.Position;

public class SquaredArea {
	
	private Position center;
	private int distance;
	
	public SquaredArea(Position passedCenter, int distanceToEdge) {
		this.center = new Position(passedCenter);
		this.distance = distanceToEdge;
	}
	
	public void centerOn(Position position) {
		this.center = new Position(position);
	}
	
	private boolean positionIsWithinHorizontalRange(Position position) {
		int greaterVerticalEdge = this.center.calculateXAddingValue(this.distance);
		int lesserVerticalEdge = this.center.calculateXSubstractingValue(this.distance);
		
		return (position.hasLesserOrEqualX(greaterVerticalEdge)
			 && position.hasGreaterOrEqualX(lesserVerticalEdge));
	}
	
	private boolean positionIsWithinVerticalRange(Position position) {
		int greaterHorizontalEdge = this.center.calculateYAddingValue(this.distance);
		int lesserHorizontalEdge = this.center.calculateYSubstractingValue(this.distance);
		
		return (position.hasLesserOrEqualY(greaterHorizontalEdge)
			 && position.hasGreaterOrEqualY(lesserHorizontalEdge));
	}
	
	public boolean positionIsWithinArea(Position position) {
		return (this.positionIsWithinHorizontalRange(position)
			 && this.positionIsWithinVerticalRange(position));
	}
	
}
