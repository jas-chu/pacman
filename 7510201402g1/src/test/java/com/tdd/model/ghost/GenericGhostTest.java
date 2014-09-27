package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Position;
import java.util.ArrayList;
import org.junit.Before;

public class GenericGhostTest {
	
	protected StateFactory factory;
	protected Ghost ghost;
	protected Ghost anotherGhost;
	protected Position position;

	@Before
	public void setUp() {
		this.position = new Position(0, 0);
		ArrayList<Long> angerWaitingCycles = new ArrayList<Long>();
		angerWaitingCycles.add(new Long(3));
		angerWaitingCycles.add(new Long(2));
		angerWaitingCycles.add(new Long(5));
		this.factory = new StateFactory(angerWaitingCycles, 4, 7);
		this.ghost = new Ghost(position, this.factory);
		this.anotherGhost = new Ghost(position, this.factory);
	}
	
}
