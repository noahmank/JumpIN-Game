package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FoxTest {
	Fox fox;
	Direction direction;
	@Before
	public void setUp() throws Exception {
		fox = new Fox(direction.NORTH, 1);
	}

	@After
	public void tearDown() throws Exception {
		fox = null;
	}

	@Test
	public void testGetDirection() {
		assertEquals("Direction should be north.", direction.NORTH, fox.getDirection());
	}
	
	@Test
	public void testgetNumber() {
		assertEquals("Number should be 1.", 1, fox.getNumber());
	}
	
	@Test
	public void testToString() {
		assertEquals("Should be 'F1'.", "F1", fox.toString());
	}
}
