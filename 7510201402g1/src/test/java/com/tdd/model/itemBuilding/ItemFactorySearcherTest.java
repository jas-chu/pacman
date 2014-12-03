package com.tdd.model.itemBuilding;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ItemFactorySearcherTest {
	
	ItemFactorySearcher searcher;
	
	@Before
	public void setUp() {
		this.searcher = new ItemFactorySearcher();
	}
	
    @Test
	public void createTest() {
		assert(this.searcher != null);
	}
	
	@Test
	public void searchInvalidFactoryTest() {
		try {
			this.searcher.getFactory("blabla");
			fail();
		} catch (NoAvailableFactoryException ex) {
			assert(true);
		}
	}
	
	@Test
	public void searchValidFactoryTest() {
		try {
			this.searcher.getFactory(XMLConstants.DOT);
			assert(true);
		} catch (NoAvailableFactoryException ex) {
			fail();
		}
	}

}