package model.tests;
/**
* Tests for Raised Hole class implementation
* @author Adela Tullio
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RaisedHoleTest {
	private RaisedHole raisedhole;
	private GameBoard gameboard;
	private Mushroom mushroom;
	
	/**
	* Set up the variables
	*/
	@Before
	public void setUp() throws Exception {
		raisedhole = new RaisedHole();
		gameboard = new GameBoard();
		mushroom = new Mushroom();
	}
	
	/**
	* Tear down the variables
	*/
	@After
	public void tearDown() throws Exception {
		raisedhole = null;
		gameboard = null;
		mushroom = null;
	}

	/**
	 * Tests the toString method
	 */
	@Test
	public void testEmptyHoleToString() {
		assertEquals("Should be 'RH'.", "RH", raisedhole.toString());
	}
}
