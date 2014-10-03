package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Position;

public class SquaredArea extends Area {
	
	private int distance;
	
	public SquaredArea(Position givenCenter, int distanceToEdge) {
		super(givenCenter);
		this.distance = distanceToEdge;
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
	
	@Override
	public boolean positionIsWithinArea(Position position) {
		return (this.positionIsWithinHorizontalRange(position)
			 && this.positionIsWithinVerticalRange(position));
	}
	
}
