package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RaisedHoleTest {
	private RaisedHole raisedhole;
	private GameBoard gameboard;
	private Mushroom mushroom;

	@Before
	public void setUp() throws Exception {
		raisedhole = new RaisedHole();
		gameboard = new GameBoard();
		mushroom = new Mushroom();
	}

	@After
	public void tearDown() throws Exception {
		raisedhole = null;
		gameboard = null;
		mushroom = null;
	}

	/**
	 * Tests what ToString() outputs if the
	 * hole is empty
	 */
	@Test
	public void testEmptyHoleToString() {
		assertEquals("Should be 'RH'.", "RH", raisedhole.toString());
	}
	
	@Test
	public void testTakenHoleToString() {
		
	}
}
