package modeltests;
import model.*;
/**
* Tests for the BrownHole class 
* @author Adela Tullio
*
*/
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrownHoleTest {
	private BrownHole bh;
	private Mushroom mushroom;
	
	/**
	* Sets up the variables
	* @throws Exception 
	*/
	@Before
	public void setUp() throws Exception {
		bh = new BrownHole();
		mushroom = new Mushroom();
		
	}
	
	/**
	* Tear down method
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		bh = null;
		mushroom = null;
	}
	
	/**
	* Tests the toString method
	* of an empty brown hole
	*/
	@Test
	public void testToStringEmptyBrownHole() {
		assertEquals("String should be 'BH'.", "BH", bh.toString());
	}
	
	/**
	 * Tests the ToString method
	 * with a piece inside
	 */
	@Test
	public void testToStringFilledBrownHole() {
		bh.setPiece(mushroom);
		assertEquals("String should be 'MS'", "MS", bh.toString());
	}
}
