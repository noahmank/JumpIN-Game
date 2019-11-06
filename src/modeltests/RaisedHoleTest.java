package modeltests;
import model.*;
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
	private Mushroom mushroom;
	
	/**
	* Set up the variables
	*/
	@Before
	public void setUp() throws Exception {
		raisedhole = new RaisedHole();
		mushroom = new Mushroom();
	}
	
	/**
	* Tear down the variables
	*/
	@After
	public void tearDown() throws Exception {
		raisedhole = null;
		mushroom = null;
	}

	/**
	 * Tests the toString method
	 * of an empty raised hole
	 */
	@Test
	public void testEmptyHoleToString() {
		assertEquals("Should be 'RH'.", "RH", raisedhole.toString());
	}
	
	/**
	 * Tests toString method
	 * with a piece in it
	 */
	@Test
	public void testOccupiedHoleToString() {
		raisedhole.setPiece(mushroom);
		assertEquals("Should be 'MS'", "MS", raisedhole.toString());
	}
}
