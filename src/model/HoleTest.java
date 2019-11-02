package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HoleTest {
	private Hole hole;
	
	
	@Before
	public void setUp() throws Exception {
		hole = new Hole();
	}

	@After
	public void tearDown() throws Exception {
		hole = null;
	}

	
	@Test
	public void testRemovePiece() {
		Rabbit rabbit = new Rabbit("Grey");
		hole.setPiece(rabbit);
		hole.removePiece(rabbit);
	}
	
	@Test
	public void testRemoveMushroom() {
		Mushroom mushroom = new Mushroom();
		hole.setPiece(mushroom);
		hole.removePiece(mushroom);
	}
	
	@Test
	public void testToString() {
		assertEquals("Should be '  '", "  ", hole.toString());
	}

}
