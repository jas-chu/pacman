package com.tdd.model.helpers;

import org.junit.Test;

public class RandomNumberGeneratorTest {

	@Test
    public void getRandomNumberBoundaries() {
		int result = RandomNumberGenerator.getRandomNumber(0, 10);
		assert(result <= 10);
		assert(result >= 0);
    }
	
	@Test
    public void getRandomNumber() {
		// This test may fail one over a million times.
		// Should it fail, run it again so as to be sure.
		int result1 = RandomNumberGenerator.getRandomNumber(0, 1000000);
		int result2 = RandomNumberGenerator.getRandomNumber(0, 1000000);
		assert(result1 != result2);
    }

}